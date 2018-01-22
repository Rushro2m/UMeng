package com.rushro2m.umeng;

import android.app.Application;
import android.util.Log;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by 16918 on 2018/1/22.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("MyApp", "onSuccess: " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("MyApp", "onSuccess: " + s + "," + s1);
            }
        });


        Config.DEBUG = true;
        UMShareAPI.get(this);

        {
            PlatformConfig.setQQZone("1106696060", "g6PWi85oujassWXy");
        }
    }


}
