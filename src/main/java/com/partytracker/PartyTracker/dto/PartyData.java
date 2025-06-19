package com.partytracker.PartyTracker.dto;

import java.util.List;

import com.partytracker.PartyTracker.model.PartyMember;

public class PartyData {
    private List<PartyMember> party;

    public List<PartyMember> getParty() {
        return party;
    }

    public void setParty(List<PartyMember> party) {
        this.party = party;
    }
}