package com.gxf.hotspot_action.chapter1;

public class BinaryValueIteral {
    public static void main(String[] args) {
        getBValue();

    }

    public static int getBValue(){
        int a = 0B100;
        System.out.println(a);
        long b = 1_000_000_000_000L;
        System.out.println(b);

        return  a;
    }
}
