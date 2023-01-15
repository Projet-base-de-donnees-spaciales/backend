package ilisi.ma.projetmoveanddescover.events.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EvenementCommand {
   private String description;
    private Categorie category;
    private String point;
    private String date_expiration;
    private String name;
    private int id;
    private int idPoint;

}
