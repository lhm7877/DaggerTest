package com.hoomin.lhm7877.daggertest.cafe;

import com.hoomin.lhm7877.daggertest.cafe.withDagger.DaggerCoffeeComponent;
import com.hoomin.lhm7877.daggertest.cafe.withoutDagger.A_Heater;
import com.hoomin.lhm7877.daggertest.cafe.withoutDagger.A_Pump;
import com.hoomin.lhm7877.daggertest.cafe.withoutDagger.CoffeeMaker;
import com.hoomin.lhm7877.daggertest.cafe.withoutDagger.Heater;
import com.hoomin.lhm7877.daggertest.cafe.withoutDagger.Injection;
import com.hoomin.lhm7877.daggertest.cafe.withoutDagger.Pump;

/**
 * <pre>
 * Created by lhm0805 on 2018-09-14.
 * </pre>
 */
public class CoffeeApp {
    public static void main(String[] args){
        makeCoffeeWithoutDI();
//        makeCoffeeWithDI();
        DaggerCoffeeComponent.create().make().brew();
//        com.hoomin.lhm7877.daggertest.cafe.withDagger.CoffeeMaker coffeeMaker = new com.hoomin.lhm7877.daggertest.cafe.withDagger.CoffeeMaker();
//        DaggerCoffeeComponent.create().inject(coffeeMaker);
//        coffeeMaker.brew();

    }

    /**
     * Injection 클래스에서 heater와 pump를 제공받는다. CoffeeMaker 사용자는 A_Heater를 사용해야하는지 B_Heater를 사용해야하는지 알 필요가 없다.
     */
    private static void makeCoffeeWithDI() {
        CoffeeMaker coffeeMaker = new CoffeeMaker(Injection.provideHeater(), Injection.providePump());
        coffeeMaker.brew();

        // 더 간단하게 CoffeeMaker 사용자는 heater 나 pump 가 필요한지 모르는 상태에서도 커피를 내릴 수 있다.
        // 갑자기 A_Heater 말고 B_Heater 를 사용해야하는 상황이 왔을 때 DI 가 구현된 코드에서 CoffeeMaker 관리자는 사용자에게 아무 얘기 없이 Injection 설정만 B_Heater 로 바꿔주면 된다.
        Injection.provideCoffeeMaker().brew();
    }

    /**
     * CoffeeMaker 가 어떤 구현체에 의존하고 있는지 알아야 한다.(어떤 heater 를 쓰는지, 어떤 pump 를 쓰는지)
     */
    private static void makeCoffeeWithoutDI() {
        Heater heater = new A_Heater();
        Pump pump = new A_Pump(heater);
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater,pump);
        coffeeMaker.brew();
    }
}
