package com.phantomes.resources;


import com.phantomes.ApiProtocol;
import com.phantomes.common.AlbumInfo;
import com.phantomes.common.Info;
import com.phantomes.common.Result;
import com.phantomes.common.Star;
import com.phantomes.entity.Album;
import com.phantomes.entity.User;

public class AlbumResource extends BaseResource {

    public AlbumResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Result get() {

        int uid, aid;

        Object uidCheck = parameterIntCheck(apiProtocol, "uid");
        if (uidCheck instanceof Result) {
            return (Result) uidCheck;
        } else {
            uid = (int) uidCheck;
        }

        Object aidCheck = parameterIntCheck(apiProtocol,"aid");
        if (aidCheck instanceof Result){
            return (Result) aidCheck;
        }else {
            aid = (int) aidCheck;
        }


        return new Result<Info>(new AlbumInfo(new Album(1,new User(1,"zs",11),"c",new Star(1,true))));
    }
}
