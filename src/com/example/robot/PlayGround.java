//package com.example.robot;
//
//import java.rmi.activation.ActivationGroup_Stub;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.*;
//
//public class PlayGround {
//    public static void main(String[] args) {
//        // primitive
//
//        // number
//        // int
//        short s = 5; // 16bit, 2 bytes
//        Short sc = 5;
//        Short sc2 = null; // None
//        int i = 5; // 32bit, 4bytes
//        long l = 5L; // 64bit, 8bytes
//        Long lc = 5L;
//
//        // float point
//        double d = 3.14; // 64bit
//        Double dc = 3.14;
//
//        float f  = 3.14f; // 32beat
//        Float fc = 3.14f;
//
//        // binary
//        byte b = 1; // 8bits, 1byte 0-255
//
//        // String
//        String str = "abc"; // immutable
//        str += "def";
//
//        // char
//        char c = 'a';   // 16 bit, unicode, single quotes
//        Character cc = 'a';
//
//        // boolean
//        boolean b2 = true; // 1bit
//
//
//        // array
//        // fixed size array
//        int[] ia = new int[5];
//        ia[0] = 0;
//        ia[4] = 4;
//
//        // dynamic size array
//        List<Integer> dynamicArr = new ArrayList<>();
//
//        for (int ii=0; ii<100; ii++) {
//            dynamicArr.add(ii);
//        }
//
//        List<Integer> dynamicArr2 = new ArrayList<>();
//        for (int ii=0; ii<100; ii++) {
//            dynamicArr2.add(ii);
//        }
//
//        List<List<Integer>> dd= new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//
//        // dictionary
//        Map<String, Integer> ages = new HashMap<>();
//        ages.put("bolang", 14);
//        ages.put("yining", 10);
//        System.out.println(ages.get("bolang"));
//
//        // Set
//        Set<String> words = new HashSet<>();
//        words.add("bird");
//        words.add("car");
//        words.add("bird");
//        System.out.println(words.size());
//        for (String word : words) {
//            System.out.println(word);
//        }
//    }
//}
