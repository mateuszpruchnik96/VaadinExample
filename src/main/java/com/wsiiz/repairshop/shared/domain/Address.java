package com.wsiiz.repairshop.shared.domain;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

  String locality;
  String street;
  String apartmentNo;
  String postalCode;
}
