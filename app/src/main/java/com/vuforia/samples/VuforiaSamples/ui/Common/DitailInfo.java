package com.vuforia.samples.VuforiaSamples.ui.Common;

/**
 * Created by aquat on 2018/01/20.
 */

public class DitailInfo {


    private String caption;
    public String getCaption(){return caption;}
    public void setCaption(String str){caption = str;}

    public int index;
    public int getIndex(){return index;}
    public void setIndex(int num){index = num;}

    public boolean showFlag = true;
    public boolean getShowFlag(){return showFlag;}
    public void setShowFlag(boolean value){showFlag = value;}

    private String ditail;
    public String getDitail(){return ditail;}
    public void setDitail(String str){ditail = str;}

    public DitailInfo(String caption,String ditail,int index,boolean showFlag){

        this.caption = caption;
        this.ditail = ditail;
        this.index = index;
        this.showFlag = showFlag;
    }
}
