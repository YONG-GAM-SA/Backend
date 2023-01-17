package com.yonggamsa.withsuyeonjung.user.framework;

import java.util.stream.Stream;

public class NicknamUtil {

    private static String[] names = NickName.getAllNames();

    enum NickName {
        외로운늑대("외로운늑대"),
        호기심많은호랑이("호기심많은호랑이"),
        배고픈사자("배고픈사자"),
        나무위원숭이("나무위원숭이");

        private final String name;

        NickName(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public static String[] getAllNames(){
            return Stream.of(values())
                    .map(NickName::getName)
                    .toArray(String[]::new);
        }
    }

    public static String createRandomNickname(){
        int random_idx = (int)(Math.random() * (names.length - 1));
        return names[random_idx];
    }

}
