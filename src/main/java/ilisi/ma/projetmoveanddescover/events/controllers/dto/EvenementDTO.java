package ilisi.ma.projetmoveanddescover.events.controllers.dto;

import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import jakarta.persistence.*;

import java.util.Date;

public record EvenementDTO(
        Long id,
        String Description,
        String name,
        String Url_image,
        Date date_creation,
        Date date_expiration,
        Integer categoryId,
        Integer positionId
) {
}
