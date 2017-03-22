import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@WebAppConfiguration
public abstract class BaseJUnitTest {
	// NOTE: the abstract provides all the subclasses with a mock ServletContext by means of 
	// @WebApplicationContext required by Spring MVC.
}
