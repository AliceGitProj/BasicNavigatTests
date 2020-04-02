package com.cbt.utilities;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected = "+ expected);
            System.out.println("actual = " + actual);
        }
    }

//    public class StringUtility {
//        public static String verifyEquals(String expected, String actual){
//            if(expected.equalsIgnoreCase(actual)){
//                return "PASS";
//            }else {
//                System.out.println("expected = "+ expected);
//                System.out.println("actual = " + actual);
//                return "FAIL";
//            }
//        }
//    }
}
