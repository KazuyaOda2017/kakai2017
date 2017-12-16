package com.vuforia.samples.VuforiaSamples.ui.Common;

/**
 * Created by K.Oda on 2017/12/16.
 */

public class UserInfo {

    //region シングルトンパターンでインスタンスを生成
    private  static UserInfo instance;// = new UserInfo();

    private UserInfo(){

        instance = null;
    }

    public static UserInfo getInstance(){
        if(instance == null){
            instance = new UserInfo();
        }
        return instance;
    }
    //endregion

    //region プロパティ
    private String userName;
    public String getUserName(){return userName;}
    public void setUserName(String name){this.userName = name;}

    private String userId;
    public String getUserId(){return userId;}
    public void setUserId(String id){this.userId = id;}

    private int sex;
    public int getSex(){return sex;}
    public void setSex(int sex){this.sex = sex;}

    //endregion
}
