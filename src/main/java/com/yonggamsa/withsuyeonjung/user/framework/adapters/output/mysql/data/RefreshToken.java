package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "REFRESH_TOKEN")
public class RefreshToken {

    @Id
    @JsonIgnore
    @Column(name = "REFRESH_TOKEN_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refreshTokenSeq;

    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "REFRESH_TOKEN", length = 256)
    private String refreshToken;

    public RefreshToken(
            @NotNull UUID userId,
            @NotNull String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
}
