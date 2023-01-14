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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data

public class EvenementCommon {
    private String Description;
    private String name;
    private String Url_image;
    private String date_expiration;
    private Categorie category;
    private String point;
    private Position position;
    private User user;
    public Evenement toEvenement() throws ParseException, java.text.ParseException {
        Evenement evenement=new Evenement();
        evenement.setDate_creation(new Date());
        evenement.setCategory(this.getCategory());
        Position pos=new Position();
        //serialisation
        pos.setPoint((Point) new WKTReader().read(this.getPoint()));
        evenement.setPosition(pos);
        evenement.setName(this.getName());
        evenement.setUrl_image(this.getUrl_image());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(this.getDate_expiration());
        evenement.setDate_expiration(date);
        User u=new User();
        u.setId(this.getUser().getId());
        evenement.setUser(u);
        evenement.setDescription(this.getDescription());
        return  evenement;
    }

}
