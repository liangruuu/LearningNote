## 1. Jackson 是什么

Jackson 是用来解析 JSON 的框架。JSON （JavaScript Object Notation）是一种数据格式，用来在客户端和服务器之间，或系统组件之间交换数据。

## 2. Jackson 环境设置

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.9.9</version>
</dependency>
```

## 3. Jackson ObjectMapper

Jackson 的 ObjectMapper 可以非常轻松的帮我们实现对象和 JSON 的互转，下面是一个简单的例子。

```java
package shangbo.jackson.demo1;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();

		// 将对象转成 json
		String json = objectMapper.writeValueAsString(newPerson());
		System.out.println(json);

		// 将 json 转成对象
		Person shangbo = objectMapper.readValue(json, Person.class);
		System.out.println(shangbo);
	}

	private static Person newPerson() {
		List<PhoneNumber> phones = new ArrayList<>();

		PhoneNumber phone = new PhoneNumber();
		phone.setCode("86");
		phone.setNumber("0411-12345678");
		phones.add(phone);

		PhoneNumber cell = new PhoneNumber();
		cell.setCode("86");
		cell.setNumber("18912345678");
		phones.add(cell);

		Address address = new Address();
		address.setState("LiaoNing");
		address.setCity("DaLian");
		address.setStreat("GaoXingQu");

		Person shangbo = new Person();
		shangbo.setFirstname("Bo");
		shangbo.setLastname("Shang");
		shangbo.setAddress(address);
		shangbo.setPhones(phones);

		return shangbo;
	}
}
```

```java
package shangbo.jackson.demo1;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
	private String firstname;
	private String lastname;
	private Address address;
	private List<PhoneNumber> phones;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

