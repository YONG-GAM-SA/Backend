package com.yonggamsa.withsuyeonjung.chatroom.domain.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Id {
    private String id;
    public Id(String id) {
        this.id = id;
    }
//    private final String lat;
//    private final String lng;

//    public Id(String url, String lat, String lng) {
//        this.url = url;
//        this.lat = lat;
//        this.lng = lng;
//    }
}
