package com.vuforia.samples.VuforiaSamples.ui.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aquat on 2017/12/28.
 */

public class CmtDataList {

    public int cmtCount;

    public int offset;

    public String userId;

    public int markerId;

    public List<CommentInfo> dispList;

    public CmtDataList() {
        dispList = new ArrayList<CommentInfo>();

    }
}
