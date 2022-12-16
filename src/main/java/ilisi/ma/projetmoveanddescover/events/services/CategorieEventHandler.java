package ilisi.ma.projetmoveanddescover.events.services;

import ilisi.ma.projetmoveanddescover.events.repository.CategorieRepository;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategorieEventHandler {
    @Autowired
    CategorieRepository categorieRepository;

    public CategorieResponse creationCategorie(Categorie categorie){
        CategorieResponse categorieResponse=new CategorieResponse();
        categorieRepository.save(categorie);
        categorieResponse.Success("Categorie creer");
        return categorieResponse;

    }
    public CategorieResponse modifierCategorie(Categorie categorie){
        CategorieResponse categorieResponse=new CategorieResponse();
        Categorie evenement1=categorieRepository.findById(categorie.getId()).get();
        evenement1.setName(categorie.getName());
        evenement1.setDescription(categorie.getDescription());
        categorieRepository.save(evenement1);
        categorieResponse.Success("Categorie modifier");
        return categorieResponse;
    }
    public CategorieResponse deleteCategorie(Categorie categorie){
        CategorieResponse categorieResponse=new CategorieResponse();
        categorieRepository.deleteById(categorie.getId());
        categorieResponse.Success("Categorie modifier");
        return categorieResponse;
    }
    public CategorieResponse getAllCategorie(){
        CategorieResponse categorieResponse = new CategorieResponse();
        categorieResponse.setCategorieList(categorieRepository.findAll());
        categorieResponse.Success("Evenement get");
        return categorieResponse;
    }
    public CategorieResponse getCategoryById(String id)
    {
       CategorieResponse categorieResponse = new  CategorieResponse();
        List<Categorie> categories= new ArrayList<Categorie>();
        Categorie categorie=categorieRepository.getById(Long.parseLong(id));
        System.out.println("Category"+ categorie.getDescription());
        categories.add(categorie);
       categorieResponse.setCategorieList(categories);
        System.out.println("success");
       categorieResponse.Success("Get Categorie by id = "+id);
       return categorieResponse;
    }

}
