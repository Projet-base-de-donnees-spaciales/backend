package ilisi.ma.projetmoveanddescover.events.repository;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {
    void deleteByEvenement(Evenement evenement);
    List<Position> findByEvenement_User(User user);
}
