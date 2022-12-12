package ilisi.ma.projetmoveanddescover.events.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;


@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Point point;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}
