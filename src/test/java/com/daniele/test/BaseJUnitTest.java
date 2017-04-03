package com.daniele.test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@WebAppConfiguration
public abstract class BaseJUnitTest {
	// NOTE: the @WebApplicationContext indicates the ServletContext has to be mocked
	// and provided to all the classes inheriting from this one
}
