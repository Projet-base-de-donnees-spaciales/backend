package ilisi.ma.projetmoveanddescover.events.repository;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {
    @Query(value = "SELECT * from position where ST_Distance(geom, :p) < :dist", nativeQuery = true)
    List<Position> findDistance(Point p,double dist);

}
