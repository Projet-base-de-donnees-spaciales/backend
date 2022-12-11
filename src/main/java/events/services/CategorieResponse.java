package events.services;

import events.repository.entities.BasicResponse;
import events.repository.entities.Categorie;
import lombok.Data;

import java.util.List;
@Data
public class CategorieResponse  extends BasicResponse {
   private List<Categorie> categorieList;
}
