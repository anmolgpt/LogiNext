package mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;

import dtos.DriverDTO;
import entities.Driver;
import utils.CoordinateUtils;

public class DriverMapper {

	
	public static Driver toEntity(DriverDTO driverDTO)
    {
        return new Driver(driverDTO.getUsername(), driverDTO.getPassword());
    }


    public static DriverDTO toDto(Object[] object)
    {
        Driver driver = (Driver) object[0];
       
        DriverDTO carDriverDTO = toDto(driver);
        return carDriverDTO;
    }


    public static DriverDTO toDto(Driver driverDO)
    {
        DriverDTO.DriverDTOBuilder driverDTOBuilder =
            DriverDTO
                .newBuilder()
                .setId(driverDO.getId())
                .setPassword(driverDO.getPassword())
                .setStatus(driverDO.getOnlineStatus().name())
                .setUsername(driverDO.getUsername())
                .setlatitude(driverDO.getLatitude())
                .setlongitude(driverDO.getLongitude());

       

        return driverDTOBuilder.createDriverDTO();
    }


    public static List<DriverDTO> toDtos(Collection<Driver> drivers)
    {
        return drivers
            .stream()
            .map(DriverMapper::toDto)
            .collect(Collectors.toList());
    }


    public static DriverDTO convertParamsToDto(Map<String, String> searchParams)
    {
        DriverDTO.DriverDTOBuilder driverDTOBuilder =
            DriverDTO
                .newBuilder()
                .setUsername(MapUtils.getString(searchParams, "username"))
                .setStatus(MapUtils.getString(searchParams, "status"));

        return driverDTOBuilder.createDriverDTO();
    }
}
