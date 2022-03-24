package com.EmlakBurada.dto.request;

import com.EmlakBurada.model.enums.EnrolleeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrolleeRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private EnrolleeType enrolleeType;

}
