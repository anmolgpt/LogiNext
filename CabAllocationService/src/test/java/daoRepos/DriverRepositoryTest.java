package daoRepos;

import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import entities.Driver;
import enums.OnlineStatus;
import exception.EntityNotFoundException;

public class DriverRepositoryTest{

	
	 private static final String USER_NAME = "Driver2";

	    @Autowired
	    private DriverRepository driverRepository;


	    @Test
	    public void testDriverById()
	    {
	        Driver driver = null;
	        try
	        {
	            driver = driverRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: 1"));
	        }
	        catch (EntityNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        Assert.assertNotNull(driver);
	    }


	    @Test
	    public void testDriverByOnlineStatus()
	    {
	        List<Driver> onlineDrivers = driverRepository.findByOnlineStatus(OnlineStatus.AVAILABLE);
	        Assert.assertThat(onlineDrivers, hasSize(4));
	    }


	    @Test
	    public void testDriverByOfflineStatus()
	    {
	        List<Driver> offlineDrivers = driverRepository.findByOnlineStatus(OnlineStatus.BUSY);
	        Assert.assertThat(offlineDrivers, hasSize(4));
	    }


	    private Matcher hasSize(int i) {
			// TODO Auto-generated method stub
			return null;
		}


		@Test
	    public void testDriverByUsername()
	    {
	        Driver driver = driverRepository.findByUsername(USER_NAME);
	        Assert.assertNotNull(driver);
	    }
}
