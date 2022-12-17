package ilisi.ma.projetmoveanddescover.user.repository;

import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name = :name")
    Role findByName(@Param("name") String name);
}
