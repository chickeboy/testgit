package com.owen.wxutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * sha1加密接入微信
 */
public class Validation {
    private static String token = "wxtoken";

    public static boolean checkSignature(String signature, String timestamp,String nonce) {

        // 1.将token,timestamp,nonce三个参数进行排序
        String[] str = new String[] { token, timestamp, nonce };
        System.out.println(token+"\t"+timestamp+"\t"+nonce);
        Arrays.sort(str);
        for (String string : str) {
            System.out.println(string);
        }

        // 2.将三个参数字符串拼接成一个字符串
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buff.append(str[i]);
        }

        // 3.进行sha1加密
        MessageDigest md ;
        String result = "";
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] data = md.digest(buff.toString().getBytes());
            // 将字节数组转换成字符串
            result = bytesToString(data);
            System.out.println("加密后的字符串为：" + result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result != null ? (result.equals(signature.toUpperCase())): false;
    }

    //将字节数组转换成十六进制字符串
    public static String bytesToString(byte[] byteArray) {
        String stringDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            stringDigest += byteToHexString(byteArray[i]);
        }
        return stringDigest;
    }

    //将一个字节转换为十六进制字符串
    public static String byteToHexString(byte mByte) {
        char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A','B', 'C', 'D', 'E', 'F' };
        char[] temp = new char[2];
        temp[0] = digit[(mByte >>> 4) & 0X0F];
        temp[1] = digit[mByte & 0X0F];
        String str = new String(temp);
        return str;
    }

    


}
