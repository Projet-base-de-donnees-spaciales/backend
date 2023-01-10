package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.Common.Mapper.AutoMapper;
import ilisi.ma.projetmoveanddescover.events.controllers.Common.EvenementCommon;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.PositionDTO;
import ilisi.ma.projetmoveanddescover.events.repository.CategorieRepository;
import ilisi.ma.projetmoveanddescover.events.repository.EvenementRepository;
import ilisi.ma.projetmoveanddescover.events.repository.PositionRepository;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import jakarta.transaction.Transactional;

import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;


@Service
@Transactional
public class EvenementEventHandler {
    @Autowired
    EvenementRepository evenementRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    AutoMapper _Mapper;

    public EvenementResponse creationEvent(EvenementCommon evenementCommon) throws ParseException, java.text.ParseException {
        Evenement evenement=evenementCommon.toEvenement();
        EvenementResponse evenementResponse = new EvenementResponse();
        Categorie categorie=evenement.getCategory()!=null?categorieRepository.findByName(evenement.getCategory().getName()):null;
        evenement.setCategory(categorie);
        Position position= positionRepository.save(evenement.getPosition());
       // evenement.setPosition(position);
        Evenement eventTmp=evenementRepository.save(evenement);
        position.setEvenement(eventTmp);
        positionRepository.save(position);
        eventTmp.setPosition(null);
        evenementResponse.Success("Evenement creer");
        return evenementResponse;

    }
    public EvenementResponse modifierEvent(Evenement evenement){
        EvenementResponse evenementResponse = new EvenementResponse();
        Evenement evenement1=evenementRepository.findById(evenement.getId()).get();
        evenement1.setName(evenement.getName());
        evenement1.setDescription(evenement.getDescription());
        Categorie categorie=evenement.getCategory()!=null?categorieRepository.findByName(evenement.getCategory().getName()):null;
        evenement1.setCategory(categorie);
        evenement1.setDate_expiration(evenement.getDate_expiration());
        Position position=positionRepository.findById(evenement.getPosition().getId()).get();
        position.setPoint(evenement.getPosition().getPoint());
        positionRepository.save(position);
        evenementRepository.save(evenement1);
        evenementResponse.Success("Evenement modifier");
        return evenementResponse;
    }
    public EvenementResponse deleteEvent( Long id){
        EvenementResponse evenementResponse = new EvenementResponse();
        Evenement evenement=evenementRepository.findById(id).get();
        positionRepository.deleteByEvenement(evenement);
        evenementRepository.deleteById(id);
        evenementResponse.Success("Evenement supprimer");
        return evenementResponse;
    }
    public PositionResponse getAllEvent(){
        PositionResponse evenementResponse = new PositionResponse();
        evenementResponse.setPositionDTOSList(_Mapper.MapList(positionRepository.findAll(), PositionDTO.class));
        evenementResponse.Success("Evenement get");
        return evenementResponse;
    }

}
