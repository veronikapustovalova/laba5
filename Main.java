//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Injector injector = new Injector();
        A tmp = null;

        try {
            tmp = (A) injector.inject(new A());
            System.out.println(tmp.foo());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IOException var4) {
            var4.printStackTrace();
        }

    }
}
