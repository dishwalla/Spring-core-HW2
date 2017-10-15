package ua.epam.spring.hometask;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import ua.epam.spring.hometask.domain.Auditorium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dish on 15.10.17.
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="ua.epam.spring")
@PropertySource(
    value={"classpath:auditorium_a.properties", "classpath:auditorium_b.properties", "classpath:auditorium_o.properties"})
public class Config implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;
    
    @Bean(name="auditoriumMap")
    public Map<String, Auditorium> auditoriumMap(){
        Environment env = applicationContext.getEnvironment();
        env.getProperty("b.name");
        env.getProperty("b.number_of_seats");
        env.getProperty("b.vip_seats");
        env.getProperty("o.name");
        env.getProperty("o.number_of_seats");
        env.getProperty("o.vip_seats");
        Set<Long> aSeats = getSeats(env, "a.vip_seats");
        Set<Long> bSeats = getSeats(env, "b.vip_seats");
        Set<Long> oSeats = getSeats(env, "o.vip_seats");
        Auditorium a = new Auditorium(env.getProperty("a.name"), Long.parseLong(env.getProperty("a.number_of_seats")), aSeats);
        Auditorium b = new Auditorium(env.getProperty("b.name"), Long.parseLong(env.getProperty("b.number_of_seats")), bSeats);
        Auditorium o = new Auditorium(env.getProperty("o.name"), Long.parseLong(env.getProperty("o.number_of_seats")), oSeats);
        Map<String, Auditorium> auditoriumMap = new HashMap<>();
        auditoriumMap.put("Alfa", a);
        auditoriumMap.put("Beta", b);
        auditoriumMap.put("Omega", o);
        return auditoriumMap;
    }
    
    private Set<Long> getSeats(Environment env, String pName) {
        return Arrays.stream(env.getProperty(pName).split(","))
            .map(e -> Long.parseLong(e))
            .collect(Collectors.toSet());
    }
    
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
