package com.phantomes.resources;



import com.phantomes.ApiProtocol;
import com.phantomes.common.ListInfo;
import com.phantomes.common.ListResult;
import com.phantomes.common.Result;
import com.phantomes.entity.User;

import java.util.Arrays;
import java.util.List;

public class UsersResource extends BaseResource {

    public UsersResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Result get() {

        ListInfo info       = new ListInfo();
        ListResult listResult = new ListResult(info);


        List<User> list = Arrays.asList(new User(1,"sz",11),new User(2,"ls",12));

        info.setNum(list.size());
        listResult.setItem(list);

        return listResult;
    }
}
