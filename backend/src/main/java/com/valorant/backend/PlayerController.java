package com.valorant.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    @GetMapping("/{name}/{tag}")
    public String getPlayer(@PathVariable String name, @PathVariable String tag) {
        return "Player: " + name + "#" + tag + " — данные скоро будут здесь!";
    }

    @GetMapping("/health")
    public String health() {
        return "Backend работает!";
    }
}
