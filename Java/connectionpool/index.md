# 1、数据库连接池

## 1.1概念

​	数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个；释放空闲时间超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏。这项技术能明显提高对数据库操作的性能。

**面试题：什么是数据库连接池？**

目前的数据库连接做法：

​	需要链接数据就马上创建一个连接，使用完成之后，就将连接关闭了。下次使用在创建。。。。。。

​	实际上数据库的链接操作是比较耗费资源的。如果可以不频繁的创建和关闭连接，可以大幅度的提高效率。



白话数据库连接池：

​		我们预先创建好一部分连接，放在一个池中（集合），并且将这些连接标记为空闲状态。如果要使用连接就从池中获取一个连接使用，用完之后再次还回池中。

​		连接池自己应该有自动初始化功能，自动增长功能，自动缩减功能。

​		所谓自动增长就是当池中的连接都被使用之后，自动创建新的连接放入池中。

​		所谓自动缩减就是当池中的空闲连接过多时，自动关闭部分连接。

## 1.2自定义数据库连接池

创建一个类ConnectionPool作为连接池对象。

[1]连接池只能有一个，所以连接池对象应该是单利的。

```java
	//提供静态的私有的本类对象
	private static ConnectionPool pool;
	//构造方法私有化
	private ConnectionPool() {
			init();//在构造方法中初始化连接池
	}
	//提供静态的可以获取本类对象的方法。
	public synchronized static ConnectionPool getPool() {
		if(pool==null)
			pool = new ConnectionPool();
		return pool;
	};
```

[2]连接池中的属性

```java
	//成员属性
	//数据库连接属性
	private static String driverClass;
	private static String userName;
	private static String url;
	private static String password;
	//初始连接数量
	private static int initCount = 5;
	//最小连接数量
	private static int minCount = 5;
	//最大连接数量
	private static int maxCount = 15;
	//当前的连接数量
	private static int count;
	//使用集合存储连接
	LinkedList<Connection> conns = new LinkedList<Connection>();

	//成员属性初始化
	static {
		Properties properties = new Properties();
		try {
			properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties"));
			driverClass = properties.getProperty("jdbc.driverclass");
			url  = properties.getProperty("jdbc.url");
			userName = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			try {
				initCount = new Integer(properties.getProperty("jdbc.initCount"));
			} catch (NumberFormatException e) {
				System.out.println("initCount使用默认值："+initCount);
			}
			try {
				minCount = new Integer(properties.getProperty("jdbc.minCount"));
			} catch (NumberFormatException e) {
				System.out.println("minCount使用默认值："+minCount);
			}
			try {
				maxCount = new Integer(properties.getProperty("jdbc.maxCount"));
			} catch (NumberFormatException e) {
				System.out.println("maxCount使用默认值："+maxCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

不要忘记添加db.properties

```properties
jdbc.driverclass=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://192.168.30.21:3306/student?useUnicode=true&characterEncoding=utf8
jdbc.username=root
jdbc.password=1998528Xk
jdbc.initCount=8
jdbc.minCount=8
jdbc.maxCount=20
```

[3]自动初始化的功能

```java
	/**
	 * 初始化连接池
	 */
	private void init() {
		// 循环的给集合中添加初始化个数个链接
		for (int i = 0; i < initCount; i++) {
			boolean flag = conns.add(createCon());
			if(flag) {
				//添加成功之后就将给连接数量+1
				count ++;
			}
		}
		System.out.println("连接池初始化完成");
	}
	/**
	 * 创建一个可用的数据库连接
	 * @return
	 */
	private Connection createCon() {
		try {
			Class.forName(driverClass);
			return DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			throw new RuntimeException("链接创建失败："+e.getMessage());
		}
	}
```

[4]完成自动增长功能

```java
	/**
	 * 池中连接自动增长
	 */
	private synchronized void addAuto() {
		// 增长步长为2
		if (count == maxCount) {
			throw new RuntimeException("池中数量已经达到最大，不能再增长");
		}
		// 增长过程中，判断池中的个数
		for (int i = 0; i < 2; i++) {
			if (count == maxCount) {
				break;//如果已经到最大值，则直接结束循环
			}
			conns.add(createCon());
			count++;
		}
	}
