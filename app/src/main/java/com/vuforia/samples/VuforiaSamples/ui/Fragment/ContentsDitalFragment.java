package com.vuforia.samples.VuforiaSamples.ui.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.Common.DitailInfo;
import com.vuforia.samples.VuforiaSamples.ui.Common.ProductInfo;
import com.vuforia.samples.VuforiaSamples.ui.Common.UserInfo;
import com.vuforia.samples.VuforiaSamples.ui.CustomView.DitailView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aquat on 2017/12/28.
 */

public class ContentsDitalFragment extends Fragment {

    View layout;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        try{

            layout = inflater.inflate(R.layout.contents_dital_fragment, null);

        }catch (Exception e){

            e.printStackTrace();
        }




        LinearLayout ditaileLine = (LinearLayout)layout.findViewById(R.id.contents_ditail);

        //詳細情報分Viewを追加
        /*for(Map.Entry<String,String> e : UserInfo.getInstance().getProductInfoMap().entrySet()){

            DitailView ditailView = new DitailView(this.getActivity().getApplicationContext(),null);
            ditailView.setText(e.getKey(),e.getValue());

            ditaileLine.addView(ditailView);

        }*/

        List<DitailInfo> ditailInfos = UserInfo.getInstance().getDitailInfos();
        for(int i = 0; i < ditailInfos.size();i++){

            DitailView ditailView = new DitailView(this.getActivity().getApplicationContext(),null);

            DitailInfo dInfo = null;
            for (DitailInfo info: ditailInfos
                 ) {
                if(info.index == i){
                    if(info.showFlag){
                        dInfo = info;
                    }else{
                        break;
                    }
                }
            }
            if(dInfo == null)continue;

            //画像は別処理
            if(dInfo.getCaption() == ProductInfo.IMAGE){
                setImage();
                continue;
            }

            ditailView.setText(dInfo.getCaption(), dInfo.getDitail());
            ditaileLine.addView(ditailView);

        }

        return layout;
    }

    public void setImage(){

        //画像をセット
        ImageView imageView = (ImageView)layout.findViewById(R.id.photo);
        imageView.setImageResource(R.drawable.puroduct_smple1);

    }
}
