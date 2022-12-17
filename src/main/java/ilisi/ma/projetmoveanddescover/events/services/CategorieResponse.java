package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.events.controllers.dto.CategoryDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import lombok.Data;


import java.util.List;
@Data
public class CategorieResponse  extends BasicResponse {
   private List<CategoryDTO> categorieList;
}
