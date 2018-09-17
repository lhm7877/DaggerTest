package com.hoomin.lhm7877.daggertest.cafe.withDagger;

import dagger.Component;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
@Component(modules = CoffeeMakerModule.class)
public interface CoffeeComponent {

    CoffeeMaker make();
    void inject(CoffeeMaker coffeeMaker);
}
