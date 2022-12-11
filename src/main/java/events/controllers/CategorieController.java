package events.controllers;

import events.repository.entities.Categorie;
import events.repository.entities.Evenement;
import events.services.CategorieEventHandler;
import events.services.CategorieResponse;
import events.services.EvenementEventHandler;
import events.services.EvenementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class CategorieController extends BasicApiController {
    @Autowired
    CategorieEventHandler categorieEventHandler;

    @PostMapping({"/Category/Add"})
    public ResponseEntity<CategorieResponse> AddCategory(@RequestBody Categorie categorie)
            throws Exception {

        CategorieResponse categorieResponse = categorieEventHandler.creationCategorie(categorie);
        return Respond(categorieResponse);

    }
    @PutMapping({"/Category/Update"})
    public ResponseEntity<CategorieResponse>  UpdateCategory(@RequestBody Categorie categorie)
            throws Exception {

        CategorieResponse categorieResponse = categorieEventHandler.modifierCategorie(categorie);
        return Respond(categorieResponse);

    }
    @GetMapping({"/Category/getAll"})
    public ResponseEntity<CategorieResponse>  GetCategory()
            throws Exception {

        CategorieResponse categorieResponse = categorieEventHandler.getAllCategorie();
        return Respond(categorieResponse);

    }
    @DeleteMapping ({"/Category/Delete"})
    public ResponseEntity<CategorieResponse>  DeleteCategory(@RequestBody Categorie categorie)
            throws Exception {

        CategorieResponse categorieResponse = categorieEventHandler.getAllCategorie();
        return Respond(categorieResponse);

    }
}
