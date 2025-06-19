package com.partytracker.PartyTracker.upload;

import com.partytracker.PartyTracker.dto.PartyData;
import com.partytracker.PartyTracker.model.PartyMember;
import com.partytracker.PartyTracker.PartyMemberRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PartyUploadService {

    private final PartyMemberRepository repo;

    public PartyUploadService(PartyMemberRepository repo) {
        this.repo = repo;
    }

    public void saveParty(PartyData data) {
        String partyId = UUID.randomUUID().toString();

        for (PartyMember member : data.getParty()) {
            member.setPartyId(partyId);
        }

        repo.saveAll(data.getParty());
    }
}