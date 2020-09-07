package daoRepos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dtos.DriverDTO;
import entities.Driver;
import enums.OnlineStatus;

public interface DriverRepository extends CrudRepository<Driver, Long>
	{
	    Driver findByUsername(final String username);


	    List<Driver> findByOnlineStatus(OnlineStatus onlineStatus);


	    @Query("SELECT D FROM  Driver D "
	            +
	            "WHERE SQRT(\n" + 
	            "\n" + 
	            "	    POW(69.1 * (latitude - [0]), 2) +\n" + 
	            "\n" + 
	            "	    POW(69.1 * ([180] - longitude) * COS(latitude / 57.3), 2)))")
		List<Object[]> findDriverByFilterCriteria(@Param("driverData") final DriverDTO driverData);
	}

