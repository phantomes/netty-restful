package com.phantomes.resources;


import com.phantomes.ApiProtocol;
import com.phantomes.StatusCode;
import com.phantomes.common.Info;
import com.phantomes.common.ListInfo;
import com.phantomes.common.Result;
import com.phantomes.common.UserCreateSuccess;
import com.phantomes.entity.User;

public class UserResource extends BaseResource {

    public UserResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Result get() {

        int uid;

        Object uidCheck = parameterIntCheck(apiProtocol, "uid");
        if (uidCheck instanceof Result) {
            return (Result) uidCheck;
        } else {
            uid = (int) uidCheck;
        }

        ListInfo.UserInfo userInfo    = new ListInfo.UserInfo(new User(1,"ls",11));

        return new Result<Info>(userInfo);
    }

    public Result post() {
        UserCreateSuccess userCreateSuccess = new UserCreateSuccess();
        userCreateSuccess.setId(2);
        userCreateSuccess.setUrl("http://netty.restful.api.mengkang.net/user/2");
        userCreateSuccess.setCode(StatusCode.CREATED_SUCCESS);
        return new Result<>(userCreateSuccess);
    }

    public Result patch() {
        return success(202);
    }

    public Result delete() {
        return success(203);
    }

}
