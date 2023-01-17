package com.yonggamsa.withsuyeonjung.user.framework.adapters.output.mysql.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EmailData {

    private String email;

}
