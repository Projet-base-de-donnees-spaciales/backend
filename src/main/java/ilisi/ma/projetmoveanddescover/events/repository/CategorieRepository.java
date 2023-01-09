package ilisi.ma.projetmoveanddescover.events.repository;


import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
   Categorie findByName(String name);
}
