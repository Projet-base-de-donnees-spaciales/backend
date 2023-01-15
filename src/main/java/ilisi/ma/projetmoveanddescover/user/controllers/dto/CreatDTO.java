package ilisi.ma.projetmoveanddescover.user.controllers.dto;

import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;

public record CreatDTO (String username,
                        String email,
                        String password,
                        Role role){
}
