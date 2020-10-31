package com.jin.gateway.downstream;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * @author wu.jinqing
 * @date 2020年06月28日
 */
public class Test1 {
    private static StringEncryptor stringEncryptor;
    private static final String password = "abc321";

    static {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        stringEncryptor = encryptor;
    }

    public static void main(String[] args) {

        System.out.println("ENC(" + stringEncryptor.encrypt("Mutms74152") + ")");
    }
}
