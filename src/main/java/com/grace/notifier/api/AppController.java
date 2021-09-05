package com.grace.notifier.api;

import com.grace.notifier.biz.entity.App;
import com.grace.notifier.biz.service.AppService;
import com.grace.notifier.dto.AppCreationDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app")
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("")
    public App createApp(@RequestBody AppCreationDTO dto){
        return appService.createApp(dto);
    }
}
