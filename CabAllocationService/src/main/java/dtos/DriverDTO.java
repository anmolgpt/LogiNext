package dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDTO {
	@JsonIgnore
    private float id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String status;

    @NotNull
    private float latitude;
    
    @NotNull
    private float longitude;


    private DriverDTO()
    {}


    private DriverDTO(float id, String username, String password, String status, float latitide , float longitude )
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //nested Class - DriverDTOBuilder
    public static DriverDTOBuilder newBuilder()
    {
        return new DriverDTOBuilder();
    }


	public float getId() {
		return id;
	}


	public void setId(float id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getlongitude() {
		return longitude;
	}


	public void setlongitude(float longitude) {
		this.longitude = longitude;
	}
    
    
	
	
	
	public static class DriverDTOBuilder
    {
        private float id;
        private String username;
        private String password;
        private String status;
        private Float latitude;
        private Float longitude;


        public DriverDTOBuilder setId(float id)
        {
            this.id = id;
            return this;
        }


        public DriverDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public DriverDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }


        public DriverDTOBuilder setStatus(String status)
        {
            this.status = status;
            return this;
        }


        public DriverDTOBuilder setlatitude(float latitude)
        {
            this.latitude = latitude;
            return this;
        }

        public DriverDTOBuilder setlongitude(float longitude)
        {
            this.longitude = longitude;
            return this;
        }

       


        public DriverDTO createDriverDTO()
        {
            return new DriverDTO(id, username, password, status, latitude ,longitude);
        }


		
    }

}
