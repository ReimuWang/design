package com.test;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;


public class Test {

    public static void convertStr2List(String strs, ArrayList<String> list) {
        if (StringUtils.isNotBlank(strs)) {
            String[] strsArray = strs.split(";");
            if (null!=strsArray) {
                for (String str : strsArray) {
                    if (StringUtils.isNotBlank(str)) {
                        String[] dd = str.split("\\|");
                        if (dd.length==2) {
                            list.add(dd[1]);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "5| ";
        String[] dd = str.split("\\|");
        System.out.println(dd.length);
    }
}