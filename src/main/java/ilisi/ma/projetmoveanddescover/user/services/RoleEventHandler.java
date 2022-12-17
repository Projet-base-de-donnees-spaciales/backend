package ilisi.ma.projetmoveanddescover.user.services;

import ilisi.ma.projetmoveanddescover.user.repository.RoleRepository;
import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleEventHandler {
    @Autowired RoleRepository roleRepository;

    public List<Role> getAllRoles(){

        return roleRepository.findAll();
    }

    public RoleResponse getRoleById(Long id)
    {
        RoleResponse roleResponse= new RoleResponse();
        Optional<Role> role = roleRepository.findById(id);
        //System.out.println("role "+role.getName());

        if(role.isPresent()){
            roleResponse.Success("role found");
            roleResponse.setRole(role.get());
        }else
            roleResponse.Error("role with specific Id"+id+" not found");
        return roleResponse;
    }

    public RoleResponse getRoleByName(String name)
    {
        RoleResponse roleResponse= new RoleResponse();
        Role role = roleRepository.findByName(name.toUpperCase());
        //System.out.println("role "+role.getName());

        if(role.getName().equals(name.toUpperCase())){
            roleResponse.Success("role found");
            roleResponse.setRole(role);
        }else
            roleResponse.Error("role with specific Name"+name+" not found");
        return roleResponse;
    }
}
