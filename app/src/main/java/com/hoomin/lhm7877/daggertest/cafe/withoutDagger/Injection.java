package com.hoomin.lhm7877.daggertest.cafe.withoutDagger;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
public class Injection {
    public static Heater provideHeater(){
        return new A_Heater();
    }

    public static Pump providePump(){
        return new A_Pump(provideHeater());
    }

    public static CoffeeMaker provideCoffeeMaker(){
        return new CoffeeMaker(provideHeater(), providePump());
    }
}
