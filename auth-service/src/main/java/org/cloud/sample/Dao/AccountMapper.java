package org.cloud.sample.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cloud.sample.Entities.Account;

import java.util.Optional;

@Mapper
public interface AccountMapper {
    @Insert("insert into account (email, password) values(#{email}, #{password}) ")
    int createAccount(Account account);
    @Select("select * from account where email=#{email} and password=#{password}")
    Optional<Account> findByEmailAndPass(@Param("email") String email, @Param("password")String password);
}
