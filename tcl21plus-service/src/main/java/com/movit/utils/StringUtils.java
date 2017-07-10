/*******************************************************************************
 * Bosch PT Warranty
 * <p/>
 * Summary:
 * Summary for this file.
 * <p/>
 * Author: jason.xu
 * Date: 26/3/2016
 * Copyright (c) : Robert Bosch GmbH, 2016.
 ******************************************************************************/

package com.movit.utils;

import java.text.DecimalFormat;

public class StringUtils {
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    public static String generateGetMethodName(String name) {
        return "get" + captureName(name);
    }

    public static String generateSetMethodName(String name) {
        return "set" + captureName(name);
    }

    public static String numberFormat(String format, int num) {
        return new DecimalFormat(format).format(num);
    }

    public static String numberFormat(String format, double num) {
        return new DecimalFormat(format).format(num);
    }

}