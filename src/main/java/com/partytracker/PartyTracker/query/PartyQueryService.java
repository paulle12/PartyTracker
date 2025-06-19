package com.partytracker.PartyTracker.query;

import com.partytracker.PartyTracker.model.PartyMember;
import com.partytracker.PartyTracker.PartyMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyQueryService {

    private final PartyMemberRepository repo;

    public PartyQueryService(PartyMemberRepository repo) {
        this.repo = repo;
    }

    public List<PartyMember> getLatestParty(String name, String realm) {
        String latestPartyId = repo.findLatestPartyIdForPlayer(name, realm);
        if (latestPartyId == null) {
            return List.of(); // no party found
        }
        return repo.findByPartyId(latestPartyId);
    }
}