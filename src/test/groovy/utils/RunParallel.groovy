package utils
import org.apache.log4j.Logger
import org.testng.TestNG
import org.testng.xml.XmlClass
import org.testng.xml.XmlPackage
import org.testng.xml.XmlSuite
import org.testng.xml.XmlTest
import reports.TangHtmlReporter

public class RunParallel {
    private static ArrayList<String> groups = new ArrayList<String>();
    private static ArrayList<String> excludedGroups = new ArrayList<String>();
    private static ArrayList<XmlClass> testXmlClasses = new ArrayList<XmlClass>();
    private static ArrayList<XmlPackage> testXmlPackage = new ArrayList<XmlPackage>();

    private static final Logger logger = Logger.getLogger("RunParallel");

    private static final int THREAD_COUNT = 6;
    private static final int SUITE_THREAD_POOL_SIZE = 6;
    private static int testCounter = 1;
    private static final String SUITE_NAME = "ikeaCountries.testng.xml";
    static int suiteCounter = 1
    static def TEST_TAG = ".test"
    static def SUITE_TAG = "suite"
    static Parameters browsers = new Parameters("browser")
    static Parameters environments = new Parameters("environment")

    private static void setUpClasses() {
//        testXmlClasses.add(new XmlClass(MultiModelMbtTestRun))
//        testXmlClasses.add(new XmlClass("verification.ikea.SearchPhraseInSeveralCountriesStaticDataProviderAtIkeaTest"))
//        testXmlClasses.add(new XmlClass(SearchPhraseAtIkeaInSeveralCountriesWithDataProvidersTest))
//        testXmlClasses.add(new XmlClass(FailedTest))

    }

    private static void setUpPackages() {
        //testXmlPackage.add(new XmlPackage("verification.linkedin.*"))
        //testXmlPackage.add(new XmlPackage("verification.google.*"))
    }

    private static void setUpExcludedGroups() {
        excludedGroups.add(".*(KNOWN_DEFECT|MOCK).*");
    }

    private static void setUpBrowses() {
//        browsers.addValue("COMPANY_HUB_FIREFOX")
//        browsers.addValue("COMPANY_HUB_FIREFOX_19")
//        browsers.addValue("COMPANY_HUB_FIREFOX_19")
        browsers.addValue("LOCAL_FIREFOX")
//        browsers.addValue("LOCAL_SAFARI")
//        browsers.addValue("LOCAL_CHROME")
//        browsers.addValue("LOCAL_INTERNETEXPLORER")
//        browsers.addValue("SAUCELABS_HUB_ANDROID_5_0_SL_LINUX")
//        browsers.addValue("SAUCELABS_HUB_ANDROID_4_0")
//        browsers.addValue("SAUCELABS_HUB_ANDROID_4_0")
//        browsers.addValue("SAUCELABS_HUB_IPAD_4_SL_OS_X_10_6")
//        browsers.addValue("SAUCELABS_HUB_IPAD_5_SL_OS_X_10_6")
//        browsers.addValue("SAUCELABS_HUB_IPAD_6_SL_OS_X_10_8")
//        browsers.addValue("SAUCELABS_HUB_IPHONE")
//        browsers.addValue("SAUCELABS_HUB_IPHONE_5_1_SL_OS_X_10_8")
//        browsers.addValue("SAUCELABS_HUB_CHROME_22_SL_OS_X_10_6")
//        browsers.addValue("SAUCELABS_HUB_FIREFOX_19_SL_WINDOWS")
//        browsers.addValue("SAUCELABS_HUB_FIREFOX_18_SL_WINDOWS_7")
//        browsers.addValue("SAUCELABS_HUB_SAFARI_5_SL_OS_X_10_6")
//        browsers.addValue("SAUCELABS_HUB_OPERA_SL_WINDOWS_XP")
//        browsers.addValue("SAUCELABS_HUB_OPERA_11")
//        browsers.addValue("SAUCELABS_HUB_OPERA_11")


    }

    private static void setUpGroups() {
        //groups.add(".*")
        //groups.add("groupOne")
        //groups.add(".*groupTwo.*")
    }


