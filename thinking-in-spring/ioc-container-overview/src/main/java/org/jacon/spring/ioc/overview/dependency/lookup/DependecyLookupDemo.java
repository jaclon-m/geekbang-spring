package org.jacon.spring.ioc.overview.dependency.lookup;

import org.jacon.spring.ioc.overview.annotation.Super;
import org.jacon.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author jaclon
 * @date 2020/4/6
 */
public class DependecyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        //按类型查找
        //lookupByType(beanFactory);
        //延时查找
        lookupInLazy(beanFactory);
        // 按照类型查找集合对象
        //lookupCollectionsByType(beanFactory);
        //按照注解查找对象
        //lookupByAnnotationType(beanFactory);

    }

    public static void lookupByAnnotationType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + users);
        }
    }

    public static void lookupCollectionsByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory defaultListableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = defaultListableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有user的集合对象： " + users);
        }
    }
    private static void lookupByType(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找： " + user);
    }


}
