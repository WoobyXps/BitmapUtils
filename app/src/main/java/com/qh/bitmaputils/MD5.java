package com.qh.bitmaputils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by malkavia on 15/12/17.
 */

public class MD5 {

    // 全局数组
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteToArrayString(byte aByte) {
        int iRet = aByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    private static String byteToString(byte[] aByte) {
        StringBuffer stringBufferuffer = new StringBuffer();
        for (int i = 0; i < aByte.length; i++) {
            stringBufferuffer.append(byteToArrayString(aByte[i]));
        }
        return stringBufferuffer.toString();
    }

    public static String getMD5Code(String strObj) {
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static String getMD5Code(byte[] bytes) {
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteToString(md.digest(bytes));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
}
