package ilisi.ma.projetmoveanddescover.events.controllers;


import ilisi.ma.projetmoveanddescover.events.controllers.dto.EvenementDTO;
import ilisi.ma.projetmoveanddescover.events.controllers.mappers.EventControllerMapper;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.services.EvenementEventHandler;
import ilisi.ma.projetmoveanddescover.events.services.EvenementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class EvenementController extends BasicApiController {
    @Autowired
    EvenementEventHandler evenementEventHandler;
    @Autowired
    EventControllerMapper eventControllerMapper;
    @PostMapping({"/Evenement/Add"})
    public void  AddEvenement(@RequestBody EvenementDTO evenement)
            throws Exception {
        System.out.println(evenement);
        System.out.println(eventControllerMapper.toEvent(evenement).getCategory().getId());
        EvenementResponse evenementResponse = null;//evenementEventHandler.creationEvent();
       //return Respond(evenementResponse);

    }
    @PutMapping({"/Evenement/Update"})
    public ResponseEntity<EvenementResponse>  UpdateEvenement(@RequestBody Evenement evenement)
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.modifierEvent(evenement);
        return Respond(evenementResponse);

    }
    @GetMapping({"/Evenement/getAll"})
    public ResponseEntity<EvenementResponse>  GetEvenement()
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.getAllEvent();
        return Respond(evenementResponse);

    }
    @DeleteMapping ({"/Evenement/Delete"})
    public ResponseEntity<EvenementResponse>  DeleteEvenement(@RequestBody Evenement evenement)
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.deleteEvent(evenement);
        return Respond(evenementResponse);

    }
}
