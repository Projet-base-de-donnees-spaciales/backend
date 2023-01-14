package ilisi.ma.projetmoveanddescover.user.services;

import ilisi.ma.projetmoveanddescover.user.controllers.dto.UserDTO;
import ilisi.ma.projetmoveanddescover.user.repository.UserRepository;
import ilisi.ma.projetmoveanddescover.user.repository.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserEventHandler {
    @Autowired
    UserRepository userRepository;
    public UserResponse creationUser(User user){
        //UserResponse userResponse = new UserResponse();
        userRepository.save(user);
        UserResponse userResponse= new UserResponse();
        userResponse.Success("User created successfully");
        return userResponse;
    }
    public UserResponse modifierUser(User user){
        User user1 = userRepository.findById(user.getId()).get();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setRole(user.getRole());
        userRepository.save(user1);
        UserResponse userResponse= new UserResponse();
        userResponse.Success("User changed successfully");
        return userResponse;
    }

    public UserResponse deleteUser(long id){
        userRepository.deleteById(id);
        UserResponse userResponse= new UserResponse();
        userResponse.Success("User deleted successfully");
        return userResponse;
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public UserResponse login(String email, String password) {
        User user=userRepository.findByEmail(email);
        UserResponse userResponse= new UserResponse();
        if(user != null){
            //System.out.println(user.getPassword());
            if(user.getPassword().equals(password)) {
                UserDTO userDTO=new UserDTO(Math.toIntExact(user.getId()),user.getUsername(),user.getEmail(),user.getPassword(),user.getRole());
                userResponse.setUser(userDTO);
                userResponse.Success("User found with right password");

            }else {
                userResponse.Error("Password is wrong");
            }

        }
        else userResponse.Error("User not found");
        return userResponse;
    }
}