```java
package shangbo.jackson.demo1;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address {
	private String state;
	private String city;
	private String streat;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

```java
package shangbo.jackson.demo1;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PhoneNumber {
	private String code;
	private String number;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

## 4. Jackson 读写 JSON

ObjectMapper 提供了下面的 readValue 方法，帮助我们很方便的从不同的数据源读取对象。

```java
readValue(String src, ...)
readValue(File src, ...)
readValue(URL src, ...)
readValue(InputStream src, ...)
readValue(DataInput src, ...)
readValue(Reader src, ...)
readValue(byte[] src, ...)
```

ObjectMapper 也提供了下面的 writeValue 方法，帮助我们很方便的将对象输出到不同的目的地。

```java
writeValueAsString(...)
writeValue(File desc, ...)
writeValue(File desc, ...)
writeValue(OutSteam desc, ...)
writeValue(DataOutput desc, ...)
writeValue(Writer desc, ...)
writeValueAsBytes(...)
```

我们还可以读取 JSON 到数组（Array），列表（List）和映射（Map）中，下面是三个简答的例子。

```java
package shangbo.jackson.demo2;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();

		// json 消息
		String json = "[{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}, {\"firstname\":\"San\",\"lastname\":\"Zhang\"}]";

		// 将 json 转成数组
		Person[] people = objectMapper.readValue(json, Person[].class);
		for(Person p: people) {
			System.out.println(p);
		}
	}
}
```

```java
package shangbo.jackson.demo3;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();

		// json 消息
		String json = "[{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}, {\"firstname\":\"San\",\"lastname\":\"Zhang\"}]";

		// 将 json 转成列表
		List<Person> people = objectMapper.readValue(json, new TypeReference<List<Person>>(){});
		for(Person p: people) {
			System.out.println(p);
		}
	}
}
```

```java
package shangbo.jackson.demo4;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();

		// json 消息
		String json = "{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}";

		// 将 json 转成映射
		Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		System.out.println(map);
	}
}
```

## 5. Jackson 配置 ObjectMapper

### 5.1 配置日期格式

默认情况下，Jackson 会将日期转成 long 值，我们也可以设置日期格式，将日期转成字符串，下面是一个简单的例子。

```java
package shangbo.jackson.demo5;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();
		
		// 设置日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(dateFormat);

		// 将对象转成 json
		String json = objectMapper.writeValueAsString(newPerson());
		System.out.println(json);

		// 将 json 转成对象
		Person shangbo = objectMapper.readValue(json, Person.class);
		System.out.println(shangbo);
	}

	private static Person newPerson() {
		Person shangbo = new Person();
		shangbo.setFirstname("Bo");
		shangbo.setLastname("Shang");
		shangbo.setBrithday(new Date());
		
		return shangbo;
	}
}
```

### 5.2 忽略未知字段

通常 JSON 消息和 Java 类的字段必须相对应，否则解析 JSON 会报错，当然我们也可以通过配置使它不报错。

```java
package shangbo.jackson.demo6;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略未知字段

		// json 消息
		String json = "{\"firstname\":\"Bo\",\"lastname\":\"Shang\",\"brithday\":\"2019-05-25\"}";

		// 将 json 转成对象，忽略 brithday
		Person shangbo = objectMapper.readValue(json, Person.class);
		System.out.println(shangbo);
	}
}
```

更多配置详见 DeserializationFeature 和 SerializationFeature

## 6. Jackson 注解 -- 忽略字段

如果在读写 JSON 时，我们想忽略某些字段，我们可以使用下面的注解。

@JsonIgnore

```java
package shangbo.jackson.demo7;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {
	private String firstname;
	private String lastname;
	
	@JsonIgnore
	private Date brithday;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

@JsonIgnoreProperties

```java
package shangbo.jackson.demo8;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"brithday"})
public class Person {
  private String firstname;
  private String lastname;
  private Date brithday;

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

@JsonIgnoreType

```java
package shangbo.jackson.demo9;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class Address {
	private String state;
	private String city;
	private String streat;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

```java
package shangbo.jackson.demo9;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
  private String firstname;
  private String lastname;
  private Address address;

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

## 7. Jackson 注解 -- 忽略空字段

默认情况下，空字段也会被输出，我们可以使用 @JsonInclude 不输出空字段。

```java
package shangbo.jackson.demo10;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person {
  private String firstname;
  private String lastname;

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

```java
package shangbo.jackson.demo10;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // 将对象转成 json
    String json = objectMapper.writeValueAsString(newPerson());
    System.out.println(json);
  }

  private static Person newPerson() {
    Person shangbo = new Person();
    shangbo.setFirstname("Bo");
    //		shangbo.setLastname("Shang");

    return shangbo;
  }
}
```

## 8. Jackson 注解 -- 修改字段名

如果 JSON 和对象字段名不匹配，我们可以使用注解 @JsonGetter 和 @JsonSetter

```java
package shangbo.jackson.demo11;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Person {
	private String firstname;
	private String lastname;
	private Date birthday;

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @JsonGetter("age")
  public Date getBirthday() {
    return birthday;
  }

  @JsonSetter("age")
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
}
```

```java
package shangbo.jackson.demo11;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // 将对象转成 json
    String json = objectMapper.writeValueAsString(newPerson());
    System.out.println(json);

    // 将 json 转成对象
    Person shangbo = objectMapper.readValue(json, Person.class);
    System.out.println(shangbo);
  }

  private static Person newPerson() {
    Person shangbo = new Person();
    shangbo.setFirstname("Bo");
    shangbo.setLastname("Shang");
    shangbo.setBirthday(new Date());

    return shangbo;
  }
}
```

## 9. Jackson 注解 -- 指定输出顺序

默认情况下，字段的输出顺序和它们在类中的位置一致，我们也可以使用注解 @JsonPropertyOrder 自己指定顺序。

```java
package shangbo.jackson.demo12;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"firstname", "lastname", "birthday"})
public class Person {
  private String firstname;
  private Date birthday;
  private String lastname;

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

```java
package shangbo.jackson.demo12;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // 将对象转成 json
    String json = objectMapper.writeValueAsString(newPerson());
    System.out.println(json);

    // 将 json 转成对象
    Person shangbo = objectMapper.readValue(json, Person.class);
    System.out.println(shangbo);
  }

  private static Person newPerson() {
    Person shangbo = new Person();
    shangbo.setFirstname("Bo");
    shangbo.setBirthday(new Date());
    shangbo.setLastname("Shang");

    return shangbo;
  }
}
```

## 10. Jackson 注解 -- 输出 JSON 字段

如果一个对象中某个字段中的值是 JSON，输出整个对象会有问题，这时我们可以使用注解 @JsonRawValue

```java
package shangbo.jackson.demo13;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class Person {
  private String firstname;
  private String lastname;

  @JsonRawValue
  private String address;

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

```java
package shangbo.jackson.demo13;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // 将对象转成 json
    String json = objectMapper.writeValueAsString(newPerson());
    System.out.println(json);
  }

  private static Person newPerson() {
    Person shangbo = new Person();
    shangbo.setFirstname("Bo");
    shangbo.setLastname("Shang");
    shangbo.setAddress("{\"country\":\"China\", \"city\":\"Dalian\"}");

    return shangbo;
  }
}
```

## 11. Jackson 注解 -- 自定义输出格式

如果你想完全定义输出的格式，我们可以使用注解 @JsonValue

```java
package shangbo.jackson.demo14;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonValue;

