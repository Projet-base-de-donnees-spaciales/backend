package ilisi.ma.projetmoveanddescover.user.services;

import ilisi.ma.projetmoveanddescover.user.repository.RoleRepository;
import ilisi.ma.projetmoveanddescover.user.repository.entities.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    @Autowired
    private  RoleRepository rolesRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) return;
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("FINAL_USER");
        createRoleIfNotFound("PROVIDER_USER");
    }
    @Transactional
    Role createRoleIfNotFound(String name) {
        Role role = this.rolesRepository.findByName(name);
        if (role == null) {
            this.rolesRepository.save(new Role(null,name));
            role = this.rolesRepository.findByName(name);
        }
        return role;
    }
}
