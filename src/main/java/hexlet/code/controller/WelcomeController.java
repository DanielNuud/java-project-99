package hexlet.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    @GetMapping(path = "")
    String welcome() {
        return "Welcome to Spring!";
    }
}

