package ilisi.ma.projetmoveanddescover.events.controllers.mappers;

import ilisi.ma.projetmoveanddescover.events.controllers.dto.EvenementDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import org.mapstruct.Mapper;

@Mapper
public interface EventControllerMapper {
    Evenement toEvent(EvenementDTO dto);
    EvenementDTO toEventDTO(Evenement evenement);
}
