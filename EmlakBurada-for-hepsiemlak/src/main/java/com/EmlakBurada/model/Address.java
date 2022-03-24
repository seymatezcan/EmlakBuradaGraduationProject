package com.EmlakBurada.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {

    @Id
    int addressId;
    String city;
    String county;
    String neighboorhood;
    String detailedAddress;


}
