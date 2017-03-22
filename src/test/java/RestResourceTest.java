import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.daniele.hibernate.model.Address;
import com.daniele.hibernate.model.UserDetails;
import com.daniele.hibernate.rest.UserResource;
import com.daniele.hibernate.service.UserDetailsService;
import com.daniele.hibernate.shared.JsonUtils;


@RunWith(MockitoJUnitRunner.class)
public class RestResourceTest {
	
	private MockMvc mockMvc;
	
	@Mock
	UserDetailsService userDetailsService;
	
	// Inside the UserResource the bean UserDetailsService is substituted with the bean annotated @Mock within this class
    @InjectMocks
    private UserResource userResource;
	
    @Before
    public void setUp() {
    	mockMvc = MockMvcBuilders.standaloneSetup(userResource).build();
		MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testMockitoInjection() {
		Assert.assertTrue(userDetailsService != null);
    }
    
    @Test
    public void readUserDetails() throws Exception {
        /*
    	int detailId = 1;
    	Mockito.when(userDetailsService.getUserById(1)).thenReturn(userDetails);
    	mockMvc.perform(MockMvcRequestBuilders.get("/rest/" + detailId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(this.bookmarkList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].uri", is("http://bookmark.com/1/" + userName)))
        );
        */
    }
    
    @Test
    public void testCreationOfANewUser() throws Exception {
    	UserDetails userDetails = getDummyUserDetails(1);
    	String userDetailsAsString = JsonUtils.prettyJsonString(userDetails);
    	
        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDetailsAsString))
                .andExpect(status().isOk());
    }
    
    private UserDetails getDummyUserDetails(int i) {
    	Address address = new Address();
		address.setCity("City" + i);
		address.setStreet("Dummy Street N." + i);
		address.setZipcode("9009" + i);
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName("User" + i);
		userDetails.setDescription("Description field " + i);
		userDetails.setAddress(address);
		userDetails.setJoinDate(new Date());
		
		address.setUserDetails(userDetails);
		return userDetails;
    }
}
