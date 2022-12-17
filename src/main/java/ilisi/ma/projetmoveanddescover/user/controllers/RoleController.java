package ilisi.ma.projetmoveanddescover.user.controllers;

import ilisi.ma.projetmoveanddescover.user.controllers.dto.RoleDTO;
import ilisi.ma.projetmoveanddescover.user.controllers.dto.RoleNoIdDTO;
import ilisi.ma.projetmoveanddescover.user.controllers.dto.UserDTO;
import ilisi.ma.projetmoveanddescover.user.controllers.mappers.UserControllerMapper;
import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import ilisi.ma.projetmoveanddescover.user.services.RoleEventHandler;
import ilisi.ma.projetmoveanddescover.user.services.RoleResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

import static java.rmi.server.LogStream.log;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleEventHandler roleEventHandler;
    @Autowired
    UserControllerMapper userControllerMapper;
    @GetMapping("")
    ResponseEntity<?> getUsers() throws Exception{
        ArrayList<RoleDTO> roleDTOS= new ArrayList<RoleDTO>();
        Collection<Role> roles = roleEventHandler.getAllRoles();
        for(Role role : roles)
            roleDTOS.add(userControllerMapper.toRoleDTO(role));
        return ResponseEntity.status(HttpStatus.OK).body(roleDTOS);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getRoleById(@PathVariable String id){
        log.info("Get role by id :"+id);
        RoleResponse roleResponse=roleEventHandler.getRoleById(Long.parseLong(id));
        if(roleResponse.isSuccessful())
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userControllerMapper.toRoleDTO(roleResponse.getRole()));
        log.info("No role found by id :"+id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(roleResponse.getMessage());
    }
    @GetMapping("/name/{name}")
    ResponseEntity<?> getRoleByName(@PathVariable String name){
        log.info("Get role by name :"+name);
        RoleResponse roleResponse=roleEventHandler.getRoleByName(name);
        if(roleResponse.isSuccessful())
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userControllerMapper.toRoleDTO(roleResponse.getRole()));
        log.info("No role found by id :"+id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(roleResponse.getMessage());
    }
}
