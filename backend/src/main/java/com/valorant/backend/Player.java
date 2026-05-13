package com.valorant.backend;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String puuid;

    private String gameName;
    private String tagLine;
    private LocalDateTime lastUpdated;

    public Player() {}

    public Player(String puuid, String gameName, String tagLine) {
        this.puuid = puuid;
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.lastUpdated = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getPuuid() { return puuid; }
    public String getGameName() { return gameName; }
    public String getTagLine() { return tagLine; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
