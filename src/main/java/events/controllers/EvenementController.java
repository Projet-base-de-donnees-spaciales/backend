package events.controllers;

import events.repository.entities.Evenement;
import events.services.EvenementEventHandler;
import events.services.EvenementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class EvenementController extends BasicApiController {
    @Autowired
    EvenementEventHandler evenementEventHandler;
    @PostMapping({"/Evenement/Add"})
    public ResponseEntity<EvenementResponse>  AddEvenement(@RequestBody Evenement evenement)
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.creationEvent(evenement);
       return Respond(evenementResponse);

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
