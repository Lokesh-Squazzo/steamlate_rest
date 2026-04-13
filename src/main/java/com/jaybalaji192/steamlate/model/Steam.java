package com.jaybalaji192.steamlate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "steams")
public class Steam {
    @Id
    private String steamId;
    private String content;

    public Steam() {
    }

    public Steam(String steamId, String content) {
        this.steamId = steamId;
        this.content = content;
    }
    public String getSteamId() {
        return steamId;
    }
    public String getContent() {
        return content;
    }
}
