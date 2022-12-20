package ilisi.ma.projetmoveanddescover.events.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    int id;
    String username;
    String email;
    String password;
    int role;
}
