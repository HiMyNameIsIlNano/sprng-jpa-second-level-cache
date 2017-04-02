import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daniele.hibernate.dao.exception.UserDetailsNotFoundException;
import com.daniele.hibernate.service.UserService;
import com.daniele.hibernate.shared.JsonUtils;

public class JsonHelperTest extends BaseJUnitTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void postMethodJsonRequest() throws UserDetailsNotFoundException {
		System.out.println(JsonUtils.prettyJsonString(userService.getUserById(1)));
	}
}
