package com.preorder.web.common;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils {

    private final StandardPBEStringEncryptor encryptor;

    public EncryptionUtils(@Value("${jasypt.encryptor.password}") String secretKey) {
        encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(secretKey);
        encryptor.setAlgorithm("PBEWithMD5AndDES");
    }

    public String encrypt(String data) {
        return encryptor.encrypt(data);
    }

    public String decrypt(String encryptedData) {
        return encryptor.decrypt(encryptedData);
    }
}