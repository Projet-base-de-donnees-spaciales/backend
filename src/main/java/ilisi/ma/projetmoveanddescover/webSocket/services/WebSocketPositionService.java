package ilisi.ma.projetmoveanddescover.webSocket.services;

import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import org.locationtech.jts.operation.distance.DistanceOp;

public class WebSocketPositionService {
    public double distancePosition(Position pos1,Position pos2){
        DistanceOp distanceOp=new DistanceOp(pos1.getPoint(),pos2.getPoint());
        System.out.println("la distance entre "+pos1.getPoint().toString() +" and "+pos2.getPoint()+" is :"+distanceOp.distance());
        return distanceOp.distance();
    }
}
