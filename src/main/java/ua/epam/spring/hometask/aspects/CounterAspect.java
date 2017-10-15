package ua.epam.spring.hometask.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Event;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dish on 15.10.17.
 */

@Aspect
@Component
public class CounterAspect {
    
    private Map<String, Integer> eventsByName = new HashMap<>();
    private Map<String, Integer> eventsByPrice = new HashMap<>();
    private Integer ticketsBooked = 0;
    
    @Before("execution(* ua.epam.spring.hometask.service.BookingService.bookTickets(..))")
    public void countTicketsBooked() {
        ticketsBooked++;
        System.out.println("Tickets have been booked for: " + ticketsBooked + " times");
    }
    
    @Before("execution(* ua.epam.spring.hometask.service.BookingService.getTicketsPrice(..))")
    public void countEventsByPrice(JoinPoint joinPoint) {
        Event event = (Event)joinPoint.getArgs()[0];
        Integer cnt = eventsByPrice.get(event.getName());
        if (cnt == null) {
            cnt = 0;
            eventsByPrice.put(event.getName(), cnt);
        }
        eventsByPrice.put(event.getName(), ++cnt);
        System.out.println("Event's prices were queried: " + eventsByPrice + " times");
    }
    
}
