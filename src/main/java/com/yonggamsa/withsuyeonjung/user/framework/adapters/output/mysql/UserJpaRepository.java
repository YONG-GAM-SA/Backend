package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.UUID;

@ApplicationScope
public interface UserJpaRepository extends JpaRepository<UserData, UUID> {

    UserData findByEmail(String email);

}
