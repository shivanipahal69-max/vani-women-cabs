package com.vani.womencabs;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phone;
    private String pickup;
    private String destination;
    private String status;
    private String driverName;
    private String carNumber;
    private double estimatedFare;
    private LocalDateTime createdAt;

    public Booking() {}
    @PrePersist public void onCreate() { if (createdAt == null) createdAt = LocalDateTime.now(); }
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getPickup(){return pickup;} public void setPickup(String v){pickup=v;}
    public String getDestination(){return destination;} public void setDestination(String v){destination=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getDriverName(){return driverName;} public void setDriverName(String v){driverName=v;}
    public String getCarNumber(){return carNumber;} public void setCarNumber(String v){carNumber=v;}
    public double getEstimatedFare(){return estimatedFare;} public void setEstimatedFare(double v){estimatedFare=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
