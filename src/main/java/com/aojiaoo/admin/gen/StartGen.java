package com.aojiaoo.admin.gen;


import com.aojiaoo.generator.GeneratorCode;

public class StartGen {

    public static void main(String[] args) throws Exception {
        GeneratorCode.startGeneratorCode("classpath:generator/jdbc.properties", "classpath:generator/generatorCode.properties");
    }
}
