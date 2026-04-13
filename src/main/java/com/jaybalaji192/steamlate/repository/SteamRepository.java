package com.jaybalaji192.steamlate.repository;

import com.jaybalaji192.steamlate.model.Steam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamRepository extends JpaRepository<Steam, String> {
    Steam findBySteamId(String steamId);
}
