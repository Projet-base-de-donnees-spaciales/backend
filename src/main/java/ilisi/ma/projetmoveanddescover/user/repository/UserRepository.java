package ilisi.ma.projetmoveanddescover.user.repository;

import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
