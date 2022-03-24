package com.EmlakBurada.controller;

import com.EmlakBurada.dto.response.AdvertPocketResponse;
import com.EmlakBurada.dto.request.AdvertPocketRequest;
import com.EmlakBurada.service.AdvertPocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdvertPocketsController {

    @Autowired
    AdvertPocketService advertPocketService;

    @PostMapping("/advertPockets")
    public ResponseEntity<AdvertPocketResponse> buyAdvertPocket(@RequestBody AdvertPocketRequest advertPocketRequest,@RequestHeader(value = "enrolleeId")int enrolleeId) throws InterruptedException {
        advertPocketService.saveAdvertPocket(advertPocketRequest,enrolleeId);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/advertPockets/{enrolleeId}")
    public ResponseEntity<Boolean> isEnrolleeHasAdvertPocket(@RequestHeader(value = "enrolleeId") int enrolleeId){
        advertPocketService.isEnrolleeHasAdvertPocket(enrolleeId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/advertPockets")
    public ResponseEntity<AdvertPocketResponse> getAll(@RequestHeader(value = "enrolleeId")int enrolleeId){
        advertPocketService.getTenancyOfAdverts(enrolleeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
