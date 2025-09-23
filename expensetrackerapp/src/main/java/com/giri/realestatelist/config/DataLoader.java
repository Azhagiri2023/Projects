package com.giri.realestatelist.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.giri.realestatelist.models.Role;
import com.giri.realestatelist.models.Users;
import com.giri.realestatelist.repositories.UsersRepository;

@Component
public class DataLoader implements CommandLineRunner {
    
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

   @Override
public void run(String... args) throws Exception {
    if (userRepository.findByEmail("admin234@gmail.com").isEmpty()) {
        Users admin = new Users();
        admin.setName("adminator");
        admin.setEmail("admin234@gmail.com");
        admin.setPassword(passwordEncoder().encode("adminator")); // 👈 encode
        admin.setRole(Role.ADMIN);

        userRepository.save(admin);
        System.out.println("Admin user created!");
    } else {
        System.out.println("Admin user already exists!");
    }
}

private PasswordEncoder passwordEncoder() {
    return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
}

}
