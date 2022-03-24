package com.EmlakBurada.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
public enum AdvertStatus {

    IN_REVIEW,
    ACTIVE,
    DEACTIVE

}
