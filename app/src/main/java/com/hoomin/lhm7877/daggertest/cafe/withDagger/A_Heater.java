package com.hoomin.lhm7877.daggertest.cafe.withDagger;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
public class A_Heater implements Heater {

    private boolean heating;

    @Override
    public void on() {
        System.out.println("A_Heater : heating");
        this.heating = true;
    }

    @Override
    public void off() {
        this.heating = false;
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}
