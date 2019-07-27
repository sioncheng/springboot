package com.github.sioncheng.sb.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProperties {

    @Value("${my.k1}")
    private String k1;

    @Value("${my.k2}")
    private String k2;

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }

    @Override
    public String toString() {
        return String.format("k1 = %s , k2 = %s", getK1(), getK2());
    }
}
