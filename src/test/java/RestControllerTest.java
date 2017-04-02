import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

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
import com.daniele.hibernate.model.UserAccount;
import com.daniele.hibernate.rest.UserController;
import com.daniele.hibernate.service.UserService;
import com.daniele.hibernate.shared.JsonUtils;

@RunWith(MockitoJUnitRunner.class)
public class RestControllerTest {

    private MockMvc mockMvc;
    
    private static UserAccount user;

    @Mock
    UserService userDetailsService;

    // Inside the UserResource the bean UserDetailsService is substituted with the bean annotated @Mock within this class
    @InjectMocks
    private UserController userResource;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userResource).build();
        user = getDummyUser(1);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockitoInjection() {
        Assert.assertTrue(userDetailsService != null);
    }

    @Test
    public void readUserDetails() throws Exception {
        Assert.assertNotNull(user);
    	when(userDetailsService.getUserById(1)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/{id}", 1))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void testCreationOfANewUser() throws Exception {
    	Assert.assertNotNull(user);
    	String userDetailsAsString = JsonUtils.prettyJsonString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userDetailsAsString))
            .andExpect(status().isOk());
    }

    private UserAccount getDummyUser(int i) {
        Address address = new Address.AddressBuilder().withCity("City " + i).withStreet("Dummy Street")
                .withStreetNumber((short) i).withZipCode("9009" + i).build();

        UserAccount user = new UserAccount.UserBuilder().withName("User" + i).withDescription("Description field " + i)
                .withAddress(address).withJoinDate(LocalDate.now()).build();

        return user;
    }
}
