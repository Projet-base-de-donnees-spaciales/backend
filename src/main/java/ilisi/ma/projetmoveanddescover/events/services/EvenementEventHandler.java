package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.Common.Mapper.AutoMapper;
import ilisi.ma.projetmoveanddescover.events.controllers.Common.EvenementCommon;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.PositionDTO;
import ilisi.ma.projetmoveanddescover.events.repository.CategorieRepository;
import ilisi.ma.projetmoveanddescover.events.repository.EvenementRepository;
import ilisi.ma.projetmoveanddescover.events.repository.PositionRepository;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.EvenementCommand;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import ilisi.ma.projetmoveanddescover.user.repository.UserRepository;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import jakarta.transaction.Transactional;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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
    UserRepository userRepository;

    @Autowired
    AutoMapper _Mapper;

    public EvenementResponse creationEvent(EvenementCommon evenementCommon) throws ParseException, java.text.ParseException {
        Evenement evenement=evenementCommon.toEvenement();
        EvenementResponse evenementResponse = new EvenementResponse();
        Categorie categorie=evenement.getCategory()!=null?categorieRepository.findByName(evenement.getCategory().getName()):null;
        evenement.setCategory(categorie);
        Position position= positionRepository.save(evenement.getPosition());
        evenement.setPosition(position);
        Evenement eventTmp=evenementRepository.save(evenement);
        position.setEvenement(eventTmp);
        positionRepository.save(position);
        eventTmp.setPosition(position);
        evenementResponse.Success("Evenement creer");
        return evenementResponse;

    }
    public EvenementResponse modifierEvent(EvenementCommand evenement) throws java.text.ParseException, ParseException {
        EvenementResponse evenementResponse = new EvenementResponse();
        Evenement evenement1=evenementRepository.findById((long) evenement.getId()).get();
        evenement1.setName(evenement.getName());
        evenement1.setDescription(evenement.getDescription());
        Categorie categorie=evenement.getCategory()!=null?categorieRepository.findByName(evenement.getCategory().getName()):null;
        evenement1.setCategory(categorie);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(evenement.getDate_expiration());
        evenement1.setDate_expiration(date);
        Position position=positionRepository.findById((long) evenement.getIdPoint()).get();
        position.setPoint((Point) new WKTReader().read(evenement.getPoint()));
        evenement1.setPosition(position);
        positionRepository.save(position);
        evenementRepository.save(evenement1);
        evenementResponse.Success("Evenement modifier");
        return evenementResponse;
    }
    public EvenementResponse deleteEvent( Long id){
        EvenementResponse evenementResponse = new EvenementResponse();
        Evenement evenement=evenementRepository.findById(id).get();
        evenement.setPosition(null);
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

    public PositionResponse getAllEventUser(Long id) {
       PositionResponse positionResponse=new PositionResponse();
       User user=userRepository.findById(id).get();
       positionResponse.setPositionDTOSList(_Mapper.MapList(positionRepository.findByEvenement_User(user), PositionDTO.class));
       positionResponse.Success("les evenemet du user ");
       return  positionResponse;
    }
}
