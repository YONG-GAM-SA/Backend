//package com.yonggamsa.withsuyeonjung.user.framework.configuration.security.oauth.repository;
//
//import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.data.RefreshToken;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.UUID;
//
//@Repository
//public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
//    RefreshToken findByUserId(String userId);
//    RefreshToken findByUserIdAndRefreshToken(UUID userId, String refreshToken);
//}