package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.util.Optionals;

import daoRepos.DriverRepository;
import dtos.DriverDTO;
import entities.Driver;
import enums.OnlineStatus;
import exception.CarAlreadyInUseException;
import exception.ConstraintsViolationException;
import exception.EntityNotFoundException;
import mapper.DriverMapper;

//import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;


//@Slf4j
public class DriverServiceImpl {

	
    private static org.slf4j.Logger log = LoggerFactory.getLogger(DriverServiceImpl.class);



	    @Autowired
	    private DriverRepository driverRepository;

	    
	    /**
	     * Find all drivers according given Params
	     *
	     * @param onlineStatus , customerLongitude , customerLatitude
	     */

	    public List<DriverDTO> findDriversByFilterCriteria(Map<String, String> params) throws EntityNotFoundException
	    {
	        List<DriverDTO> driverDataList = new ArrayList<>();
	        try
	        {
	            DriverDTO driverFilter = DriverMapper.convertParamsToDto(params);

	            List<Object[]> drivers = driverRepository.findDriverByFilterCriteria(driverFilter);

	            drivers.forEach(object -> driverDataList.add(DriverMapper.toDto(object)));
	        }
	        catch (Exception e)
	        {
	            throw new EntityNotFoundException("Driver entity not found ");
	        }

	        return driverDataList;
	    }

	    /**
	     * Selects a driver by id.
	     *
	     * @param driverId
	     * @return found driver
	     * @throws EntityNotFoundException if no driver with the given id was found.
	     */
	    public Driver find(Long driverId) throws EntityNotFoundException
	    {
	        return findDriverChecked(driverId);
	        
	    }


	    /**
	     * Creates a new driver.
	     *
	     * @param driverDO
	     * @return
	     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
	     */
	    public Driver create(Driver driverDO) throws ConstraintsViolationException
	    {
	        Driver driver;
	        try
	        {
	            driver = driverRepository.save(driverDO);
	        }
	        catch (DataIntegrityViolationException e)
	        {
	            log.warn("Some constraints are thrown due to driver creation", e);
	            throw new ConstraintsViolationException(e.getMessage());
	        }
	        return driver;
	    }


	   

	    /**
	     * Update the location for a driver.
	     *
	     * @param driverId
	     * @param longitude
	     * @param latitude
	     * @throws EntityNotFoundException
	     */
	    @Transactional
	    public void updateLocation(long driverId, float longitude, float latitude) throws EntityNotFoundException
	    {
	        Driver driverDO = findDriverChecked(driverId);
	        driverDO.setLatitude(latitude);
	        driverDO.setLongitude(longitude);
	    }


	    /**
	     * Find all drivers by online state.
	     *
	     * @param onlineStatus
	     */
	    public List<Driver> find(OnlineStatus onlineStatus)
	    {
	        return driverRepository.findByOnlineStatus(onlineStatus);
	    }


	    private Driver findDriverChecked(Long driverId) throws EntityNotFoundException
	    {
	        return driverRepository
	            .findById(driverId)
	            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
	    }


	   
}
