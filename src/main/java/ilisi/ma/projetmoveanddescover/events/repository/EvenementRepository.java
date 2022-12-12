package ilisi.ma.projetmoveanddescover.events.repository;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
