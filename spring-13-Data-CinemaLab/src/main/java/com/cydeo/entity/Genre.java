package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
//@Getter
//@Setter
@Data
public class Genre extends BaseEntity {

    private String name;

}
