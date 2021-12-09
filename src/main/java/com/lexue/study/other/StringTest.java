package com.lexue.study.other;


public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("1");
        String s2 = "1";
        System.out.println(s1 == s2);
////        String s2 = s1.intern();
////        System.out.println(s1 == s2);
//
//        String str = "12";
//        String s3 = new String("1") + new String("2");
//        String s4 = s3.intern();
//        System.out.println(str == s4);
//        System.out.println(s3 == s4);
    }
}
