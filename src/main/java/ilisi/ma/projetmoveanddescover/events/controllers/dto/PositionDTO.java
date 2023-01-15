package ilisi.ma.projetmoveanddescover.events.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO {
    private Long id;
    private double pointX;
    private double pointY;
    private Point point;
    private EvenementDTO evenementDTO;

    public Long getId() {
        return id;
    }

    public String getPoint() {
        return point.toString();
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPointX() {
        return point.getX();
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return point.getY();
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public EvenementDTO getEvenementDTO() {
        return evenementDTO;
    }

    public void setEvenementDTO(EvenementDTO evenementDTO) {
        this.evenementDTO = evenementDTO;
    }
}
