package com.valorant.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final RiotService riotService;

    public PlayerController(RiotService riotService) {
        this.riotService = riotService;
    }

    @GetMapping("/{name}/{tag}")
    public String getPlayer(@PathVariable String name, @PathVariable String tag) {
        return riotService.getPlayerByRiotId(name, tag);
    }

    @GetMapping("/health")
    public String health() {
        return "Backend работает!";
    }
}
