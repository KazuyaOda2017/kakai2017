package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.Common.HttpRequest;
import com.vuforia.samples.VuforiaSamples.ui.Common.JsonUserInfo;


/**
 * Created by K.Oda on 2017/12/16.
 */

public class ActivityUserRegister extends Activity {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_regist_layout);

        //Jsonオブジェクト作成
        JsonUserInfo J_user = new JsonUserInfo();
        J_user.userName = "小田";
        J_user.sex = 0;

        String http_res = "";
        try {
            String json = objectMapper.writeValueAsString(J_user);

            String url = "http://192.168.0.150:8080/kakai2017-restapi/insert/user";
            //http_res = HttpRequest.excutePost(url,json);
            Uri.Builder builder = new Uri.Builder();
            HttpRequest httpRequest = new HttpRequest(url,json);
            httpRequest.execute(builder);

            httpRequest.setOnCallBack(new HttpRequest.CallBackTask(){
                @Override
                public void CallBack(String result){
                    super.CallBack(result);

                    System.out.print("result = " + result);
                }
            });


            System.out.print("test"+http_res);

            String tes = "";

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }

    }

}
