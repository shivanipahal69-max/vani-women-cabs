package com.vani.womencabs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class BookingRequest {
    @NotBlank(message="Please enter your name") private String customerName;
    @NotBlank(message="Please enter your phone number")
    @Pattern(regexp="[0-9]{10}", message="Phone number must contain 10 digits") private String phone;
    @NotBlank(message="Please enter pickup location") private String pickup;
    @NotBlank(message="Please enter destination") private String destination;
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getPickup(){return pickup;} public void setPickup(String v){pickup=v;}
    public String getDestination(){return destination;} public void setDestination(String v){destination=v;}
}
