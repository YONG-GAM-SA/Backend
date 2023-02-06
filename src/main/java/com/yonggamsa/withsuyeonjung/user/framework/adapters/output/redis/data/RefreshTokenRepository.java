package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.redis.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
    RefreshToken findByUserId(String userId);
}