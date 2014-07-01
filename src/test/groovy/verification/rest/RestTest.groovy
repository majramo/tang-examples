package verification.rest

import groovyx.net.http.RESTClient
import org.apache.log4j.Logger

public class RestTest extends GroovyTestCase {
    private final static Logger log = Logger.getLogger("ROT  ")

    public void test() {
        RESTClient restClient = new RESTClient('http://www.random.org')
        def resp
        def data
        try {
            // expect an exception from a 404 response:
//            DefaultHttpClient httpclient = new DefaultHttpClient();
            //HttpHost proxy = new HttpHost('proxy.domain.com', '80');
            //httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

            resp = restClient.get(path: '/integers/?num=10&min=1&max=6&col=1&base=10&format=plain&rnd=new')
            data = resp.getData()
            log.info(data)
            assert data.head(path: 'public_timeline.json').status == 200
        }
        catch (ex) {
            assert ex.response.status == 404
            log.info(ex)
        }
    }
}
