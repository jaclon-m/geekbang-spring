package org.jacon.spring.ioc.overview.domain;

import org.jacon.spring.ioc.overview.annotation.Super;

/**
 * @author jaclon
 * @date 2020/4/6
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
