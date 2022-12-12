package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import lombok.Data;


import java.util.List;
@Data
public class EvenementResponse extends BasicResponse {
    private List<Evenement> evenementList;
}
