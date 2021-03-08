package club.singlelucky;

import club.singlelucky.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @description: 在这个Main函数里需要获取Spring Bean容器的实例，然后从这个容器中获取Bean的实例
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class Entrance {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// 因为Bean是在xml文件中定义的，所以需要获取xml文件的路径（这里采用绝对值路径）
		String xmlPath = "D:\\study\\code\\spring-framework-5.2.0.RELEASE\\spring-demo\\src\\main\\resources\\spring\\spring-config.xml";
		/**
		 * 拿到路径之后需要去解析XML文件，同时生成Spring容器并返回给调用者
		 * 而解析XML文件的类存放在spring-context模块下，这也意味着Entrance类需要依赖于spring-context模块
		 * 若以gradle构建项目，则需要在spring-demo模块下的build.gradle的dependencies代码块中新增compile(project(":spring-context"))
		 * 作用为把spring-context模块引入到这个项目里面来，引入之后就可以使用相关的解析类了
		 * ApplicationContext就是对应的容器对象
		 */
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		// 这里的name就是在xml文件里配置的<bean>对应的id属性值，第二个参数就是对应的class属性值
		WelcomeService welcomeService = applicationContext.getBean("welcomeService", WelcomeService.class);
		// 调用实现类的sayHello方法
		welcomeService.sayHello("spring is strong");

	}
}
