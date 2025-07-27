package team.flow.fileadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/extensions")
    public String showExtensionsPage() {
        return "extensions";
    }
}
