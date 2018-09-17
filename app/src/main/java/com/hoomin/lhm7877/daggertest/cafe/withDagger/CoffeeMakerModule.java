package com.hoomin.lhm7877.daggertest.cafe.withDagger;

import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
@Module
public class CoffeeMakerModule {

    @Provides
    Heater provideHeater(){
        return new A_Heater();
    }

    @Provides
    Pump providePump(Heater heater){
        return new A_Pump(heater);
    }
}
