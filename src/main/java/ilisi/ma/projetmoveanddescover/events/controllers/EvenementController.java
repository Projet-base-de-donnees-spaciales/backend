package ilisi.ma.projetmoveanddescover.events.controllers;


import ilisi.ma.projetmoveanddescover.events.controllers.Common.EvenementCommon;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.EvenementCommand;
import ilisi.ma.projetmoveanddescover.events.services.EvenementEventHandler;
import ilisi.ma.projetmoveanddescover.events.services.EvenementResponse;
import ilisi.ma.projetmoveanddescover.events.services.PositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class EvenementController extends BasicApiController {
    @Autowired
    EvenementEventHandler evenementEventHandler;

    @PostMapping({"/Evenement/Add"})
    public ResponseEntity<EvenementResponse>  AddEvenement(@RequestBody EvenementCommon evenement)
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.creationEvent(evenement);
       return Respond(evenementResponse);

    }
    @PutMapping({"/Evenement/Update"})
    public ResponseEntity<EvenementResponse>  UpdateEvenement(@RequestBody EvenementCommand evenement)
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.modifierEvent(evenement);
        return Respond(evenementResponse);

    }
    @GetMapping({"/Evenement/getAll"})
    public ResponseEntity<PositionResponse>  GetEvenement()
            throws Exception {

        PositionResponse evenementResponse = evenementEventHandler.getAllEvent();
        return Respond(evenementResponse);

    }
    @DeleteMapping ({"/Evenement/Delete/{id}"})
    public ResponseEntity<EvenementResponse>  DeleteEvenement(@PathVariable Long id)
            throws Exception {

        EvenementResponse evenementResponse = evenementEventHandler.deleteEvent(id);
        return Respond(evenementResponse);

    }
}
