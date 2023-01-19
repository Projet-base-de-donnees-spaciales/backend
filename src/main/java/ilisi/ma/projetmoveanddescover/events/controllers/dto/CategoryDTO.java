package ilisi.ma.projetmoveanddescover.events.controllers.dto;

import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO{
        Long id;
        String name;
        String description;
        static CategoryDTO toDTo(Categorie category ){
                return new CategoryDTO(
                        category.getId(),
                        category.getName(),
                        category.getDescription()
                );
        }
}
