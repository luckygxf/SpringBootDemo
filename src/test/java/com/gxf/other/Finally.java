package com.gxf.other;

/**
 * Created by 58 on 2018/4/2.
 */
public class Finally {

    public static void main(String[] args) {
        int value = testTry();
        System.out.println("value : " + value);
    }

    private static int testTry(){
        try {
            System.out.println("in try");
            return 1;
        }  finally {
            System.out.println("in finally");
        }
    }
}
