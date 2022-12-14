package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.events.controllers.dto.EvenementDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import lombok.Data;


import java.util.List;
@Data
public class EvenementResponse extends BasicResponse {
    private List<EvenementDTO> evenementList;
}
