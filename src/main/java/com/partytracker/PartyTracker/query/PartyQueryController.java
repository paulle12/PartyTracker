package com.partytracker.PartyTracker.query;

import com.partytracker.PartyTracker.model.PartyMember;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/party")
public class PartyQueryController {

    private final PartyQueryService queryService;

    public PartyQueryController(PartyQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/latest")
    public List<PartyMember> getLatestParty(
            @RequestParam String realm,
            @RequestParam String name) {
        return queryService.getLatestParty(name, realm);
    }
}