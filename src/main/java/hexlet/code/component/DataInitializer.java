package hexlet.code.component;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.mapper.UserMapper;
import hexlet.code.model.User;
import hexlet.code.repository.UserRepository;
import hexlet.code.service.CustomUserDetailsService;
import hexlet.code.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByEmail("hexlet@example.com").isEmpty()) {
            String firstName = "Daniel";
            String lastName = "Nüüd";
            String email = "hexlet@example.com";
            String password = "qwerty";

            UserCreateDTO userData = new UserCreateDTO();
            userData.setFirstName(firstName);
            userData.setLastName(lastName);
            userData.setEmail(email);
            userData.setPassword(password);

            userService.create(userData);
        }
    }
}
