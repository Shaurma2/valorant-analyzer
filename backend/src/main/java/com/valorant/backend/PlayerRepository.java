package com.valorant.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByGameNameAndTagLine(String gameName, String tagLine);
}