public class Person {
	private String firstname;
	private String lastname;

	@JsonValue
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

```java
package shangbo.jackson.demo14;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // 将对象转成 json
    String json = objectMapper.writeValueAsString(newPerson());
    System.out.println(json);
  }

  private static Person newPerson() {
    Person shangbo = new Person();
    shangbo.setFirstname("Bo");
    shangbo.setLastname("Shang");

    return shangbo;
  }
}
```

## 12. Jackson 注解 -- 使用构造器

如果你的类没有 setter 方法，我们也可以使用注解 @JsonCreator 修饰构造器。

```java
package shangbo.jackson.demo15;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
  private String firstname;
  private String lastname;

  @JsonCreator
  public Person(
    @JsonProperty("firstname") String firstname, 
    @JsonProperty("lastname") String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

```java
package shangbo.jackson.demo15;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // json 消息
    String json = "{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}";

    // 将 json 转成对象
    Person shangbo = objectMapper.readValue(json, Person.class);
    System.out.println(shangbo);
  }
}
```

## 13. Jackson 注解 -- 使用 Map存储JSON

我们也可以使用 Map 存储 JSON， 而不用创建对应的对象。

```java
package shangbo.jackson.demo16;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Person {
  private Map<String, Object> properties = new HashMap<>();

  @JsonAnySetter
  public void set(String fieldName, Object val) {
    this.properties.put(fieldName, val);
  }

  @JsonAnyGetter
  public Object get(String fieldName) {
    return this.properties.get(fieldName);
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
```

```java
package shangbo.jackson.demo16;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws Exception {
    // 实例化 ObjectMapper 对象
    ObjectMapper objectMapper = new ObjectMapper();

    // json 消息
    String json = "{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}";

    // 将 json 转成对象
    Person shangbo = objectMapper.readValue(json, Person.class);
    System.out.println(shangbo);
  }
}
```

## 14. Jackson 注解 -- 类型转换

如果输入输出 JSON 时需要类型转换，我们可以使用注解 @JsonDeserialize 和 @JsonSerialize

```java
package shangbo.jackson.demo17;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 实例化 ObjectMapper 对象
		ObjectMapper objectMapper = new ObjectMapper();

		// 将对象转成 json
		String json = objectMapper.writeValueAsString(newPerson());
		System.out.println(json);

		// 将 json 转成对象
		Person shangbo = objectMapper.readValue(json, Person.class);
		System.out.println(shangbo);
	}

	private static Person newPerson() {
		Person shangbo = new Person();
		shangbo.setFirstname("Bo");
		shangbo.setLastname("Shang");
		shangbo.setIsMale(true);

		return shangbo;
	}
}
```

```java
package shangbo.jackson.demo17;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Person {
	private String firstname;
	private String lastname;
	
	@JsonDeserialize(using = BooleanToIntDeserializer.class)
	@JsonSerialize(using = BooleanToIntSerializer.class)
	private Boolean isMale;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
```

```java
package shangbo.jackson.demo17;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BooleanToIntDeserializer extends JsonDeserializer<Boolean> {

	@Override
	public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String val = p.getText();
		if("0".equals(val)) {
			return false;
		}
		return true;
	}
}
```

```java
package shangbo.jackson.demo17;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BooleanToIntSerializer extends JsonSerializer<Boolean> {

  @Override
  public void serialize(Boolean value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    if(value) {
      gen.writeNumber(1);
    } else {
      gen.writeNumber(0);
    }
  }
}
```

