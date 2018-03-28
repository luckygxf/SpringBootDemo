package com.gxf.spring.jiemi.chapter5;

import java.util.Locale;

/**
 * Created by 58 on 2018/3/28.
 */
public class International {
    public static void main(String[] args) {
        local();
    }

    private static void local(){
        Locale china = new Locale("zh", "CN");
        Locale china2 = Locale.CHINA;
        System.out.println(china);
    }
}
