package com.EmlakBurada.controller;

import com.EmlakBurada.dto.request.AdvertRequest;
import com.EmlakBurada.dto.response.AdvertResponse;
import com.EmlakBurada.model.Advert;
import com.EmlakBurada.service.AdvertService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AdvertsController {

    @Autowired
    AdvertService advertService;

    @GetMapping("/adverts")
    public ResponseEntity<List<AdvertResponse>>getAllAdverts(){
        advertService.getAll();
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/adverts")
    public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest advertRequest,@RequestHeader(value = "enrolleeId") int enrolleeId) throws Exception{
        advertService.saveAdvert(advertRequest,enrolleeId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/adverts/{advertId}")
    public ResponseEntity<AdvertResponse> deleteAdvert(@PathVariable int advertId,@RequestHeader(value="enrolleeId")int enrolleeId){
        advertService.deleteAdvert(advertId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/adverts")
    public ResponseEntity<AdvertResponse> editAdvert(@RequestBody AdvertRequest advertRequest,@RequestHeader(value = "enrolleeId")int enrolleeId)throws Exception{
        advertService.editAdvert(advertRequest,enrolleeId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateAdvertStatusPassive")
    public void updateAdvertStatusPassive(@RequestBody Advert advert,@RequestHeader(value = "enrolleeId")int enrolleeId){
        advertService.updateAdvertStatusPassive(advert);

    }

    @PutMapping("/updateAdvertStatusActive")
    public void updateAdvertStatusActive(@RequestBody Advert advert,@RequestHeader(value = "enrolleeId")int enrolleeId){
        advertService.updateAdvertStatusActive(advert);

    }

    @GetMapping("/activeAdverts")
    public ResponseEntity<List<AdvertResponse>> getActiveAdverts(@RequestHeader(value = "enrolleeId") int enrolleeId){
        advertService.getActiveAdverts(enrolleeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/passiveAdverts")
    public ResponseEntity<List<AdvertResponse>> getPassiveAdverts(@RequestHeader(value = "enrolleeId") int enrolleeId){
        advertService.getPassiveAdverts(enrolleeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
