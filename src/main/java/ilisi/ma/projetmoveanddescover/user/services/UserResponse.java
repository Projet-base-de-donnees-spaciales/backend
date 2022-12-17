package ilisi.ma.projetmoveanddescover.user.services;

import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import lombok.Data;

import java.util.List;
@Data
public class UserResponse extends BasicResponse {
    private List<User> users;
}
