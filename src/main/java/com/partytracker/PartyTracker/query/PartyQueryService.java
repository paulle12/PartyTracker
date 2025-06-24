package com.partytracker.PartyTracker.query;

import com.partytracker.PartyTracker.model.PartyMember;
import com.partytracker.PartyTracker.PartyMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyQueryService {

    private static final Logger logger = LoggerFactory.getLogger(PartyQueryService.class);
    private final PartyMemberRepository repo;

    public PartyQueryService(PartyMemberRepository repo) {
        this.repo = repo;
    }

    public List<PartyMember> getLatestParty(String name, String realm) {
        logger.info("Fetching latest party for player: name={}, realm={}", name, realm);

        String latestPartyId = repo.findLatestPartyIdForPlayer(name, realm);
        logger.info("Found latest party ID: {}", latestPartyId);

        if (latestPartyId == null) {
            logger.warn("No party ID found for name={} and realm={}", name, realm);
            return List.of(); // no party found
        }

        List<PartyMember> members = repo.findByPartyId(latestPartyId);
        logger.info("Party member count: {}", members.size());
        return members;
    }
}