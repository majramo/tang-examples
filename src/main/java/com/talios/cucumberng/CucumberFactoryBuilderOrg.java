package com.talios.cucumberng;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberFactoryBuilderOrg {

    private List<Option> options = new ArrayList<Option>();
    private final static Logger log = Logger.getLogger("CFB  ");

    private static List<String> addFeature(String basePacakge, File feature) {
        String basePackagePath = basePacakge.replace(".", File.separator);
        List<String> featureTests = new ArrayList<String>();
        if (!feature.exists()) {
            throw new IllegalArgumentException("feature file does not exist");
        }

        if (feature.isDirectory()) {
            File[] files = feature.listFiles();
             if(feature.toString().contains("test")){

                 log.info(basePacakge + " " + feature + " files " + files);
             }
            for (File file : files) {
                if (!file.isHidden()) {
                    log.info(basePacakge + " " + file.getAbsoluteFile().toString() );

                    featureTests.addAll(addFeature(basePacakge, file));
                }
            }
        } else {
            log.info(basePacakge + " " + feature );

            if (feature.getPath().contains(basePackagePath) && feature.getName().endsWith(".feature")) {
                featureTests.add(feature.getPath());
            }
        }

        return featureTests;
    }

    private static StackTraceElement findStackTraceSource() {
        StackTraceElement[] elements = new Exception().fillInStackTrace().getStackTrace();
        for (StackTraceElement element : elements) {
            if (!CucumberFactoryBuilderOrg.class.getName().equals(element.getClassName())) {
                return element;
            }
        }
        return null;
    }

    public CucumberFactoryBuilderOrg addOption(String key, String value) {

        options.add(new Option(key, value));
        return this;
    }

    public Object[] create() {
        return create(new File("."));
    }

    public Object[] create(final File baseDirectory) {
        CucumberTestImpl test;
        String sourceClass = findStackTraceSource().getClassName();
        String sourcePackage = sourceClass.substring(0, sourceClass.lastIndexOf("."));

        List<Object> featureTests = new ArrayList<Object>();
        List<String> features = addFeature(sourcePackage, baseDirectory);
        for (String feature : features) {
            log.info(sourcePackage + " " + feature);
            test = new CucumberTestImpl(sourcePackage, feature);
            for (Option opt : options) {
                test.addOption(opt.key, opt.value);
            }
            featureTests.add(test);
        }

        return featureTests.toArray();
    }

    private class Option {
        public String key;
        public String value;

        public Option(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
