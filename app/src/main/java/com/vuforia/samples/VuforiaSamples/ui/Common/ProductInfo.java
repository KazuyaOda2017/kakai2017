package com.vuforia.samples.VuforiaSamples.ui.Common;

/**
 * Created by aquat on 2017/12/19.
 */

public class ProductInfo {

    public String contentsName;

    public String description;

    public String delInfo;

    public String indexInfo;

    public int markerId;

    public String image;

    //コンストラクタ
    public ProductInfo() {
    }

    //region 定義

    public static final String MARKERID = "markerId";
    public static final String IMAGE = "image";

    public static String[] productIndexNames = {"商品名", "image", "キャッチコピー", "詳細", "コク", "甘味", "酸味", "販売価格", "ドリップコーヒー価格", "カフェオレ価格"};

    public static String[] cardIndexNames = {"商品名", "キャッチコピー", "販売価格", "ドリップコーヒー価格"};

    public enum IndexName {
        PRODUCT_NAME("商品名"),
        CHACH_COPY("キャッチコピー"),
        PRICE_BEANS("販売価格"),
        PRICE_DRIP("ドリップコーヒー価格"),;

        private final String text;

        private IndexName(final String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }
    //endregion



}
