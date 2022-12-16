package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.events.controllers.dto.PositionDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import lombok.Data;

import java.util.List;
@Data
public class PositionResponse extends BasicResponse {
    private List<PositionDTO> positionDTOSList;
}
