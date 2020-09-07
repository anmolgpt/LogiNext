package controller;

import java.util.List;
import java.util.Map;

import exception.EntityNotFoundException;
import mapper.DriverMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dtos.DriverDTO;
import entities.Driver;
import enums.OnlineStatus;
import exception.CarAlreadyInUseException;
import exception.ConstraintsViolationException;
import service.DriverService;

@RestController
@RequestMapping("v1/drivers")
public class DriverController
{

    private final DriverService driverService;


    @Autowired
    public DriverController(final DriverService driverService)
    {
        this.driverService = driverService;
    }

    
    @PostMapping("/search")
    public List<DriverDTO> findDriversByFilterCriteria(@RequestBody Map<String, String> params)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        return driverService.findDriversByFilterCriteria(params);
    }

    @GetMapping("/{driverId}")
    public DriverDTO getDriver(@Validated @PathVariable long driverId) throws EntityNotFoundException
    {
        return DriverMapper.toDto(driverService.find(driverId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO createDriver(@Validated @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException
    {
        Driver driverDO = DriverMapper.toEntity(driverDTO);
        return DriverMapper.toDto(driverService.create(driverDO));
    }



    @PutMapping("/{driverId}")
    public void updateLocation(
        @Validated @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        driverService.updateLocation(driverId, longitude, latitude);
    }


    @GetMapping
    public List<DriverDTO> findDriversByStatus(@RequestParam OnlineStatus onlineStatus)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        return DriverMapper.toDtos(driverService.find(onlineStatus));
    }


    @PostMapping("/select")
    public DriverDTO selectCarByDriver(@RequestParam long driverId, @RequestParam long carId)
        throws EntityNotFoundException,
        CarAlreadyInUseException
    {

        return driverService.selectCarByDriver(driverId, carId);
    }




   

}
