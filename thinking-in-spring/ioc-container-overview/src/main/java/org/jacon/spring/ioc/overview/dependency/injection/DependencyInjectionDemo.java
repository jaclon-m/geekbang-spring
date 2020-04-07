package org.jacon.spring.ioc.overview.dependency.injection;

import org.jacon.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author jaclon
 * @date 2020/4/6
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        // 依赖来源二：容器內建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);

        // 依赖来三：依赖注入（內建依赖）
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject() == applicationContext);


    }

    public static void userBeanFactory(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        ObjectFactory userFactory = userRepository.getObjectFactory();
        // 依赖查找
        System.out.println(beanFactory.getBean(BeanFactory.class));
        //beanFactory并不相同，说明他们是不同来源的。
        System.out.println(userFactory.getObject() == beanFactory);
    }
}
