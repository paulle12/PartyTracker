package com.partytracker.PartyTracker.upload;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.partytracker.PartyTracker.dto.PartyData;

@RestController
@RequestMapping("/api/party")
public class PartyUploadController {

    private final PartyUploadService uploadService;

    public PartyUploadController(PartyUploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadParty(@RequestBody PartyData data) {
        uploadService.saveParty(data);
        return ResponseEntity.ok("Party saved");
    }
}