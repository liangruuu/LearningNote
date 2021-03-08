package club.singlelucky.service.impl;

import club.singlelucky.service.WelcomeService;

/**
 * @description: 定义了接口的实现类之后需要告诉Spring这是你需要管理的Bean，需要将其放入到容器内
 * 我们可以通过注解Annotation或者XML的方式放入，这里采用XML方式，在resources目录下创建XML文件
 * 有了接口，有了实现类，有了Bean的定义之后我们就能将相关的实现类化为Bean托管到Spring的容器里
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String sayHello(String name) {
		System.out.println("welcome: " + name);
		return "success";
	}
}
