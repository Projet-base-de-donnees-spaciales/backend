package ilisi.ma.projetmoveanddescover.user.configuaration;

import ilisi.ma.projetmoveanddescover.user.controllers.mappers.UserControllerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public UserControllerMapper userControllerMapper(){
        return Mappers.getMapper(UserControllerMapper.class);
    }

}
