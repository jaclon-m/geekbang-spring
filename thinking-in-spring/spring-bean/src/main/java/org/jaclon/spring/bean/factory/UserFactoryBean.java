/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package org.jaclon.spring.bean.factory;

import org.jacon.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Classname UserFactoryBean
 * @Description TODO
 *
 * @author jaclon
 * @date 2020/4/7
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
