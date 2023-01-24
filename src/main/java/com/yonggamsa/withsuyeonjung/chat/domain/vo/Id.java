package com.yonggamsa.withsuyeonjung.chat.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Id {
    private final UUID uuid;

    public static Id withId(String id){
        return new Id(UUID.fromString(id));
    }

    public static Id withoutId(){
        return new Id(UUID.randomUUID());
    }

}
