package com.bankstech.userservice.bootstrap;

import com.bankstech.userservice.model.*;
import com.bankstech.userservice.repository.RoleRepository;
import com.bankstech.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role user = new Role(null,"ROLE_USER");
        roleRepository.save(user);
        Role manager = new Role(null,"ROLE_MANAGER");
        roleRepository.save(manager);
        Role admin = new Role(null, "ROLE_ADMIN");
        roleRepository.save(admin);
        Role superAdmin = new Role(null,"ROLE_SUPER_ADMIN");
        roleRepository.save(superAdmin);

        //Add User
        User banks = new User();
        banks.setName("Banks Olotu");
        banks.setUsername("ceo@bankstech.com");
        banks.setPassword("2334455rrrre");
        banks.getRoles().add(superAdmin);
        userRepository.save(banks);

        User peter = new User();
        peter.setName("Peter Smith");
        peter.setUsername("peter@bankstech.com");
        peter.setPassword("23y3y4u488r9r9r0e00e0");
        peter.getRoles().add(admin);
        userRepository.save(peter);

        User john = new User();
        john.setName("John Stone");
        john.setUsername("john@bankstech.com");
        john.setPassword("wtwy334uieeeo3400404");
        john.getRoles().add(manager);
        john.getRoles().add(admin);
        userRepository.save(john);

        User mary = new User();
        mary.setName("Mary Jones");
        mary.setUsername("mary@bankstech.com");
        mary.setPassword("wuru494950rroo505005");
        mary.getRoles().add(user);
        userRepository.save(mary);
    }
}
