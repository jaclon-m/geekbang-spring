package org.jaclon.spring.bean;

import org.jacon.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext,"xiaoma-user");
        // 2. 非命名 Bean 的注册方法
        registerUserBeanDefinition(applicationContext);
        applicationContext.refresh();
        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry,String BeanName){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id",1)
                .addPropertyValue("name","小马哥");
        if(StringUtils.hasText(BeanName)){
            //注册 BeanDefinition
            registry.registerBeanDefinition(BeanName,beanDefinitionBuilder.getBeanDefinition());
        }else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
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
