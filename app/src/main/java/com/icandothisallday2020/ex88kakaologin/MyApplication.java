package com.icandothisallday2020.ex88kakaologin;

import android.app.Application;
import android.content.Context;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

public class MyApplication extends Application {
    //static 으로 만든 멤버변수는 앱이 종료되어도 사라지지 않을 수 있기 때문에
    //같은 앱 내 모든 액티비티에서 사용가능한 필드들을 여기서 저장


    @Override
    public void onCreate() {
        super.onCreate();

        //KakaoAdapter : 카카오 SDK 와 앱의 Application 연결
        //카카오 초기화
        KakaoSDK.init(new KakaoAdapter() {
            @Override
            public IApplicationConfig getApplicationConfig() {
                //Application 이 가지고 있는 정보를 얻기 위한 인터페이스
                return new IApplicationConfig() {
                    @Override
                    public Context getApplicationContext() {
                        return MyApplication.this;//나를 리턴
                    }
                };
            }
        });

    }
}
