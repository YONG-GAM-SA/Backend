package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "REFRESH_TOKEN")
public class RefreshToken {

    @Id
    @JsonIgnore
    @Column(name = "REFRESH_TOKEN_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refreshTokenSeq;

    @Column(name = "USER_ID", length = 256)
    private String userId;

    @Column(name = "REFRESH_TOKEN", length = 256)
    private String refreshToken;

    public RefreshToken(
            @NotNull String userId,
            @NotNull String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
}
