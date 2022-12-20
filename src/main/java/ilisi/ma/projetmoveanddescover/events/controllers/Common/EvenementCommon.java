package ilisi.ma.projetmoveanddescover.events.controllers.Common;

import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.util.Date;

@Data

public class EvenementCommon {
    private String Description;
    private String name;
    private String Url_image;
    private Date date_expiration;
    private Categorie category;
    private String point;
    private Position position;
    private User user;
    public Evenement toEvenement() throws ParseException {
        Evenement evenement=new Evenement();
        evenement.setDate_creation(new Date());
        evenement.setCategory(this.getCategory());
        Position pos=new Position();
        pos.setPoint((Point) new WKTReader().read(this.getPoint()));
        evenement.setPosition(pos);
        evenement.setName(this.getName());
        evenement.setUrl_image(this.getUrl_image());
        evenement.setDate_expiration(this.getDate_expiration());
        evenement.setUser(this.getUser());
        evenement.setDescription(this.getDescription());
        return  evenement;
    }

}
