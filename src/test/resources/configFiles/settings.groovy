package configFiles

import static corebase.GlobalConstants.*

defaultBrowser = LOCAL_FIREFOX
//defaultBrowser = LOCAL_INTERNET_EXPLORER
//defaultBrowser = LOCAL_CHROME
//defaultBrowser = LOCAL_SAFARI

dbRun = true
guiRun = true
maxAyyaySizeToWorkWith = 50

CHROME_DRIVER_PATH.MAC = "drivers/chromedriver"
CHROME_DRIVER_PATH.WIN = "drivers/chromedriver.exe"
IE_DRIVER_PATH.MAC = "drivers/IEDriverServer_x64_2.42.0.exe"
IE_DRIVER_PATH.WIN = "drivers/IEDriverServer_x64_2.42.0.exe"

firefoxProfileFolder = "seleniumProfile"
// ==>Database setting
localDb = 'jdbc:h2'
jdbcSqlServerDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
jdbcSqlDriverName = "jdbc:sqlserver"
jdbcJtdsSqlDriverName = "jdbc:jtds:sqlserver"
jdbcSqlH2Driver = "org.h2.Driver"
jdbcSqlH2DriverName = "jdbc:h2"
jdbcDb2Driver = "com.ibm.db2.jcc.DB2Driver"
jdbcDb2DriverName = "jdbc:db2"
jdbcOracleDriver = "oracle.jdbc.driver.OracleDriver"
jdbcOracleDriverName = "jdbc:oracle:thin"

jdbcMySqlServerDriver = "com.mysql.jdbc.Driver"
jdbcMySqlDriverName = "jdbc:mysql"
jdbcMySqlUrl = "//localhost:3306"
jdbcMySqlUserName = "root"
jdbcMySqlPassword = "vem"

jdbcSqlServerUrl = "//localhost:3306"
jdbcSqlServerUserName = "root"
jdbcSqlServerPassword = "vem"

mySqlDb {
    dbDriverName = jdbcMySqlDriverName
    dbDriver = jdbcMySqlServerDriver
    dbUrl = jdbcMySqlUrl
    dbUserName = jdbcMySqlUserName
    dbPassword = jdbcMySqlPassword
    dbTestDataBase = "mysql"
}

sqlServer {
    dbDriverName = jdbcSqlDriverName
    dbDriver = jdbcMySqlServerDriver
    dbUrl = jdbcSqlServerUrl
    dbUserName = jdbcSqlServerUserName
    dbPassword = jdbcSqlServerPassword
    dbTestDataBase = jdbcSqlServerPassword
}

oracle {
    dbDriverName = jdbcOracleDriverName
    dbDriver = jdbcOracleDriver
    dbUrl = jdbcSqlServerUrl
    dbUserName = jdbcSqlServerUserName
    dbPassword = jdbcSqlServerPassword
    dbTestDataBase = jdbcSqlServerPassword
}

h2Db {
    dbDriverName = jdbcSqlH2DriverName
    dbDriver = jdbcSqlH2Driver
    dbUrl = "~"
    dbUserName = "sa"
    dbPassword = "sa"
    dbTestDataBase = "test"
}

Db2tFtDb_2 {
    dbDriverName = jdbcDb2DriverName
    dbDriver = jdbcDb2Driver
    dbUrl = ''
    dbUserName = ""
    dbPassword = ""
    dbTestDataBase = "DB2"
}


defaultDatabase = "mySqlDb"

configFiles {
    servers = 'server.groovy'
    pesonalSettings = 'pesonalSettings.groovy'

}

// ==>Path
outputDir = "/tmp/tang/"
SprintPath = outputDir + 'tang-report/'
HtmlXmlSourceFilesPath = 'htmlXmlSourceFiles/'
FlowFilesPath = 'flow/'
ReportPath = 'report/'

