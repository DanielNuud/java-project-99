package hexlet.code.component;

import hexlet.code.dto.TaskStatusCreateDTO;
import hexlet.code.model.User;
import hexlet.code.repository.TaskStatusRepository;
import hexlet.code.service.CustomUserDetailsService;
import hexlet.code.service.TaskStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private final CustomUserDetailsService userService;

    @Autowired
    private final TaskStatusRepository statusRepository;

    @Autowired
    private final TaskStatusService statusService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var email = "hexlet@example.com";
        var userData = new User();
        userData.setEmail(email);
        userData.setPasswordDigest("qwerty");
        userService.createUser(userData);

        Map<String, String> statuses = new HashMap<>(
                Map.of("draft", "Draft", "to_review", "To review",
                        "to_be_fixed", "Must be fixed",
                        "to_publish", "Ready to publish", "published", "Published")
        );

        TaskStatusCreateDTO statusData = new TaskStatusCreateDTO();
        for (Map.Entry<String, String> status : statuses.entrySet()) {
            if (statusRepository.findBySlug(status.getKey()).isEmpty()) {
                statusData.setSlug(status.getKey());
                statusData.setName(status.getValue());
                statusService.create(statusData);
            }
        }

    }
}
