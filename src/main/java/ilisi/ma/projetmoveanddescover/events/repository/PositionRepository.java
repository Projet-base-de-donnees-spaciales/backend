package ilisi.ma.projetmoveanddescover.events.repository;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;

import ilisi.ma.projetmoveanddescover.user.repository.entities.User;

import org.locationtech.jts.geom.Point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {

    void deleteByEvenement(Evenement evenement);

    @Query(value = "SELECT * from position where ST_Distance(geom, :p) < :dist", nativeQuery = true)
    List<Position> findDistance(Point p,double dist);


}
