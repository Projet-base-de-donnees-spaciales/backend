package ilisi.ma.projetmoveanddescover.events.controllers.dto;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
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
        User userDTO;

        static EvenementDTO toEvenDTO(Evenement evenement)
        {
                return  new EvenementDTO(
                        evenement.getId(),
                        evenement.getDescription(),
                        evenement.getName(),
                        evenement.getUrl_image(),
                        evenement.getDate_creation(),
                        evenement.getDate_expiration(),
                        CategoryDTO.toDTo(evenement.getCategory()),
                        evenement.getUser()
                );
        }

}
