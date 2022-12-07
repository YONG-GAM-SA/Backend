package com.yonggamsa.withsuyeonjung.user.adapter.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private 

}
