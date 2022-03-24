package com.EmlakBurada.controller;

import com.EmlakBurada.dto.request.EnrolleeRequest;
import com.EmlakBurada.dto.response.EnrolleeResponse;
import com.EmlakBurada.service.EnrolleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnrolleesController {

    @Autowired
    EnrolleeService enrolleeService;

    @PostMapping("/enrollees")
    public ResponseEntity<EnrolleeResponse> createEnrollee(@RequestBody EnrolleeRequest enrolleeRequest) throws Exception{
        enrolleeService.saveEnrollee(enrolleeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/enrollees")
    public ResponseEntity<EnrolleeResponse> editEnrollee(@RequestBody EnrolleeRequest enrolleeRequest,@RequestHeader(value = "enrolleeId")int enrolleeId){
        enrolleeService.editEnrollee(enrolleeRequest,enrolleeId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/enrollees/{enrolleeId}")
    public ResponseEntity<EnrolleeResponse> deleteEnrollee(@RequestHeader(value = "enrolleeId")int enrolleeId){
        enrolleeService.deleteEnrollee(enrolleeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
