package ua.epam.spring.hometask.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.service.BookingService;

/**
 * Created by dish on 01.10.17.
 */
@Component
public class TicketLogic {
    
    @Autowired
    private BookingService bookingService;
    
    public BookingService getBookingService() {
        return bookingService;
    }
    
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
}
