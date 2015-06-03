package run

import corebase.HtmlXmlValidationEngine
import htmls.LinkedInDatabaseVerificationHtmlDTO
import org.apache.log4j.Logger

public class RunOfflineTest {
    private final static Logger logger = Logger.getLogger("ROT  ")
    static def s_settingsFile = "/configFiles/settings.groovy"

    static main(args) {
        InputStream is = this.getClass().getResourceAsStream(s_settingsFile);
        String content = is.text
        def configurations = new ConfigSlurper().parse(content)
        def xmlHtmlSourceFile
        HtmlXmlValidationEngine hxve
        def xmlDtoClasses = [:]
        def htmlDtoClasses = [:]
        def restDtoClasses = [:]

        Map context = [:]
        context["country"] = "SE"
        context["testId"] = "majid"

        Integer priority = 1

//        htmlDtoClasses[LinkedInTextAndValuesComparisonHtmlDTO.getSimpleName()] = 1
        htmlDtoClasses[LinkedInDatabaseVerificationHtmlDTO.getSimpleName()] = 1
        xmlDtoClasses["LinkedInResXMLDTO"] = 0
        restDtoClasses["searchXmlDTO"] = 0


        htmlDtoClasses.each() { htmlDtoName, htmlRun ->
            if (htmlRun && htmlDtoName != "xxx") {
                logger.info "##################################################################"
                logger.info "Run DTO $htmlDtoName"
                logger.info ""
                xmlHtmlSourceFile = configurations.HtmlXmlSourceFilesPath + htmlDtoName + '.html'
                logger.info "Reading file <$xmlHtmlSourceFile>"

                def htmlXmlSource
                try {
                    is = this.getClass().getResourceAsStream("/$xmlHtmlSourceFile");
                    htmlXmlSource = is.text
                    hxve = new HtmlXmlValidationEngine(context, htmlDtoName, htmlXmlSource, priority)
                    if (hxve != null) {
                        def xmlMarkupFileWithUtfHeader = hxve.returnAssertFile()
                        if (xmlMarkupFileWithUtfHeader != null) {
                            println hxve.returnAssertResult()
                            logger.info ""
                            logger.info ""
                            logger.info "Run result " + hxve.returnAssertResult()
                            logger.info "Check results in file $xmlMarkupFileWithUtfHeader"
                            logger.info "Done DTO $htmlDtoName"
                        } else {
                            logger.info "htmlDtoName is not valid"
                            logger.info "Canceled DTO $htmlDtoName"
                        }
                        logger.info "##################################################################"
                    }
                } catch (FileNotFoundException e) {
                    logger.error "Can't find file <$xmlHtmlSourceFile> $e"
                    logger.info "Canceled DTO $htmlDtoName"
                }
            }
//			restDtoClasses.each(){restDtoName, restRun->
//				if(restRun && restDtoName != "xxx"){
//					logger.info "##################################################################"
//					logger.info "DTO $restDtoName"
//					logger.info ""
//
//					RESTClient rest = new RESTClient( 'http://localhost:8088/mockSampleServiceSoapBindingseasrch/' )
//					rest.setContentType(ContentType.XML)
//					 
//					def r
//					try {
//						// expect an exception from a 404 response:
//						r = rest.get path:'search'
//						println rest.getContentType()
//						println r.getData()
//						def f = rest.parseResponse(rest, rest.getContentType())
//					}
//					// The exception is used for flow control but has access to the response as well:
//					catch( ex ) { 
//						assert ex.response.status == 404 
//						}
//
//					println r
//					println r.getData()
//					def restSource =  r.asType(XMLDocument)

//					//def restSource = new ConfigSlurper().parse( a.toString())
//					hxve = new HtmlXmlValidationEngine(context, restDtoName, r , priority)
//					if(hxve != null){
//						def xmlMarkupFileWithUtfHeader = hxve.returnAssertFile()
//						if(xmlMarkupFileWithUtfHeader != null){
//							logger.info "Check results"
//							logger.info "\n$xmlMarkupFileWithUtfHeader"
//							logger.info "Done $restDtoName"
//						}else{
//							logger.info "restDtoName is not valid"
//							logger.info "CANCELED			$restDtoName"
//						}
//						logger.info "##################################################################"
////					}
//				}
//			}

        }

    }
}
