package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.data;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.RefreshTokenRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefreshTokenRepositoryTest {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @DisplayName("refreshToken을 새로 생성할 수 있다")
    @Test
    public void should_create_refreshToken(){
        // given
        String userId = "user_id";
        String refreshToken = "refresh_token";
        RefreshToken inputRefreshToken = new RefreshToken(userId, refreshToken);

        // when
        RefreshToken outputRefreshToken = refreshTokenRepository.save(inputRefreshToken);

        // then
        assertEquals(inputRefreshToken.getUserId(), outputRefreshToken.getUserId());
    }

    @DisplayName("userId로 refreshToken를 조회할 수 있다")
    @Test
    public void should_retrieve_refreshToken_by_userId(){
        // given
        String userId = "userId";
        String refreshToken = "refresh_token";
        RefreshToken inputRefreshToken = new RefreshToken(userId, refreshToken);
        // when
        refreshTokenRepository.save(inputRefreshToken);
        RefreshToken outputRefreshToken = refreshTokenRepository.findByUserId(userId);
        // then
        assertEquals(inputRefreshToken.getUserId(), outputRefreshToken.getUserId());
        assertEquals(inputRefreshToken.getRefreshToken(), outputRefreshToken.getRefreshToken());
    }

    @DisplayName("userId에 해당하는 refreshToken이 없으면 null을 반환한다")
    @Test
    public void should_return_null_when_token_not_found(){
        // given
        String userId = "empty";
        // when
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId);
        // then
        assertNull(refreshToken);
    }


}