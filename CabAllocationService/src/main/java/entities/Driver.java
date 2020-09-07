package entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import constants.CoordinatesConstants;
import enums.OnlineStatus;
import lombok.Data;

@Data
@Entity
@Table(name = "driver")
public class Driver {
	
	
		public Driver(String username2, String password2) {
		// TODO Auto-generated constructor stub
	}

		public Driver() {
			// TODO Auto-generated constructor stub
		}

		@Id
	    @GeneratedValue
	    private Long id;

	    @Column(nullable = false)
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	    private ZonedDateTime dateCreated = ZonedDateTime.now();

	    @Column(nullable = false)
	    @NotNull
	    private String username;

	    @Column(nullable = false)
	    @NotNull
	    private String password;


	    @Embedded
	    private float latitude;
	    
	    @Embedded
	    private float longitude;
	    
	    @Column
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	    private ZonedDateTime dateCoordinateUpdated = ZonedDateTime.now();

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private OnlineStatus onlineStatus;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public ZonedDateTime getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(ZonedDateTime dateCreated) {
			this.dateCreated = dateCreated;
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

		public ZonedDateTime getDateCoordinateUpdated() {
			return dateCoordinateUpdated;
		}

		public void setDateCoordinateUpdated(ZonedDateTime dateCoordinateUpdated) {
			this.dateCoordinateUpdated = dateCoordinateUpdated;
		}

		public OnlineStatus getOnlineStatus() {
			return onlineStatus;
		}

		public void setOnlineStatus(OnlineStatus onlineStatus) {
			this.onlineStatus = onlineStatus;
		}

		public float getLatitude() {
			return latitude;
		}

		public float getLongitude() {
			return longitude;
		}

		public void setLatitude(float latitude) {
			if(latitude<= CoordinatesConstants.MIN_LATITUDE && latitude >= CoordinatesConstants.MAX_LATITUDE)
			this.latitude = latitude;
		}

		public void setLongitude(float longitude) {
			
	        if(longitude <= CoordinatesConstants.MIN_LONGITUDE && longitude <= CoordinatesConstants.MAX_LONGITUDE)
			this.longitude = longitude;
		}

		



}
