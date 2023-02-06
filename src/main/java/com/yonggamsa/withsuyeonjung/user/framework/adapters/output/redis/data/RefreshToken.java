package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@RedisHash(value = "token", timeToLive = 604800000L)
public class RefreshToken {

    @Id
    private Long id;
    @Indexed
    private String userId;
    private String refreshToken;

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public RefreshToken(
            @NotNull String userId,
            @NotNull String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
}
