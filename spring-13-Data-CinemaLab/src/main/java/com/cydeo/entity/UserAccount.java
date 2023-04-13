package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserAccount extends BaseEntity {

    private String email;
    private String username;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    private AccountDetails accountDetails;

}
