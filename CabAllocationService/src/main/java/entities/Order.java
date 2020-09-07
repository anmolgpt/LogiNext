package entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "order")
public class Order {
	@Id
    @GeneratedValue
    private Long orderNo;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull
    private String customerName;


    @Embedded
    private float latitude;
    
    @Embedded
    private float longitude;
    



}
