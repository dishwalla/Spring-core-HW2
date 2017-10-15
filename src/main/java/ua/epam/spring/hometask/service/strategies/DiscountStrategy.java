package ua.epam.spring.hometask.service.strategies;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import java.util.Date;

/**
 * Created by dish on 09.10.17.
 */
public interface DiscountStrategy {
    //FIXME: in original method there was user argument, it looks more logical rather pass some 'birthday' - birthday is not entity, as eventDate - better pass event
    int getDiscountPercentage(User user, Event event, Date airDateTime, long numberOfTickets);
}
