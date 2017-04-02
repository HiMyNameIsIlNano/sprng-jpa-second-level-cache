import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.model.UserAccount;
import com.daniele.hibernate.service.UserService;

public class JpaTest extends BaseJUnitTest {  
	
	@Autowired
	private UserService userService;
	
    @Test
    public void testCountUsers() {
        Assert.assertEquals(5, userService.countUsers());
    }
    
    @Test
    public void testfindUser() throws UserDetailsNotFoundException {
    	Assert.assertTrue(Objects.equals(Long.valueOf(1L), userService.getUserById(1).getId()));
    }
    
    @Test
    public void testfindAllUsers() {
    	List<UserAccount> userList = userService.getAllUsers();
    	userList.stream().forEach(el -> System.out.println(el.toString()));
    	Assert.assertTrue(userList.size() > 0);
    }
    
    @Test
    public void testfindUsersLike() {
    	Assert.assertTrue(userService.getUsersLike("John%").size() > 0);
    }
}