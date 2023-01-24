package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.converter.BirthDateConverter;
import com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.converter.EmailConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Table(name = "users")
@Entity
@NoArgsConstructor
public class UserData {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private UserNameData userName;
    @Convert(converter = EmailConverter.class)
    private EmailData email;
    @Embedded
    private NicknameData nickname;
    @Embedded
    private PasswordData password;

    @Convert(converter = BirthDateConverter.class)
    private BirthDateData birthDate;

    @Builder
    public UserData(UUID id, UserNameData userName, EmailData email, NicknameData nickname, PasswordData password, BirthDateData birthDate) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.birthDate = birthDate;
    }

    public UserData update(UserNameData userName, EmailData email){
        this.userName = userName;
        this.email = email;
        return this;
    }

}
