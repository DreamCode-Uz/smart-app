package uz.smartcode.smartapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.smartcode.smartapp.dao.RoleRepository;
import uz.smartcode.smartapp.entity.Role;
import uz.smartcode.smartapp.entity.enums.RoleName;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SmartAppApplication implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public SmartAppApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.saveAll(Arrays.asList(
                new Role(null, RoleName.ROLE_SUPER_ADMIN),
                new Role(null, RoleName.ROLE_ADMIN),
                new Role(null, RoleName.ROLE_USER)
        ));
    }
}
