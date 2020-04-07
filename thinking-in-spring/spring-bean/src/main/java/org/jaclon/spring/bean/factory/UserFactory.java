/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package org.jaclon.spring.bean.factory;

import org.jacon.spring.ioc.overview.domain.User;

/**
 * @Classname UserFactory
 * @Description TODO
 *
 * @author jaclon
 * @date 2020/4/7
 */
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }

}
