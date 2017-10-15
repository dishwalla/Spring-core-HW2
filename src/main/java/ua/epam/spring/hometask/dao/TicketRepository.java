package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

/**
 * Created by dish on 01.10.17.
 */
public interface TicketRepository {
    
    //FIXME: if ticket repository is DAO then strange to have method which seems doing some booking process (especial you have this method in service layer)
    //DONE: renamed to be more relevant
    public void saveTickets(Set<Ticket> tickets);
    
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, Date dateTime);
}