    private static void setUpEnvironments() {
        environments.addValue("TestEnv_One")
        environments.addValue("TestEnv_Two")
//        environments.addValue("TestEnv_Three")
    }

    public static void main(String[] args) {
        List<XmlSuite> allXmlSuites = new ArrayList<XmlSuite>();
        setUpBrowses();
        setUpEnvironments()
        setUpClasses()
        setUpPackages()
        setUpExcludedGroups()
        setUpGroups()

        getXmlSuites(allXmlSuites, environments, browsers)

        TestNG tng = new TestNG();
        tng.setSuiteThreadPoolSize(SUITE_THREAD_POOL_SIZE);
        for (XmlSuite xmlSuite : allXmlSuites) {
            logger.info("");
            logger.info(xmlSuite.toXml());
        }
        logger.info(allXmlSuites.toArray());


        XmlSuite parallelSuite = convertToOneParallelSuite(allXmlSuites, 10, SUITE_NAME);
        writeTestNgXmlFiles(allXmlSuites);
//        writeTestNgXmlFiles(parallelSuite);

        tng.setXmlSuites(allXmlSuites);

        List<Class> classes = new ArrayList<Class>();
        try {
            //classes.add(org.uncommons.reportng.HTMLReporter)
            classes.add(org.testng.reporters.EmailableReporter)
            classes.add(TangHtmlReporter)
//            classes.add(atu.testng.reports.listeners.ATUReportsListener)
//            classes.add(atu.testng.reports.listeners.ConfigurationListener)
//            classes.add(atu.testng.reports.listeners.MethodListener)
        } catch (ClassNotFoundException e) {
        }
        tng.setListenerClasses(classes);
        tng.run();
        logger.debug("Done");
    }


    private static void getXmlSuites(ArrayList<XmlSuite> allXmlSuites, Parameters p1, Parameters p2) {
        if (p1.values.size() > 0) {
            Iterator<String> valueItr = p1.values.iterator();
            while (valueItr.hasNext()) {
                String value = valueItr.next();
                XmlSuite xmlSuite = getXmlSuite(value, p1.name, p2);
                allXmlSuites.add(xmlSuite)
            }
        } else {
            XmlSuite xmlSuite = getXmlSuite("", p1.name, p2);
            allXmlSuites.add(xmlSuite)
        }
    }



