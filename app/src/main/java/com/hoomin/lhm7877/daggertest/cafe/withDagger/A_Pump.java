package com.hoomin.lhm7877.daggertest.cafe.withDagger;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
public class A_Pump implements Pump {

    private final Heater heater;

    public A_Pump(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("A_Pump : pumping ");
        }
    }
}