//Date time format
FileNameDateTimeFormat = 'yyyyMMdd_'        //'yyyyMMdd_HHmmss_SS' används i assert-filnamnet
//FileNameDateTimeFormat = 'yyyyMMdd_HHmmss'		//'yyyyMMdd_HHmmss_SS' används i assert-filnamnet
ReportFileNameTimeFormat = 'yyyyMMdd_HH'        // används i report filnamnet
TimeStampFormat = "HH:mm (yyyy-MM-dd)"    // "HH:mm:ss (yyyy-MM-dd)"	//används i timestamps i fil innehållet

//Message output
notifyMsg = "########################################################"
notifyMsgLine = "$notifyMsg$notifyMsg"
notifyMsgStartStop = "$notifyMsgLine\n$notifyMsgLine\n$notifyMsgLine\n$notifyMsgLine"

//Show differences when comparing
AsssertionsDiff {
    show = false
}

webDrivers = [
        [LOCAL_HTML_UNIT, LOCAL, HTMLUNIT, "", ""],
        ["COMPANY_HUB_FIREFOX", COMPANY_HUB, FIREFOX, "", ""],
        ["COMPANY_HUB_FIREFOX_19", COMPANY_HUB, FIREFOX, "19", ""],
        ["COMPANY_HUB_FIREFOX_19", COMPANY_HUB, FIREFOX, "19", ""],
        [LOCAL_FIREFOX, LOCAL, FIREFOX, "", ""],
        [LOCAL_SAFARI, LOCAL, SAFARI, "", ""],
        [LOCAL_CHROME, LOCAL, CHROME, "", ""],
        [LOCAL_INTERNET_EXPLORER, LOCAL, INTERNET_EXPLORER, "", ""],
        [LOCAL_HTML_UNIT, LOCAL, HTMLUNIT, "", ""],
        ["SAUCELABS_HUB_ANDROID_5_0_SL_LINUX", SAUCELABS_HUB, ANDROID, "5.0", "LINUX"],
        ["SAUCELABS_HUB_ANDROID_4_0", SAUCELABS_HUB, ANDROID, "4.0", ""],
        ["SAUCELABS_HUB_ANDROID_4_0", SAUCELABS_HUB, ANDROID, "4.0", ""],
        ["SAUCELABS_HUB_IPAD_4_SL_OS_X_10_6", SAUCELABS_HUB, IPAD, "4", "OS X 10.6"],
        ["SAUCELABS_HUB_IPAD_5_SL_OS_X_10_6", SAUCELABS_HUB, IPAD, "5", "OS X 10.6"],
        ["SAUCELABS_HUB_IPAD_6_SL_OS_X_10_8", SAUCELABS_HUB, IPAD, "6", "OS X 10.8"],
        ["SAUCELABS_HUB_IPHONE", SAUCELABS_HUB, IPHONE, "", ""],
        ["SAUCELABS_HUB_IPHONE_5_1_SL_OS_X_10_8", SAUCELABS_HUB, IPHONE, "5.1", "OS X 10.8"],
        ["SAUCELABS_HUB_CHROME_22_SL_OS_X_10_6", SAUCELABS_HUB, CHROME, "22", "OS X 10.6"],
        ["SAUCELABS_HUB_FIREFOX_19_SL_WINDOWS", SAUCELABS_HUB, FIREFOX, "19", "Windows"],
        ["SAUCELABS_HUB_FIREFOX_18_SL_WINDOWS_7", SAUCELABS_HUB, FIREFOX, "18", "Windows 7"],
        ["SAUCELABS_HUB_SAFARI_5_SL_OS_X_10_6", SAUCELABS_HUB, SAFARI, "5", "OS X 10.6"],
        ["SAUCELABS_HUB_OPERA_SL_WINDOWS_XP", SAUCELABS_HUB, OPERA, "", "Windows XP"],
        ["SAUCELABS_HUB_OPERA_11", SAUCELABS_HUB, OPERA, "11", ""],
        ["SAUCELABS_HUB_OPERA_11", SAUCELABS_HUB, OPERA, "11", ""]
]


pkdiff.MAC="/app/perceptualdiff"
pkdiff.WIN="/app/perceptualdiff.exe"

iconsSourceDir="src/test/resources/icons"