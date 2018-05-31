package com.zack.shop.mvp.model;

import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.zack.shop.mvp.contract.LoginContract;
import com.zack.shop.mvp.http.api.service.LoginService;
import com.zack.shop.mvp.http.entity.BaseResponse;
import com.zack.shop.mvp.http.entity.login.JWTBean;

import io.reactivex.Observable;


/**
 * @Author 张迁-zhangqian
 * @Data 2018/5/30 下午5:29
 * @Package com.zack.shop.mvp.model
 **/
public class LoginModel extends BaseModel implements LoginContract.Model {
    public LoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    public Observable<BaseResponse<JWTBean>> login(String phone, String password) {
        return mRepositoryManager.obtainRetrofitService(LoginService.class)
                .loginByUsernamePassword(phone, password);
    }
}
