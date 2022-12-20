package ilisi.ma.projetmoveanddescover.Common.Mapper;



import ilisi.ma.projetmoveanddescover.events.controllers.dto.CategoryDTO;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.EvenementDTO;
import ilisi.ma.projetmoveanddescover.events.controllers.dto.PositionDTO;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Categorie;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Position;
import ilisi.ma.projetmoveanddescover.user.controllers.dto.UserDTO;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
public class AutoMapper
{
    private final ModelMapper mapper = new ModelMapper();

    public AutoMapper()
    {
        MapEventDTO();
        MapPositionDTO();
        MapCategorieDTO();
        MapUserDTO();



    }


    public <S, T> List<T> MapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> Set<T> MapSet(Set<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toSet());
    }


    public ModelMapper getMapper() {
        return mapper;
    }

    private void MapEventDTO()
    {
        mapper.typeMap(Evenement.class, EvenementDTO.class)
                .addMappings(mapper-> mapper.map(Evenement::getCategory,EvenementDTO::setCategoryDTO))
                .addMappings(mapper-> mapper.map(Evenement::getUser,EvenementDTO::setUserDTO));

    }

    private void MapPositionDTO()
    {
        mapper.typeMap(Position.class, PositionDTO.class)
                .addMappings(mapper-> mapper.map(Position::getEvenement,PositionDTO::setEvenementDTO));
    }

    private void MapCategorieDTO()
    {
        mapper.typeMap(Categorie.class, CategoryDTO.class);
    }

    private void MapUserDTO()
    {
        mapper.typeMap(User.class, UserDTO.class);
    }


}
