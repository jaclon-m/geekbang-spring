package org.jacon.spring.ioc.overview.repository;

import org.jacon.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author jaclon
 * @date 2020/4/6
 */
public class UserRepository {

    private Collection<User> users; // 自定义 Bean

    private BeanFactory beanFactory;    // 內建非 Bean 对象（依赖）

    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory <ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory <ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public Collection <User> getUsers() {
        return users;
    }

    public void setUsers(Collection <User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
