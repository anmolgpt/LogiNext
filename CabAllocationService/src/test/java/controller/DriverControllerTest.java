package controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.springframework.http.MediaType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.DriverDTO;
import entities.Driver;
import mapper.DriverMapper;
import service.DriverService;

public class DriverControllerTest {
	private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mvc;

    @Mock
    private DriverService driverService;

    

    @InjectMocks
    private DriverController driverController;


    @BeforeTestClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(DriverController.class);
    }


    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(driverController).dispatchOptions(true).build();
    }


    @Test
    public void testSelectCarByDriver() throws Exception
    {
        DriverDTO driverData = getDriverDTO();

        doReturn(driverData).when(driverService).selectCarByDriver(any(Long.class), any(Long.class));

        driverController.selectCarByDriver(1L, 1L);

        MvcResult result =
            mvc
                .perform(
                    post("/v1/drivers/select")
                        .param("driverId", "1")
                        .param("carId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        final String responseBody = result.getResponse().getContentAsString();

        Assert.assertTrue(responseBody.contains("test"));

    }


    private DriverDTO getDriverDTO() {
		// TODO Auto-generated method stub
		return null;
	}


	

    @Test
    public void testGetDriver() throws Exception
    {
        Driver driverData = getDriver();
        
        doReturn(driverData).when(driverService).find(any(Long.class));
        driverController.getDriver(1L);
        MvcResult result =
            mvc
                .perform(get("/v1/drivers/{driverId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("test"));
    }


    private Driver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}


	@Test
    public void testUpdateLocation() throws Exception
    {
        doNothing().when(driverService).updateLocation(any(Long.class), any(Double.class), any(Double.class));
        driverController.updateLocation(1L, 99, 99);
        MvcResult result =
            mvc
                .perform(
                    put("/v1/drivers/{driverId}", 1)
                        .param("longitude", "50").param("latitude", "60"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }


    @Test
    public void testCreateDriver() throws Exception
    {
        DriverDTO driverData = getDriverDTO();
        Driver driverDO = DriverMapper.toEntity(driverData);
        
        String jsonInString = mapper.writeValueAsString(driverData);
        doReturn(driverDO).when(driverService).create(any(Driver.class));
        
        driverController.createDriver(driverData);
        MvcResult result =
            mvc
                .perform(
                    post("/v1/drivers")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonInString))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("test"));

    }


    
}
