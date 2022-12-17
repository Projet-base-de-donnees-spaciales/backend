package ilisi.ma.projetmoveanddescover.user.services;

import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;
import lombok.Data;

@Data
public class RoleResponse extends BasicResponse {
    Role role;

}
