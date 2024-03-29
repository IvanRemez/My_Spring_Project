package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
//@Getter
//@Setter
@Data
public class AccountDetails extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;

}
