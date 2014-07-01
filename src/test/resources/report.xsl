<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    VEM
                </h1>
                <xsl:for-each select="//Report">
                    <table cellpadding="5" bgcolor="LightCyan" border="1">

                        <tr>
                            <td bgcolor="LightBlue">
                                <h3>Page</h3>
                            </td>
                            <td>
                                <h3>
                                    <b>
                                        <xsl:value-of select="ParentModuleName"/>
                                    </b>
                                </h3>
                            </td>
                        </tr>

                        <tr>
                            <td bgcolor="LightBlue">
                                <h3>Comment</h3>
                            </td>
                            <td>
                                <h3>
                                    <b>
                                        <xsl:value-of select="comment"/>
                                    </b>
                                </h3>
                            </td>
                        </tr>

                        <tr>
                            <td bgcolor="LightBlue">
                                <h3>Time</h3>
                            </td>
                            <td>
                                <h3>
                                    <b>
                                        <xsl:value-of select="time"/>
                                    </b>
                                </h3>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <br/>
                    <xsl:for-each select=".//DTO">


                        <xsl:for-each select="./xmlAssertObject">
                            <table cellpadding="5" bgcolor="LightCyan" border="1">
                                <tr>
                                    <xsl:choose>
                                        <xsl:when test="assertResult='true'">
                                            <td bgcolor="lime" rowspan="7" width="15%">
                                                <font size="5">
                                                    <xsl:value-of select="assertResult"/>
                                                </font>
                                                <br/>
                                                <br/>
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/compareType)"/>
                                                        </td>
                                                        <td>Asssertion(s)</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='true'])"/>
                                                        </td>
                                                        <td>True</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='false'])"/>
                                                        </td>
                                                        <td>False</td>
                                                    </tr>

                                                    <tr>
                                                        <td>(<xsl:value-of
                                                                select="count(./xmlAssert/assertion/compareType[.='MANUAL_CHECK'])"/>
                                                        </td>
                                                        <td>Manual check)</td>
                                                    </tr>

                                                    <tr>
                                                        <td>(<xsl:value-of
                                                                select="count(./xmlAssert/assertion/compareType[.='UNDEFINED'])"/>
                                                        </td>
                                                        <td>Undefined)</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <td bgcolor="tomato" rowspan="7" width="15%">
                                                <font size="5">
                                                    <xsl:value-of select="assertResult"/>
                                                </font>
                                                <br/>
                                                <br/>
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/compareType)"/>
                                                        </td>
                                                        <td>Asssertion(s)</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='true'])"/>
                                                        </td>
                                                        <td>True</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='false'])"/>
                                                        </td>
                                                        <td>False</td>
                                                    </tr>

                                                    <tr>
                                                        <td>(<xsl:value-of
                                                                select="count(./xmlAssert/assertion/compareType[.='MANUAL_CHECK'])"/>
                                                        </td>
                                                        <td>Manual check)</td>
                                                    </tr>

                                                    <tr>
                                                        <td>(<xsl:value-of
                                                                select="count(./xmlAssert/assertion/compareType[.='UNDEFINED'])"/>
                                                        </td>
                                                        <td>Undefined)</td>
                                                    </tr>
                                                </table>
                                            </td>

                                        </xsl:otherwise>
                                    </xsl:choose>


                                </tr>

                                <tr>
                                    <td bgcolor="LightBlue">Collection</td>
                                    <td>
                                        <b>
                                            <xsl:value-of select="moduleName"/>
                                        </b>
                                    </td>
                                </tr>

                                <tr>
                                    <td bgcolor="LightBlue">Comment</td>
                                    <td>
                                        <b>

                                            <xsl:value-of select="../comment"/>


                                        </b>
                                    </td>
                                </tr>

                                <!--tr >
                                 <td bgcolor="LightBlue">Query</td>
                                 <td><xsl:value-of select="../Query"/></td>
                               </tr-->

                                <tr>
                                    <td bgcolor="LightBlue">Anchor</td>
                                    <td>
                                        <xsl:value-of select="../anchor"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td bgcolor="LightBlue">ArrayLine</td>
                                    <td>
                                        <xsl:value-of select="../arrayLine"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td bgcolor="LightBlue">LineColumn</td>
                                    <td>
                                        <xsl:value-of select="../lineColumn"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td bgcolor="LightBlue">DbName</td>
                                    <td>
                                        <xsl:value-of select="../dbName"/>
                                    </td>
                                </tr>


                            </table>

                            <xsl:for-each select="./xmlAssert">
                                <br/>

                                <xsl:choose>
                                    <xsl:when test="queryRun='null'">
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <table cellpadding="5" bgcolor="LightCyan" border="1">
                                            <td>
                                                <xsl:value-of select="queryRun"/>
                                            </td>

                                        </table>
                                    </xsl:otherwise>
                                </xsl:choose>

                                <table cellpadding="5" bgcolor="LightCyan" border="1">
                                    <tr bgcolor="LightBlue">

                                        <th>
                                            Result
                                        </th>
                                        <th>
                                            No.
                                        </th>
                                        <th>
                                            SUT data
                                        </th>
                                        <th>
                                            Expected data
                                        </th>
                                        <th>
                                            Compare type
                                        </th>
                                        <th>
                                            Path
                                        </th>
                                        <th>
                                            ExpectedData source
                                        </th>
                                        <!--  <th>
                                        assertResultCompare
                                        </th>-->
                                    </tr>
                                    <xsl:for-each select="assertion">

                                        <tr>
                                            <xsl:choose>
                                                <xsl:when test="compareType='MANUAL_CHECK'">
                                                    <td bgcolor='#FFE4C4'>
                                                        <xsl:value-of select="assertResult"/>
                                                    </td>
                                                </xsl:when>
                                                <xsl:when test="compareType='UNDEFINED'">
                                                    <td bgcolor='yellow'>
                                                        <xsl:value-of select="assertResult"/>
                                                    </td>
                                                </xsl:when>
                                                <xsl:when test="assertResult='true'">
                                                    <td bgcolor='lime'>
                                                        <xsl:value-of select="assertResult"/>
                                                    </td>
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    <td bgcolor='tomato'>
                                                        <xsl:value-of select="assertResult"/>
                                                    </td>
                                                </xsl:otherwise>
                                            </xsl:choose>


                                            <td align="right">
                                                <xsl:value-of select="sizeOrder"/>
                                            </td>


                                            <td>
                                                <xsl:value-of select="xmlValue"/>
                                            </td>

                                            <td>
                                                <xsl:value-of select="text_sqlValue"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="compareType"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="xml"/>
                                                <br/>
                                                <xsl:value-of select="xmlType"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="text_sql"/>
                                                <xsl:choose>
                                                    <xsl:when test="regExp!=''">
                                                        <BR/>
                                                        RE:(<xsl:value-of select="regExp"/>)
                                                    </xsl:when>
                                                </xsl:choose>
                                                <br/>
                                                <font size="2">(<xsl:value-of select="text_sqlType"/>)
                                                </font>
                                            </td>

                                            <!-- <td>
                                            <xsl:value-of select="assertResultCompare"/>
                                            </td>-->

                                        </tr>
                                    </xsl:for-each>
                                    <!--"assertion " -->
                                </table>
                                <br/>
                            </xsl:for-each>
                            <!--"./xmlAssert " -->

                            <br/>
                            <br/>

                        </xsl:for-each>
                        <!--"./xmlAssertObject" -->


                    </xsl:for-each>
                    <!--"./DTO" -->
                </xsl:for-each>
                <!--"//Report" -->
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
