//package com.talios.cucumberng;
//
//import corebase.ClassPathSearcher;
//import org.apache.log4j.Logger;
//import org.testng.Reporter;
//
//import java.io.File;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class CucumberFactoryBuilder {
//
//    private List<Option> options = new ArrayList<Option>();
//    private final static Logger log = Logger.getLogger("CFB  ");
//
//    public com.talios.cucumberng.CucumberFactoryBuilder addOption(String key, String value) {
//        options.add(new Option(key, value));
//        return this;
//    }
//
//    public Object[] create(final File baseDirectory) {
//        CucumberTestImpl test;
//
//        String sourceClass = findStackTraceSource().getClassName();
//        String sourcePackage = sourceClass.substring(0, sourceClass.lastIndexOf("."));
//
//        List<Object> featureTests = new ArrayList<Object>();
//        List<Object> featuresAdded = new ArrayList<Object>();
//
//        ClassPathSearcher searcher = new ClassPathSearcher();
//        Map<String, InputStream> foundFiles = searcher.findFilesInClassPath(".*com.features.*feature", true);
//        for (String featureFile : foundFiles.keySet())
//        {
//            String feature = featureFile.replaceAll(".*\\/", "");
//            if(!featuresAdded.contains(feature)) {
//                log.info("filename: " + featureFile);
//                test = new CucumberTestImpl(sourcePackage, featureFile);
//                for (Option opt : options) {
//                    test.addOption(opt.key, opt.value);
//                }
//                featureTests.add(test);
//                featuresAdded.add(feature);
//            }
//        }
//        return featureTests.toArray();
//    }
//
//    private class Option {
//        public String key;
//        public String value;
//
//        public Option(String key, String value) {
//            this.key = key;
//
//        }
//    }
//    private static StackTraceElement findStackTraceSource() {
//        StackTraceElement[] elements = new Exception().fillInStackTrace().getStackTrace();
//        for (StackTraceElement element : elements) {
//            if (!CucumberFactoryBuilder.class.getName().equals(element.getClassName())) {
//                return element;
//            }
//        }
//        return null;
//    }
//}
