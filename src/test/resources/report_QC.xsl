<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    Report
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
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='manual_check'])"/>
                                                        </td>
                                                        <td>Manual check</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='Undefined'])"/>
                                                        </td>
                                                        <td>Undefined</td>
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
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='manual_check'])"/>
                                                        </td>
                                                        <td>Manual check</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <xsl:value-of
                                                                    select="count(./xmlAssert/assertion/assertResult[.='Undefined'])"/>
                                                        </td>
                                                        <td>Undefined</td>
                                                    </tr>
                                                </table>

                                                <!--
                                                True-><xsl:value-of select=" count(./xmlAssert/assertion/assertResult)"/> : <xsl:value-of select="count(./xmlAssert/assertion)"/>
                                                <br/>

                                                False-><xsl:value-of select="count(./xmlAssert/assertion)"/> : <xsl:value-of select="count(./xmlAssert/assertion)"/>
                                                -->
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


                            </table>

                            <xsl:for-each select="./xmlAssert">
                                <br/>


                                <table cellpadding="5" bgcolor="LightCyan" border="1">
                                    <tr bgcolor="LightBlue">

                                        <th>
                                            Result
                                        </th>
                                        <th>
                                            SUT data
                                        </th>
                                        <th>
                                            Expected data
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
                                                <xsl:when test="compareType='UNDEFIEND'">
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


                                            <td>
                                                <xsl:value-of select="xmlValue"/>
                                            </td>

                                            <td>
                                                <xsl:value-of select="text_sqlValue"/>
                                            </td>


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
