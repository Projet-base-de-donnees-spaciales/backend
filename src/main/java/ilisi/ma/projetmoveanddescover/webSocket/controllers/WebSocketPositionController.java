package ilisi.ma.projetmoveanddescover.webSocket.controllers;

import ilisi.ma.projetmoveanddescover.events.controllers.dto.PositionDTO;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.PositionReader;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import ilisi.ma.projetmoveanddescover.events.services.EvenementEventHandler;
import ilisi.ma.projetmoveanddescover.webSocket.repositories.EventDistance;
import ilisi.ma.projetmoveanddescover.webSocket.services.WebSocketPositionService;
//import lombok.var;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebSocketPositionController {
    @Autowired
    SimpMessagingTemplate template;
    @Autowired
    EvenementEventHandler evenementEventHandler;

    WebSocketPositionService webSocketPositionService= new WebSocketPositionService();
    @PostMapping("/positions")
    double getDistance(@RequestBody PositionReader position) throws ParseException {
        GeometryFactory fact = new GeometryFactory();
        Point p1 = fact.createPoint(new Coordinate(10,12));
        System.out.println("point 1 vaut"+p1.toString());
        Position basePos = new Position();
        basePos.setPoint(p1);
        Position pos = position.toPosition();
       //= new WebSocketPositionService();
        return webSocketPositionService.distancePosition(basePos,pos);

    }

    @PostMapping("/send")
    public List<EventDistance> receivePositionS(@RequestBody PositionReader positionReader) throws ParseException {
        System.out.println(positionReader +" est la position reçue du front");
        Position pos = positionReader.toPosition();
        List<EventDistance> distances = new ArrayList<EventDistance>();
        var x=evenementEventHandler.getAllEvent();
        System.out.println(x.getMessage());
        var events = x.getPositionDTOSList();
        System.out.println(events.size());
        if(events==null )
            return distances;
        events.forEach((p)->{
            PositionReader positionReader1=new PositionReader();
            positionReader1.setPoint(p.getPoint());
            try {
                if(p.getEvenementDTO()!=null)
                    distances.add(new EventDistance(p.getEvenementDTO().getName(),webSocketPositionService.distancePosition(positionReader1.toPosition(),pos)));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        //template.convertAndSend("/topic/message",distances);/**/
        return distances;

    }
    @MessageMapping("/sendMessage")
    public void receivePosition(@Payload PositionReader positionReader) throws ParseException {
        System.out.println(positionReader +" est la position reçue du front");
        Position pos = positionReader.toPosition();
        List<EventDistance> distances = new ArrayList<EventDistance>();
        var events = evenementEventHandler.getAllEvent().getPositionDTOSList();
       events.forEach((p)->{
           PositionReader positionReader1=new PositionReader();
           positionReader1.setPoint(p.getPoint());
           try {
               if(p.getEvenementDTO()!=null)
                    distances.add(new EventDistance(p.getEvenementDTO().getName(),webSocketPositionService.distancePosition(positionReader1.toPosition(),pos)));
           } catch (ParseException e) {
               throw new RuntimeException(e);
           }
       });
       template.convertAndSend("/topic/message",distances);

    }
    @SendTo("/topic/message")
    List<EventDistance> broadcastMessage(@Payload List<EventDistance> distances)
    {
        return distances;
    }
}
