package ilisi.ma.projetmoveanddescover.events.controllers.mappers;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.CategoryDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import org.mapstruct.Mapper;
@Mapper
public interface CategoryControllerMapper {
    Categorie toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDTO(Categorie categorie);
}