    private static void writeTestNgXmlFiles(List<XmlSuite> suites) {
        String DIR = "TestNgXmlFiles/";
        File dir = new File(DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (XmlSuite xmlSuite : suites) {
            try {
                // Create file
                //String fileName = xmlSuite.getName().toLowerCase() + ".xml";
                String fileName = xmlSuite.getName() + ".xml";
                FileWriter fstream = new FileWriter(DIR + fileName);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(xmlSuite.toXml());
                // Close the output stream
                out.close();
            } catch (GroovyRuntimeException e) {// Catch exception if any
                logger.error("Error: " + e.getMessage());
            }
            logger.info(xmlSuite.toString());
        }
    }




    private static XmlSuite getXmlSuite(String value, String name, Parameters parameters) {
        XmlSuite xmlSuite = createXmlSuite();


        String suiteName = replaceUnnecessaryChars(value + "." + String.format("%05d", Integer.parseInt(suiteCounter++ + "")) + "." + SUITE_TAG)

        logger.info(suiteName);

        xmlSuite.setName(suiteName);
        xmlSuite.setFileName(suiteName + ".xml");

        if (parameters.values.size()) {
            Iterator<String> valueItr = parameters.values.iterator();
            while (valueItr.hasNext()) {
                def valueIteValue = valueItr.next()
                if (groups.size()) {
                    Iterator<String> groupItr = groups.iterator();
                    while (groupItr.hasNext()) {
                        getXmlTest(valueIteValue, value, xmlSuite, name, parameters.name, groupItr.next())
                    }
                } else {
                    getXmlTest(valueIteValue, value, xmlSuite, name, parameters.name)
                }
            }
        } else {
            if (groups.size()) {
                Iterator<String> groupItr = groups.iterator();
                while (groupItr.hasNext()) {
                    getXmlTest("", value, xmlSuite, name, parameters.name, groupItr.next())
                }
            } else {
                getXmlTest("", value, xmlSuite, name, parameters.name)
            }

        }
        return xmlSuite;
    }

    private static void getXmlTest(String valueItr, String value, XmlSuite xmlSuite, String name, String parameters2Name, group = "") {
        List<String> xmlTestExcludedGroups = excludedGroups;

        def p2Value = valueItr
        XmlTest xmlTest = new XmlTest(xmlSuite);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(name, value)
        parameters.put(parameters2Name, p2Value)
        xmlTest.setParameters(parameters);

        //testXmlClasses.add(CLASS_TO_RUN);

        xmlTest.setExcludedGroups(xmlTestExcludedGroups);
        xmlTest.setClasses(testXmlClasses);
        xmlTest.setPackages(testXmlPackage);
        String testName = replaceUnnecessaryChars(group + "." + value + "." + p2Value + "." + String.format("%05d", Integer.parseInt(testCounter + "")) + TEST_TAG)
        if (!group.equals("")) {
            testName = replaceUnnecessaryChars(group + "." + value + "." + p2Value + "." + String.format("%05d", Integer.parseInt(testCounter + "")) + TEST_TAG)
            xmlTest.addIncludedGroup(group)
        }
        xmlTest.setName(testName);
        testCounter++
        logger.info(testName);


    }

    private static String replaceUnnecessaryChars(String string) {
        def REG_EXP_ALL = '\\.\\*'
        def REG_EXP_CHAR_1 = '\\.'
        def REG_EXP_CHAR_2 = '_'
        //string = string.toLowerCase()
        string = string.replaceAll("$REG_EXP_ALL$REG_EXP_ALL", REG_EXP_CHAR_1)
        string = string.replaceAll("$REG_EXP_ALL", REG_EXP_CHAR_1).replaceAll(" ", REG_EXP_CHAR_1).replaceAll("$REG_EXP_CHAR_1$REG_EXP_CHAR_1", REG_EXP_CHAR_1).replaceAll("^$REG_EXP_CHAR_1", "");
        string = string.replaceAll("$REG_EXP_CHAR_1$REG_EXP_CHAR_1", REG_EXP_CHAR_1)
        string = string.replaceAll("^$REG_EXP_CHAR_1", "")
        string = string.replaceAll("$REG_EXP_CHAR_2$REG_EXP_CHAR_2", REG_EXP_CHAR_2)
        string = string.replaceAll("^$REG_EXP_CHAR_2", "")
        return string
    }


    private static XmlSuite createXmlSuite() {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setParallel("tests");
        xmlSuite.setThreadCount(THREAD_COUNT);
        return xmlSuite;
    }





    private static XmlSuite convertToOneParallelSuite(List<XmlSuite> xmlSuites, int threadCount, String suiteName) {
        XmlSuite parallelXmlSuite = new XmlSuite();
        parallelXmlSuite.setThreadCount(threadCount);
        parallelXmlSuite.setName(suiteName);
        int testCounters = 1;
        for (XmlSuite xmlSuite : xmlSuites)
            for (XmlTest xmlTest : xmlSuite.getTests()) {
                String testName = xmlTest.getName()
                testName = testName.replaceAll("[0-9]+.test", "") + String.format("%05d", Integer.parseInt(testCounters++ + "")) + TEST_TAG;
                testName = replaceUnnecessaryChars(testName)
                xmlTest.setName(testName);
                parallelXmlSuite.addTest(xmlTest);
                logger.info(xmlTest);
            }
        logger.info(parallelXmlSuite.toXml());
        List<XmlSuite> parallelXmlSuites = new ArrayList<XmlSuite>();
        parallelXmlSuites.add(parallelXmlSuite);
        return parallelXmlSuite
    }

}


public class Parameters {
    public Parameters(String name) {
        this.name = name
    }

    public void addValue(parameter) {
        values.add(parameter)
    }

    private String name
    public ArrayList<String> values = new ArrayList<String>();

}

