package com.vani.webapp.utils;

/**
 * Created by vani on 21/4/16.
 */

//For encoding string to md5
public class PasswordEncoder {

    public static String getMD5(String data) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
    }
}