```

是在池中没有连接时调用。

[5]从池中获取连接的方法

```java
	/**
	 * 从池中获取一个可用的连接
	 * @return
	 */
	public Connection getCon() {
		//判断池中是否有空闲链接
		if(conns.size()>0) {
			//如果有就直接返回
			return conns.removeFirst();
		}
		//如果池中没有空闲的连接
		//判断总连接数是否已经达到上限
		if(count < maxCount) {
			//让连接池自动增长
			addAuto();
			//自动增长完成之后，递归调用返回连接的方法
			return getCon();
		}
		//如果池中的连接数已经达到上限，就等一会再获取
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return  getCon();
	}
```

[6]池中的连接自动缩减

当连接总数量大于最小连接数量并且池中有空闲连接时，我们就关闭连接。

```java
	/**
	 * 连接池自动缩减的方法
	 */
	private synchronized void reduce() {
		//当连接数量大于最小连接数量，并且池中有空闲连接
		if(count > minCount && conns.size() > 0) {
			try {
				//从池中获取一个链接，并且关闭
				Connection con = conns.removeFirst();
				con.close();
				con = null;
                 //如果关闭了一个连接，就将当前的链接数量-1
				count--;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
```

[7]连接池还回连接的操作

```java
	/**
	 * 还回连接到池中
	 * @param con
	 */
	public void returnCon(Connection con) {
		//将连接直接放入集合
		conns.add(con);
		//连接还回之后，马上缩减连接池
		reduce();
	}
```

[8]连接池的使用

给项目中添加连接池的类，和配置文件。

修改JDBCTool

```java
package com.authority.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.igeek.pool.ConnectionPool;
public class JDBCTool {
	public static Connection getConn() {
		//从连接池直接获取
		return ConnectionPool.getPool().getCon();
	}
	
	public static void closeAll(Statement st,ResultSet rs,Connection con) {
		try {
			if(st!=null) {
				st.close();
			}
			if(rs!=null)
				rs.close();
			if(con!=null) {
				//将连接还回池中
				ConnectionPool.getPool().returnCon(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
```

# 2、常见的数据库连接池

[1]C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。目前使用它的开源项目有Hibernate、Spring等。

[2]DBCP 是 Apache 软件基金组织下的开源连接池实现，Tomcat 的连接池正是采用该连接池来实现的。该数据库连接池既可以与应用服务器整合使用，也可由应用程序独立使用。

[3]druid（德鲁伊）

​		DRUID是阿里巴巴开源平台上一个数据库连接池实现，它结合了C3P0、DBCP、PROXOOL等DB池的优点，同时加入了日志监控，可以很好的监控DB池连接和SQL的执行情况，可以说是针对监控而生的DB连接池，据说是目前最好的连接池。



druid配置参数

| 配置                            | 缺省值          | 说明                                       |
| ----------------------------- | ------------ | ---------------------------------------- |
| name                          |              | 配置这个属性的意义在于，如果存在多个数据源，监控的时候可以通过名字来区分开来。 如果没有配置，将会生成一个名字，格式是："DataSource-" + System.identityHashCode(this) |
| jdbcUrl                       |              | 连接数据库的url，不同数据库不一样。例如： mysql : jdbc:mysql://10.20.153.104:3306/druid2  oracle : jdbc:oracle:thin:@10.20.149.85:1521:ocnauto |
| username                      |              | 连接数据库的用户名                                |
| password                      |              | 连接数据库的密码。如果你不希望密码直接写在配置文件中，可以使用ConfigFilter。详细看这里：[https://github.com/alibaba/druid/wiki/%E4%BD%BF%E7%94%A8ConfigFilter](https://github.com/alibaba/druid/wiki/使用ConfigFilter) |
| driverClassName               | 根据url自动识别    | 这一项可配可不配，如果不配置druid会根据url自动识别dbType，然后选择相应的driverClassName |
| initialSize                   | 0            | 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时 |
| maxActive                     | 8            | 最大连接池数量                                  |
| maxIdle                       | 8            | 已经不再使用，配置了也没效果                           |
| minIdle                       |              | 最小连接池数量                                  |
| maxWait                       |              | 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。 |
| poolPreparedStatements        | false        | 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。 |
| maxOpenPreparedStatements     | -1           | 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100 |
| validationQuery               |              | 用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。 |
| testOnBorrow                  | true         | 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。 |
| testOnReturn                  | false        | 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能 |
| testWhileIdle                 | false        | 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。 |
| timeBetweenEvictionRunsMillis |              | 有两个含义： 1) Destroy线程会检测连接的间隔时间 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明 |
| numTestsPerEvictionRun        |              | 不再使用，一个DruidDataSource只支持一个EvictionRun   |
| minEvictableIdleTimeMillis    |              |                                          |
| connectionInitSqls            |              | 物理连接初始化的时候执行的sql                         |
| exceptionSorter               | 根据dbType自动识别 | 当数据库抛出一些不可恢复的异常时，抛弃连接                    |
| filters                       |              | 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有： 监控统计用的filter:stat 日志用的filter:log4j 防御sql注入的filter:wall |
| proxyFilters                  |              | 类型是List<com.alibaba.druid.filter.Filter>，如果同时配置了filters和proxyFilters，是组合关系，并非替换关系 |



使用：

①下载jar文件：  http://druid.apache.org/downloads.html

②将jar文件添加到classpath中。

③添加配置文件：

druid.properties

```properties
jdbcUrl=jdbc:mysql://192.168.30.21:3306/student?useUnicode=true&characterEncoding=utf8
username=root
password=1998528Xk
initialSize=5
maxActive=15
minIdle=5
maxWait=3000
```

④编写程序获取数据源对象。

数据源对象：java.sql.DataSource接口对象。

表示数据源，可以直接理解为连接池。所有的连接池都会有一个数据源实现这个接口。

Druid实现这个数据源的类是: DruidDataSource。

编程实现数据源：

```java
package com.igeek.pool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
public class DruidTest {
	public static void main(String[] args) throws IOException, SQLException {
		//需要加载配置文件
		Properties p = new Properties();
		p.load(DruidTest.class.getClassLoader().getResourceAsStream("druid.properties"));
		//创建数据源对象
		DataSource dataSource = new DruidDataSource();
		//设置属性
		DruidDataSource ds = (DruidDataSource)dataSource;
		ds.setUrl(p.getProperty("jdbcUrl"));
		ds.setPassword(p.getProperty("password"));
		ds.setUsername(p.getProperty("username"));
		ds.setInitialSize(new Integer(p.getProperty("initialSize")));
		ds.setMaxActive(new Integer(p.getProperty("maxActive")));
		ds.setMinIdle(new Integer(p.getProperty("minIdle")));
		ds.setMaxWait(new Long(p.getProperty("maxWait")));
		//可以直接通过数据源获取可用的链接
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
```

⑤在项目中使用

```java
package com.authority.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.igeek.pool.ConnectionPool;
public class JDBCTool {
	private static DataSource dataSource;
	static {
		// 需要加载配置文件
		try {
			Properties p = new Properties();
			p.load(JDBCTool.class.getClassLoader().getResourceAsStream("druid.properties"));
			// 创建数据源对象
			dataSource = new DruidDataSource();
			// 设置属性
			DruidDataSource ds = (DruidDataSource) dataSource;
			ds.setUrl(p.getProperty("jdbcUrl"));
			ds.setPassword(p.getProperty("password"));
			ds.setUsername(p.getProperty("username"));
			ds.setInitialSize(new Integer(p.getProperty("initialSize")));
			ds.setMaxActive(new Integer(p.getProperty("maxActive")));
			ds.setMinIdle(new Integer(p.getProperty("minIdle")));
			ds.setMaxWait(new Long(p.getProperty("maxWait")));
			dataSource = ds;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("创建连接池失败："+e.getMessage());
		}
	}

	public static Connection getConn() {
		// 可以直接通过数据源获取可用的链接
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接失败:"+e.getMessage());
		}
	}

	public static void closeAll(Statement st, ResultSet rs, Connection con) {
		try {
			if (st != null) {
				st.close();
			}
			if (rs != null)
				rs.close();
			if (con != null) {
				// 将连接还回池中
				//使用druid获取的链接，直接关闭即可。
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
```

> 项目中使用： 配置文件，jar文件不要忘记。
>
> 修改JDBCTool类。
>
> 创建数据源对象。获取连接时直接使用数据源获取即可。
>
> 关闭连接时直接关闭即可。这个数据源返回的连接和我们使用DriverManger获取的链接是略有不同的， 理论上说应该是我们自己通过DriverManger获取的链接的代理对象。代理对象修改了原生对象的一部分功能，特别是close方法。代理Connection的close方法实际操作是：首先判断池中是否有过多的空闲连接，如果超过过了最大的空闲连接数，close会直接关闭连接，并且将这个连接对象从池中排除。如果池中的空闲连接数量并不大于最大空闲连接数量，就不会关闭连接，而是标记为空闲状态。
>

# 3、BaseDAO的开发

编写一个BaseDAO将获取连接和关闭连接的方法写在BaseDAO中，这时我们的dao继承BaseDAO，就直接拥有了getConn和closeAll方法。

在BaseDAO中封装一个executeUpdate的方法，专门用来执行增删改的操作。

```java
	/**
	 * 执行所有的增删改操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql,Object ... params){
		Connection con = getConn();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			//设置参数。若是模糊查询，先设置好再传递过来；若是日期，在sql中就使用to_date先写好。
			for(int i = 0;i<params.length;i++) {
				pst.setString(i+1,params[i]!=null?params[i].toString():null);
			}
			//执行sql语句
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
        	closeAll(pst, null, con);//别忘记关闭
        }
	}
```

sql：要执行的sql语句

params:可变参数，要传入的参数，顺序要和sql中的“？”占位符一致。



封装一个查询的方法：

```java
	/**
	 * 统一查询一行的数据执行方法
	 * @param sql
	 * @param params
	 * @return  返回一个map，map的key是列名，value是查询的值String类型(查询出后自己转类型)
	 */
	public Map<String,String> queryRow(String sql,Object ... params){
		Map<String,String> rsMap = null;
		Connection con = getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			//设置参数
			for(int i = 0;i<params.length;i++) {
				pst.setString(i+1,params[i]!=null?params[i].toString():null);
			}
			//执行sql语句
			rs = pst.executeQuery();
			if(rs.next()) {
				rsMap = new HashMap<String, String>();
				//查询列名
				ResultSetMetaData metaData = rs.getMetaData();
				//获取列的数量
				int columnCount = metaData.getColumnCount();
				for (int i = 1; i <=columnCount; i++) {
					//查列名
					String columnName = metaData.getColumnName(i);
					rsMap.put(columnName, rs.getString(columnName));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			closeAll(pst, rs, con);
		}
		return rsMap;
	}
	
	
	/**
	 * 统一查询多行的数据执行方法
	 * @param sql
	 * @param params
	 * @return  返回一个map，map的key是列明，value是查询的值
	 */
	public List<Map<String,String>> queryList(String sql,Object ... params){
		List<Map<String,String>> rsList = new ArrayList<Map<String,String>>();
		Connection con = getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			//设置参数
			for(int i = 0;i<params.length;i++) {
				pst.setString(i+1,params[i]!=null?params[i].toString():null);
			}
			//执行sql语句
			rs = pst.executeQuery();
			while(rs.next()) {
				Map<String,String> rsMap = new HashMap<String, String>();
				//查询列名
				ResultSetMetaData metaData = rs.getMetaData();
				//获取列的数量。从1开始。
				int columnCount = metaData.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					//查列名
					String columnName = metaData.getColumnName(i);
					rsMap.put(columnName, rs.getString(columnName));
				}
				
				//将map添加到集合中
				rsList.add(rsMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			closeAll(pst, rs, con);
		}
		return rsList;
	}
	
	public static void main(String[] args) {
		//查询单行数据
		String sql = "select * from t_user where userId = ?";
		Map<String, String> userMap = new BaseDAO().queryRow(sql, 1);
		System.out.println(userMap);
		User u = new User();
		u.setUserId(new Integer(userMap.get("userId")));
		///......
		//查询多行数据
		sql = "select * from t_user";
		List<Map<String, String>> userList = new BaseDAO().queryList(sql);
		System.out.println(userList);
	}
```

