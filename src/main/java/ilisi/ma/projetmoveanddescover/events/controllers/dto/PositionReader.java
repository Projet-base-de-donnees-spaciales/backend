package ilisi.ma.projetmoveanddescover.events.controllers.dto;

import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.awt.*;

public class PositionReader {
    private String point;

    /*public PositionReader(String point) {
        this.point=point;
    }
*/
    public Position toPosition() throws ParseException {
        Position pos=new Position();
        pos.setPoint((Point) new WKTReader().read(this.getPoint()));
        return pos;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
