package ilisi.ma.projetmoveanddescover.events.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvenementDTO {
        Long id;
        String Description;
        String name;
        String Url_image;
        Date date_creation;
        Date date_expiration;
        CategoryDTO categoryDTO;
        UserDTO userDTO;


}
