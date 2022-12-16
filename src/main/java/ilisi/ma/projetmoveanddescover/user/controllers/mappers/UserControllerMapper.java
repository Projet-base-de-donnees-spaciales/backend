package ilisi.ma.projetmoveanddescover.user.controllers.mappers;

import ilisi.ma.projetmoveanddescover.user.controllers.dto.CreatDTO;
import ilisi.ma.projetmoveanddescover.user.controllers.dto.UserDTO;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserControllerMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);

    CreatDTO fromUsertoCreatUserDTO(User user);
    User toCreatUserDTO(CreatDTO creatDTO);

}
