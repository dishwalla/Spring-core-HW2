package ua.epam.spring.hometask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dish on 04.10.17.
 */
@Component
public class MapAuditoriumRepository implements AuditoriumRepository {
    
    
    @Resource(name = "auditoriumMap") //because of spring version
    private Map<String, Auditorium> auditoriums;
    
    
    @Override
    public Set<Auditorium> getAll() {
        //FIXME: if you do that to show auditoriums on screen it's bad practice to mix logic of methods
        //DONE
        //FIXME: what's problem to return initial map? or auditoriums.values() ?
        //DONE
        return new HashSet<>(auditoriums.values());
    }
    
    @Override
    public Auditorium getByName(String name) {
        Auditorium auditorium = null;
        for (Map.Entry auditoriumEntry : auditoriums.entrySet()) {
            auditorium = (Auditorium)auditoriumEntry.getValue();
            if (auditorium.getName() != null && name.equals(auditorium.getName())) {
                return auditorium;
            }
        }
        return auditorium;
    }
    
    @Override
    public Set<String> getAuditoriumNames(){
        return auditoriums.keySet();
    }
}
