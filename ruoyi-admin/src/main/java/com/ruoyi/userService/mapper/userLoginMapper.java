package com.ruoyi.userService.mapper;
import com.ruoyi.kooklen.domain.userAccountManagement;
import com.ruoyi.userService.domin.userLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//dao
@Mapper
public interface userLoginMapper
{
    Userid login(Userid userid);

    class Userid {
    }
}
