package com.sxlg.util;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类是用来给数据进行加密的
 */
@Configuration
public class EncryptionUtil {

    @Bean
    public BasicTextEncryptor basicTextEncryptor(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("G0eADz7oJn6");
        return textEncryptor;
    }

}
