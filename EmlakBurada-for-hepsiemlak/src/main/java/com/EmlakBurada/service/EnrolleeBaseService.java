package com.EmlakBurada.service;

import com.EmlakBurada.dto.request.EnrolleeRequest;
import com.EmlakBurada.dto.response.EnrolleeResponse;
import com.EmlakBurada.model.Enrollee;
import org.springframework.stereotype.Service;

@Service
public class EnrolleeBaseService {

    Enrollee convertToEnrolleeEntity(EnrolleeRequest enrolleeRequest){
        Enrollee enrollee=new Enrollee();
        enrollee.setEmail(enrolleeRequest.getEmail());
        enrollee.setEnrolleeType(enrolleeRequest.getEnrolleeType());
        enrollee.setFirstName(enrolleeRequest.getFirstName());
        enrollee.setLastName(enrolleeRequest.getLastName());
        enrollee.setPhoneNumber(enrolleeRequest.getPhoneNumber());
        enrollee.setPassword(enrolleeRequest.getPassword());
        return enrollee;
    }

    EnrolleeResponse convertToEnrolleeResponse(Enrollee enrollee){
        EnrolleeResponse enrolleeResponse=new EnrolleeResponse();
        enrolleeResponse.setEnrolleeId(enrollee.getEnrolleeId());
        enrolleeResponse.setEmail(enrollee.getEmail());
        enrolleeResponse.setFirstName(enrollee.getFirstName());
        enrolleeResponse.setLastName(enrollee.getLastName());
        enrolleeResponse.setPhoneNumber(enrollee.getPhoneNumber());
        return enrolleeResponse;
    }
}
