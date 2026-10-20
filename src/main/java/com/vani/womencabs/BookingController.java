package com.vani.womencabs;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingRepository repository;
    public BookingController(BookingRepository repository){this.repository=repository;}

    @PostMapping("/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@Valid @RequestBody BookingRequest r){
        Booking b=new Booking();
        b.setCustomerName(r.getCustomerName().trim()); b.setPhone(r.getPhone().trim());
        b.setPickup(r.getPickup().trim()); b.setDestination(r.getDestination().trim());
        b.setStatus("REQUESTED");
        // Demo-only assignment and formula; not a live quote or dispatch.
        b.setDriverName("Demo Driver Priya"); b.setCarNumber("VANI-DEMO-01");
        b.setEstimatedFare(180 + (Math.abs(r.getPickup().length()-r.getDestination().length())*12));
        return repository.save(b);
    }
    @GetMapping("/bookings")
    public List<Booking> all(){
        List<Booking> list=repository.findAll();
        Collections.reverse(list);
        return list;
    }
    @PatchMapping("/bookings/{id}/status")
    public Booking status(@PathVariable Long id,@RequestBody Map<String,String> body){
        Booking b=repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Booking not found"));
        String s=body.getOrDefault("status","").toUpperCase(Locale.ROOT);
        if(!Set.of("REQUESTED","CONFIRMED","RIDE_STARTED","COMPLETED","CANCELLED").contains(s))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid status");
        b.setStatus(s); return repository.save(b);
    }
    @PostMapping("/safety/sos")
    public Map<String,String> sos(@RequestBody(required=false) Map<String,String> body){
        String id=body==null?"not provided":body.getOrDefault("bookingId","not provided");
        System.out.println("SIMULATED SOS for booking "+id+" — no emergency contact notified.");
        return Map.of("result","SIMULATED_ONLY","message","Demo SOS recorded. No emergency service or contact was notified.");
    }
}
