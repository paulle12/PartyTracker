package com.partytracker.PartyTracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class PartyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String realm;
    // need this import this because json lists as class
    @JsonProperty("class")
    private String className;
    private String role;
    @Column(name = "party_id")
    private String partyId;

    // === Getters ===

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRealm() {
        return realm;
    }

    public String getClassName() {
        return className;
    }

    public String getRole() {
        return role;
    }

    public String getPartyId() {
        return role;
    }

    // === Setters ===

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}