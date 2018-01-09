package com.vuforia.samples.VuforiaSamples.ui.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.Common.UserInfo;
import com.vuforia.samples.VuforiaSamples.ui.CustomView.DitailView;

import java.util.HashMap;
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


        //画像をセット
        ImageView imageView = (ImageView)layout.findViewById(R.id.photo);
        imageView.setImageResource(R.drawable.puroduct_smple1);

        LinearLayout ditaileLine = (LinearLayout)layout.findViewById(R.id.contents_ditail);

        //詳細情報分Viewを追加
        for(Map.Entry<String,String> e : UserInfo.getInstance().getProductInfoMap().entrySet()){

            DitailView ditailView = new DitailView(this.getActivity().getApplicationContext(),null);
            ditailView.setText(e.getKey(),e.getValue());

            ditaileLine.addView(ditailView);

        }

        return layout;
    }
}
