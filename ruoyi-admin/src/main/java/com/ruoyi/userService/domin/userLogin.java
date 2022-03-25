package com.ruoyi.userService.domin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "登录对象")
public class userLogin{
    private String userid;
    private String password;
    private String token;
}
