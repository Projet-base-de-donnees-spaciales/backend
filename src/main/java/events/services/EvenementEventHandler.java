package events.services;

import events.repository.CategorieRepository;
import events.repository.EvenementRepository;
import events.repository.PositionRepository;
import events.repository.entities.Categorie;
import events.repository.entities.Evenement;
import events.repository.entities.Position;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class EvenementEventHandler {
    @Autowired
    EvenementRepository evenementRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    PositionRepository positionRepository;

    public EvenementResponse creationEvent(Evenement evenement){
        EvenementResponse evenementResponse = new EvenementResponse();
        Categorie categorie=categorieRepository.findById(evenement.getCategory().getId()).get();
        evenement.setCategory(categorie);
       Position position= positionRepository.save(evenement.getPosition());
       evenement.setPosition(position);
        evenementRepository.save(evenement);
        evenementResponse.Success("Evenement creer");
        return evenementResponse;

    }
    public EvenementResponse modifierEvent(Evenement evenement){
        EvenementResponse evenementResponse = new EvenementResponse();
        Evenement evenement1=evenementRepository.findById(evenement.getId()).get();
        evenement1.setName(evenement.getName());
        evenement1.setDescription(evenement.getDescription());
        evenement1.setUrl_image(evenement.getUrl_image());
        evenement1.setCategory(evenement.getCategory());
        evenement1.setDate_creation(evenement.getDate_creation());
        evenement1.setDate_expiration(evenement.getDate_expiration());
        Position position=positionRepository.findById(evenement.getPosition().getId()).get();
        position.setPoint(evenement.getPosition().getPoint());
        positionRepository.save(position);
        evenementRepository.save(evenement1);
        evenementResponse.Success("Evenement modifier");
        return evenementResponse;
    }
    public EvenementResponse deleteEvent(Evenement evenement){
        EvenementResponse evenementResponse = new EvenementResponse();
        evenementRepository.deleteById(evenement.getId());
        evenementResponse.Success("Evenement supprimer");
        return evenementResponse;
    }
    public EvenementResponse getAllEvent(){
        EvenementResponse evenementResponse = new EvenementResponse();
      evenementResponse.setEvenementList(evenementRepository.findAll());
        evenementResponse.Success("Evenement get");
        return evenementResponse;
    }

}
