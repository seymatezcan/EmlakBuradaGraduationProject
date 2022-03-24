package com.EmlakBurada.dto.response;

import com.EmlakBurada.model.Advert;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EnrolleeResponse {

    private int enrolleeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    Set<Advert> favoriteAdverts;
}
