package com.gxf.beans;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/8/21 上午11:21
 **/
public class ClassDemo {

    public static void main(String[] args) {

        try {
            // returns the Class object associated with this class
            Class cls = Class.forName("com.gxf.beans.ClassDemo");

        /* returns the array of Class objects representing the public
        members of this class */
            Class[] classes = cls.getClasses();
            for (int i = 0; i < classes.length; i++) {
                System.out.println("Class found = " + classes[i].getName());
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public class InnerClass1 {
        public InnerClass1() {
            System.out.println("Inner Class1");
        }
    }

    public class InnerClass2 {
        public InnerClass2() {
            System.out.println("Inner Class2");
        }
    }

    private class InnerPrivateClass {
        public InnerPrivateClass() {
            System.out.println("Inner Private Class");
        }
    }
}