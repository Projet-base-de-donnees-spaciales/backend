package ilisi.ma.projetmoveanddescover.events.configuaration;


import ilisi.ma.projetmoveanddescover.events.controllers.mappers.CategoryControllerMapper;
import ilisi.ma.projetmoveanddescover.events.controllers.mappers.EventControllerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {
    @Bean
    public CategoryControllerMapper categoryControllerMapper(){
        return Mappers.getMapper(CategoryControllerMapper.class);
    }
    @Bean
    public EventControllerMapper eventControllerMapper(){
        return Mappers.getMapper(EventControllerMapper.class);
    }


}
