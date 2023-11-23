package com.ua.volunteer.company.repository;

import com.ua.jooq.Tables;
import com.ua.volunteer.company.entity.UserLogin;
import com.ua.volunteer.company.entity.UserRegister;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private DSLContext dsl;

    public UserRegister register(UserRegister user){
     UserRegister returningUser = dsl.insertInto(Tables.USER)
                .set(Tables.USER.FIRST_NAME,user.getFirstName())
                .set(Tables.USER.LAST_NAME,user.getLastName())
                .set(Tables.USER.EMAIL,user.getEmail())
                .set(Tables.USER.PASSWORD,user.getPassword())
                .set(Tables.USER.SEX_NAME,user.getSexName())
                .returning()
                .fetchOneInto(UserRegister.class);
            return returningUser;
        }

        public UserRegister getUser(UserLogin user){
        UserRegister returningUser = dsl.select().from(Tables.USER)
                .where(Tables.USER.EMAIL.eq(user.getEmail()),
                        Tables.USER.PASSWORD.eq(user.getPassword()))
                .fetchOneInto(UserRegister.class);
        return returningUser;
        }
}
