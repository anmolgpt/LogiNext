import java.time.ZonedDateTime;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import dtos.DriverDTO;
import entities.Driver;
import enums.OnlineStatus;

@RunWith(MockitoJUnitRunner.class)
	public abstract class CabAllocationTest
	{

	  

	    public Driver getDriver()
	    {
	        Driver driver = new Driver();
	        driver.setId(1L);
	        driver.setDateCreated(ZonedDateTime.now());
	        driver.setUsername("Driver9");
	        driver.setPassword("pass");
	        driver.setOnlineStatus(OnlineStatus.AVAILABLE);
	        driver.setLatitude(40.54f);
	        driver.setLongitude(30.98f);
	        return driver;
	    }


	    public DriverDTO getDriverDTO()
	    {
	        return DriverDTO
	            .newBuilder()
	            .setId(1L)
	            .setPassword("Driver10")
	            .setUsername("pass")
	            .setlatitude(40)
	            .setlongitude(30)
	            .createDriverDTO();
	    }


	  
}

