import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserDetails;
import com.daniele.hibernate.service.UserDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class JpaTest {  
	
	@Autowired
	private UserDetailsService userDetailsService;
	
    @Test
    public void testCountUsers() {
        Assert.assertEquals(5, userDetailsService.countUsers());
    }
    
    @Test
    public void testfindUser() throws UserDetailsNotFoundException {
    	Assert.assertTrue(Objects.equals(Long.valueOf(1L), userDetailsService.getUserById(1).getId()));
    }
    
    @Test
    public void testfindAllUsers() {
    	List<UserDetails> userDetailList = userDetailsService.getAllUsers();
    	userDetailList.stream().forEach(el -> System.out.println(el.toString()));
    	Assert.assertTrue(userDetailList.size() > 0);
    }
    
    @Test
    public void testfindUsersLike() {
    	Assert.assertTrue(userDetailsService.getUsersLike("User%").size() > 0);
    }
}