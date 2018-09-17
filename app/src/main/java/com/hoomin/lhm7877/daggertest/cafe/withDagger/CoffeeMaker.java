package com.hoomin.lhm7877.daggertest.cafe.withDagger;

import javax.inject.Inject;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
public class CoffeeMaker {
    @Inject Heater heater;
    @Inject Pump pump;

    @Inject
    public CoffeeMaker(Heater heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public CoffeeMaker() {
    }

    public void brew(){
        heater.on();
        pump.pump();
        System.out.println("coffee!");
        heater.off();
    }

}
