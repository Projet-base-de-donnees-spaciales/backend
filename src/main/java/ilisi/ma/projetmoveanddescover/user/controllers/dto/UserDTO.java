package ilisi.ma.projetmoveanddescover.user.controllers.dto;

import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;

public record UserDTO(
        int id,
        String username,
        String email,
        String password,
        Role role

) {
}
