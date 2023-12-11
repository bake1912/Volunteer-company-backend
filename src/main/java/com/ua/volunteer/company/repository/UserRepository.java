package com.ua.volunteer.company.repository;

import com.ua.jooq.Tables;
import com.ua.volunteer.company.entity.PhotoUser;
import com.ua.volunteer.company.entity.UserLogin;
import com.ua.volunteer.company.entity.UserRegister;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private DSLContext dsl;


    public List< UserRegister> getAll(){
      return  dsl.select().from(Tables.USER).fetchInto(UserRegister.class);
    }

    public UserRegister register(UserRegister user){
        try {
            UserRegister returningUser = dsl.insertInto(Tables.USER)
                    .set(Tables.USER.FIRST_NAME, user.getFirstName())
                    .set(Tables.USER.LAST_NAME, user.getLastName())
                    .set(Tables.USER.EMAIL, user.getEmail())
                    .set(Tables.USER.PASSWORD, user.getPassword())
                    .set(Tables.USER.SEX_NAME, user.getSexName())
                    .set(Tables.USER.ROLE_NAME,user.getRoleName())
                    .set(Tables.USER.OCCUPATION_NAME,user.getOccupationName())
                    .returning()
                    .fetchOneInto(UserRegister.class);
            return returningUser;
        } catch (DataAccessException e){
            return null;
        }
        }

        public UserRegister getUser(UserLogin user){
        UserRegister returningUser = dsl.select().from(Tables.USER)
                .where(Tables.USER.EMAIL.eq(user.getEmail()),
                        Tables.USER.PASSWORD.eq(user.getPassword()))
                .fetchOneInto(UserRegister.class);
        return returningUser;
        }

        public List<PhotoUser> getPhotoUser(Integer userId){
        return dsl.select().from(Tables.USERPHOTO).where(Tables.USERPHOTO.USER_ID.eq(userId)).fetchInto(PhotoUser.class);
        }

        public PhotoUser uploadPhoto(Integer userId,byte[] photo){
              return dsl.insertInto(Tables.USERPHOTO)
                        .set(Tables.USERPHOTO.PHOTO,photo)
                        .set(Tables.USERPHOTO.USER_ID,userId)
                        .returning()
                        .fetchOneInto(PhotoUser.class);
        }
}
