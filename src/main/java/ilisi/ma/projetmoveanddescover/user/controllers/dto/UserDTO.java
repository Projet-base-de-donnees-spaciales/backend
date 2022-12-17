package ilisi.ma.projetmoveanddescover.user.controllers.dto;

public record UserDTO(
        int id,
        String username,
        String email,
        String password,
        int role

) {
}
