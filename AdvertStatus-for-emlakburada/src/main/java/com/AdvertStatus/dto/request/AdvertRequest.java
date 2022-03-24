package com.AdvertStatus.dto.request;

import com.AdvertStatus.model.AdvertStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertRequest {

    AdvertStatus advertStatus;
    int advertId;

}
