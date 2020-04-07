package org.jaclon.spring.bean;

import org.jacon.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author jaclon
 * @date 2020/4/6
 * bean 的注册 1. @Bean
 * 2. @Component
 * 3. @Import
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //applicationContext.register(Config.class);
        //applicationContext.refresh();
        //System.out.println(applicationContext.getBeansOfType(User.class));


        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    @Component
    public static class Config{

        @Bean(name = {"user", "xiaomage-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小马哥");
            return user;
        }
    }
}
