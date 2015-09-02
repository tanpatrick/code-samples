package training.spring.mvc.sample.rest;

import training.spring.mvc.sample.config.RestTextContext;
import org.apache.log4j.Logger;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import training.spring.mvc.sample.config.WebAppContext;
import training.spring.mvc.sample.model.Parent;
import training.spring.mvc.sample.service.BasicService;

/**
 *
 * @author Patrick Tan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestTextContext.class, WebAppContext.class})
@WebAppConfiguration
public class RestControllerTest {

    private static final Logger LOGGER = Logger.getLogger(RestControllerTest.class);
    private MockMvc mockMvc;
    @Autowired
    private BasicService basicServiceMock;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        LOGGER.info("Setting up test dependencies ...");
        
        Mockito.reset(basicServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        when(basicServiceMock.getParentById(1))
                .thenReturn(new Parent(1, "Patrick"));

    }

    @Test
    public void testGetParentById_ShouldReturnParent() throws Exception {
        mockMvc.perform(get("/rest/api/parent/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("parentName", is("Patrick")));

        verify(basicServiceMock, times(1)).getParentById(1);
        verifyNoMoreInteractions(basicServiceMock);
    }

    @Test
    public void testGetParentById_ShouldReturn404() throws Exception {
        mockMvc.perform(get("/rest/api/parent"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetParentById_ShouldReturnNullParent() throws Exception {
        mockMvc.perform(get("/rest/api/parent/{id}", 2))
                .andExpect(status().isOk());

        Assert.assertNull(verify(basicServiceMock).getParentById(2));
        verifyNoMoreInteractions(basicServiceMock);
    }
}
