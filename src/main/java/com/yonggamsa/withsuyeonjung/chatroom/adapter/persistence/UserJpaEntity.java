package com.yonggamsa.withsuyeonjung.chatroom.adapter.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private 

}
