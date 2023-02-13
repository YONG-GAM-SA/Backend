package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.EmailData;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserData, UUID> {

    Optional<UserData> findByEmail(EmailData email);

}
