package ilisi.ma.projetmoveanddescover.events.repository;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
