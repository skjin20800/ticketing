package com.jkb.ticketing.restController;

import com.jkb.ticketing.service.TicketingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TicketingController {

    private final TicketingService ticketingService;

    @GetMapping("/")
    public String home() {
        ticketingService.SeleniumTest();
        return "logService.FindAll()";
    }


}
