package com.vlat.MedAppServer.utility;

import com.vlat.MedAppServer.interfaces.Generator;
import org.springframework.stereotype.Component;

@Component
public class CodeGenerator implements Generator {
    private final int LENGTH = 12;
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @Override
    public String generate() {
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < LENGTH; i++){
            code.append(
                    ALPHABET.charAt((int)(Math.random()*(ALPHABET.length()-1))) );
        }
        return code.toString();
    }
}
