        package com.valorant.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;

@Service
public class RiotService {

    @Value("${riot.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PlayerRepository playerRepository;

    public RiotService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerByRiotId(String name, String tag) throws Exception {
        // Проверяем есть ли игрок уже в БД
        var existing = playerRepository.findByGameNameAndTagLine(name, tag);
        if (existing.isPresent()) {
            return existing.get();
        }

        // Запрашиваем у Riot API
        String url = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"
                + name + "/" + tag;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class
        );

        JsonNode json = objectMapper.readTree(response.getBody());
        String puuid = json.get("puuid").asText();
        String gameName = json.get("gameName").asText();
        String tagLine = json.get("tagLine").asText();

        // Сохраняем в БД
        Player player = new Player(puuid, gameName, tagLine);
        return playerRepository.save(player);
    }
}
