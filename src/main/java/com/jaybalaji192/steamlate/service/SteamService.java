package com.jaybalaji192.steamlate.service;

import com.jaybalaji192.steamlate.request.UserRequest;
import com.jaybalaji192.steamlate.model.Steam;
import com.jaybalaji192.steamlate.repository.SteamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SteamService {

    @Autowired
    private SteamRepository steamRepository;

    public Steam saveSteam(UserRequest request) {
        String thisId = request.customId();
        if (request.customId().isEmpty())
            thisId = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        Steam steam = new Steam(
                thisId,
                request.content()
        );
        return steamRepository.save(steam);
    }

    public Steam getSteam(String steamId){
        return steamRepository.findBySteamId(steamId);
    }
}
