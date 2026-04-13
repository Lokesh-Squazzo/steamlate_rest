package com.jaybalaji192.steamlate.controller;

import com.jaybalaji192.steamlate.request.UserRequest;
import com.jaybalaji192.steamlate.model.Steam;
import com.jaybalaji192.steamlate.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SteamController {
    @Autowired
    private SteamService steamService;

    @PostMapping("/steam")
    public Steam saveSteam(@RequestBody UserRequest request) {
        return steamService.saveSteam(request);
    }

    @GetMapping("/steam/{steamId}")
    public Steam getSteamContent(@PathVariable String steamId){
        return steamService.getSteam(steamId);
    }

}
