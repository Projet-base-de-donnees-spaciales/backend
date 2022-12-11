package events.services;

import events.repository.entities.BasicResponse;
import events.repository.entities.Evenement;
import lombok.Data;

import java.util.List;
@Data
public class EvenementResponse extends BasicResponse {
    private List<Evenement> evenementList;
}
