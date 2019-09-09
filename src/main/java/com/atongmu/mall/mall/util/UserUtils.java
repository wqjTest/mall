package com.atongmu.mall.mall.util;

import com.atongmu.mall.common.util.exception.UserExceptionDefine;
import com.atongmu.mall.mall.entity.User;
import com.atongmu.mall.mall.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @program: mall
 * @description: 用户相关信息
 * @author: Hus
 * @create: 2018-12-19 13:02
 */
@Component
public class UserUtils {

    @Resource
    private UserService userService;

    public User getUserByTokenId(@NotNull String tokenId) throws UserExceptionDefine{
        User user = userService.getUserByTokenId(tokenId);
        if(user == null){
            throw new UserExceptionDefine("Permission authentication failed");
        }else{
            return user;
        }
    }

    public User getUserById(@NotNull String sourceId) throws UserExceptionDefine{
        User user = userService.getUserById(sourceId);
        if(user == null){
            throw new UserExceptionDefine("Permission authentication failed");
        }else{
            return user;
        }
    }

}