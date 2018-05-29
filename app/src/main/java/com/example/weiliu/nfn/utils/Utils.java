package com.example.weiliu.nfn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wei.liu on 2018/5/29.
 */

public class Utils {

    //判断string是否是数字
    public static boolean isNumber(String text){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
