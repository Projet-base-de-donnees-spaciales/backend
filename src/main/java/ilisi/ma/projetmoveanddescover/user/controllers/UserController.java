package ilisi.ma.projetmoveanddescover.user.controllers;

import ilisi.ma.projetmoveanddescover.events.controllers.BasicApiController;
import ilisi.ma.projetmoveanddescover.user.controllers.dto.CreatDTO;
import ilisi.ma.projetmoveanddescover.user.controllers.dto.LoginDTO;
import ilisi.ma.projetmoveanddescover.user.controllers.mappers.UserControllerMapper;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import ilisi.ma.projetmoveanddescover.user.services.UserEventHandler;
import ilisi.ma.projetmoveanddescover.user.services.UserResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController extends BasicApiController {
    @Autowired
    UserEventHandler userEventHandler;
    @Autowired
    UserControllerMapper userControllerMapper;

    @GetMapping("")
    ResponseEntity<?> getUsers() throws Exception{
        //ArrayList<UserDTO> usersdto= new ArrayList<UserDTO>();
        Collection<User> users = userEventHandler.getAllUsers();
         return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    
    @PostMapping("/Add")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createUser(@RequestBody @Valid User user){
        log.info("create new user");
        //User user =userControllerMapper.toCreatUserDTO(creatDTO);
        userEventHandler.creationUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user.getId());
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    void updateAthlete(@RequestBody CreatDTO CreatDTO, @PathVariable String id) {
        log.info("update user with id : " + id);
        User user = userControllerMapper.toCreatUserDTO(CreatDTO);
        user.setId(Long.parseLong(id));
        userEventHandler.modifierUser(user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteAthlete(@PathVariable String id) {
        log.info("delete user with id : " + id);
        this.userEventHandler.deleteUser(Long.parseLong(id));
    }

    @PostMapping("/login")
    ResponseEntity<?> liginUser(@RequestBody @Valid LoginDTO loginDTO){
        log.info("login user"+loginDTO.email()+" password : "+loginDTO.password());
        UserResponse userResponse =userEventHandler.login(loginDTO.email(),loginDTO.password());
       return Respond(userResponse);

    }
}
