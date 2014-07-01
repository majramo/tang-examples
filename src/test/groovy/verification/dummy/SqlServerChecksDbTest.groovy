package verification.dummy

import base.AnySqlTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

public class SqlServerChecksDbTest extends AnySqlTest {

    private static final String PHRASE = "phrase"
    private static final String HITS = "hits"
    private static final String COUNTRY = "country"
    private static final String IKEA_TABLE_TO_SEARCH = "IkeaSearchPhrases"
    private static final String LINKED_IN_TABLE_TO_SEARCH = "LinkedInProfile"
    private static final String GIVEN_NAME = "givenName"
    private static final String FAMILY_NAME = "familyName"

    @Test(dataProvider = "ikeaDataProvider1")
    public void test1_1(String table, String field) {
        checkDuplicateOfRowsRegardingFieldsInTableQuery(table, field)
    }

    @Test(dataProvider = "linkedInDataProvider1")
    public void test1_2(String table, String field) {
        checkDuplicateOfRowsRegardingFieldsInTableQuery(table, field)
    }

    @Test
    public void test2_1() {
        checkDuplicateOfRowsRegardingFieldsInTableQuery(IKEA_TABLE_TO_SEARCH, PHRASE)
    }

    @Test
    public void test2_2() {
        checkDuplicateOfRowsRegardingFieldsInTableQuery(IKEA_TABLE_TO_SEARCH, PHRASE, HITS)
    }

    @Test
    public void test2_3() {
        checkDuplicateOfRowsRegardingFieldsInTableQuery(IKEA_TABLE_TO_SEARCH, PHRASE, HITS, COUNTRY)
    }

//    @Test(dataProvider = "dataProvider2" )
//    public void test2(String table, String[] fields) {
//        checkDuplicateOfRowsRegardingFieldsInTableQuery(table, fields)
//    }


    @Test(dataProvider = "ikeaDataProvider1")
    public void test3(String table, String field) {
        checkNullValueInFieldInTableQuery(table, field)
    }


    @Test(dataProvider = "ikeaDataProvider1")
    public void test4(String table, String field) {
        checkNullValueInFieldInTableQuery(table, field)
    }


    @Test(dataProvider = "ikeaDataProvider1")
    public void test5(String table, String field) {
        checkEmptyValueInFieldInTableQuery(table, field)
    }


    @DataProvider(name = "ikeaDataProvider1")
    public Object[][] ikeaDataProvider1() {

        return [
                [IKEA_TABLE_TO_SEARCH, PHRASE],
                [IKEA_TABLE_TO_SEARCH, HITS],
                [IKEA_TABLE_TO_SEARCH, COUNTRY],
                [IKEA_TABLE_TO_SEARCH, COUNTRY],
                [IKEA_TABLE_TO_SEARCH, COUNTRY],
        ] as Object[][]
    }


    @DataProvider(name = "linkedInDataProvider1")
    public Object[][] linkedInDataProvider1() {

        return [
                [LINKED_IN_TABLE_TO_SEARCH, GIVEN_NAME],
                [LINKED_IN_TABLE_TO_SEARCH, FAMILY_NAME],
        ] as Object[][]
    }

    @DataProvider(name = "dataProvider2")
    public Object[][] dataProvider2() {
        String[] search1 = [COUNTRY]
        String[] search2 = [COUNTRY, PHRASE]

        return [
                [IKEA_TABLE_TO_SEARCH, search2]
        ] as Object[][]
    }
}
