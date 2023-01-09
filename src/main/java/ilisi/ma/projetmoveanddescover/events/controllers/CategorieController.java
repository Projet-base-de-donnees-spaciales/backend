package ilisi.ma.projetmoveanddescover.events.controllers;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.CategoryDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import ilisi.ma.projetmoveanddescover.events.services.CategorieEventHandler;
import ilisi.ma.projetmoveanddescover.events.services.CategorieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*" )
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
    @GetMapping("Category/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CategorieResponse> getCateforyById(@PathVariable String id)
        throws Exception {
        CategorieResponse categorieResponse = categorieEventHandler.getCategoryById(id);
        return Respond(categorieResponse);
    }
    }

