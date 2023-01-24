package com.yonggamsa.withsuyeonjung.user.framework;

import java.util.stream.Stream;

public class NicknameUtil {

    private static String[] names = Nickname.getAllNames();

    private enum Nickname {
        외로운늑대("외로운늑대"),
        호기심많은호랑이("호기심많은호랑이"),
        배고픈사자("배고픈사자"),
        나무위원숭이("나무위원숭이");

        private final String name;

        Nickname(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public static String[] getAllNames(){
            return Stream.of(values())
                    .map(Nickname::getName)
                    .toArray(String[]::new);
        }
    }

    public static String createRandomNickname(){
        int random_idx = (int)(Math.random() * (names.length - 1));
        return names[random_idx];
    }

}
