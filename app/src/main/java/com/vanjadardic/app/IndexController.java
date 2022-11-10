package com.vanjadardic.app;

import java.security.Principal;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    String index(Model model, Principal principal) {
        model.addAttribute("rnd", new Random().nextInt(100));
        model.addAttribute("user", Optional.ofNullable(principal).map(Principal::getName).orElse("guest"));
        return "index";
    }
}
