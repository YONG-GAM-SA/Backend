package com.yonggamsa.withsuyeonjung.chatroom.domain.vo;

import lombok.Getter;

@Getter
public class Id {
    private final String url;
    private final String lat;
    private final String lng;

    public Id(String url, String lat, String lng) {
        this.url = url;
        this.lat = lat;
        this.lng = lng;
    }
}
