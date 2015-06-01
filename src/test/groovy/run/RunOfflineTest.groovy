package run

import corebase.HtmlXmlValidationEngine
import htmls.LinkedInDatabaseVerificationHtmlDTO
import htmls.LinkedInTextAndValuesComparationHtmlDTO
import org.apache.log4j.Logger

public class RunOfflineTest {
    private final static Logger log = Logger.getLogger("ROT  ")
    static def settingsFile = "/configFiles/settings.groovy"

    static main(args) {
        InputStream is = this.getClass().getResourceAsStream(settingsFile);
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

//        htmlDtoClasses[LinkedInTextAndValuesComparationHtmlDTO.getSimpleName()] = 01
        htmlDtoClasses[LinkedInDatabaseVerificationHtmlDTO.getSimpleName()] = 01
        xmlDtoClasses["LinkedInResXMLDTO"] = 0
        restDtoClasses["searchXmlDTO"] = 0


        htmlDtoClasses.each() { htmlDtoName, htmlRun ->
            if (htmlRun && htmlDtoName != "xxx") {
                log.info "##################################################################"
                log.info "Run DTO $htmlDtoName"
                log.info ""
                xmlHtmlSourceFile = configurations.HtmlXmlSourceFilesPath + htmlDtoName + '.html'
                log.info "Reading file <$xmlHtmlSourceFile>"

                def htmlXmlSource
                try {
                    is = this.getClass().getResourceAsStream("/$xmlHtmlSourceFile");
                    htmlXmlSource = is.text
                    hxve = new HtmlXmlValidationEngine(context, htmlDtoName, htmlXmlSource, priority)
                    if (hxve != null) {
                        def xmlMarkupFileWithUtfHeader = hxve.returnAsserttionFile()
                        if (xmlMarkupFileWithUtfHeader != null) {
                            println hxve.returnAssertResult()
                            log.info ""
                            log.info ""
                            log.info "Run result " + hxve.returnAssertResult()
                            log.info "Check results in file $xmlMarkupFileWithUtfHeader"
                            log.info "Done DTO $htmlDtoName"
                        } else {
                            log.info "htmlDtoName is not valid"
                            log.info "Canceled DTO $htmlDtoName"
                        }
                        log.info "##################################################################"
                    }
                } catch (FileNotFoundException e) {
                    log.error "Can't find file <$xmlHtmlSourceFile> $e"
                    log.info "Canceled DTO $htmlDtoName"
                }
            }
//			restDtoClasses.each(){restDtoName, restRun->
//				if(restRun && restDtoName != "xxx"){
//					log.info "##################################################################"
//					log.info "DTO $restDtoName"
//					log.info ""
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
//						def xmlMarkupFileWithUtfHeader = hxve.returnAsserttionFile()
//						if(xmlMarkupFileWithUtfHeader != null){
//							log.info "Check results"
//							log.info "\n$xmlMarkupFileWithUtfHeader"
//							log.info "Done $restDtoName"
//						}else{
//							log.info "restDtoName is not valid"
//							log.info "CANCELED			$restDtoName"
//						}
//						log.info "##################################################################"
////					}
//				}
//			}

        }

    }
}
