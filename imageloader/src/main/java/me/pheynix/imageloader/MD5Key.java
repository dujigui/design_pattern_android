package me.pheynix.imageloader;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 使用 md5 算法生成key
 * Created by dujigui on 12/15/16.
 */

class MD5Key implements KeyGenerator {
    @Override
    public String generate(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(url.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception ignored) {
        }
        return url.replaceAll("\\s+","");
    }
}
