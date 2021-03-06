#set($class.package = 'org.asqatasun.webapp.test')
#set($testPrefix = 'Test')
#set($name = $model.name.replace('-', '_'))
#set($class.name = "$name$testPrefix")

package $class.package;
import org.asqatasun.webapp.test.data.KrashtestResult;

public class $class.name extends AbstractAsqatasunOnlineTest {

    private String siteName = "$model.name";
    private String[] url = {"$model.url"};

    /**
     * Default constructor
     */
    public $class.name (){
        super();
    }

    public void testWebappResult(){
        assertEquals(KrashtestResult.SUCCESS.toString(), computeWebappResult(
                launchAsqatasun(siteName, url, false)));
    }

}
