package com.AdvertStatus.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@DynamicUpdate
public class Address {

   @Id
    int addressId;
    String city;
    String county;
    String neighboorhood;
    String detailedAddress;


}
