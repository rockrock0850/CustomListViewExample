package com.example.adam_yeh.custom.listview.example;

import android.text.TextUtils;

/**
 * ListView資料物件
 *
 * @author adam_yeh
 * @date 7/9/18
 */
public class ListViewVO {

    private int imgId;
    private String title;
    private String subTitle;
    private String imgName;
    private boolean showButton;

    public boolean isShowButton () {
        return showButton;
    }

    public void setShowButton (boolean showButton) {
        this.showButton = showButton;
    }

    public String getImgName () {
        return imgName;
    }

    public void setImgName (String imgName) {
        this.imgName = imgName;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getSubTitle () {
        return subTitle;
    }

    public void setSubTitle (String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImgId () {
        return imgId;
    }

    public void setImgId (String imgName) {
        if (TextUtils.equals(imgName, Imgs.PIC_0.getId())) {
            this.imgId = R.drawable.download_0;
        } else if (TextUtils.equals(imgName, Imgs.PIC_1.getId())) {
            this.imgId = R.drawable.download_1;
        } else if (TextUtils.equals(imgName, Imgs.PIC_2.getId())) {
            this.imgId = R.drawable.download_2;
        } else if (TextUtils.equals(imgName, Imgs.PIC_3.getId())) {
            this.imgId = R.drawable.download_3;
        } else if (TextUtils.equals(imgName, Imgs.PIC_4.getId())) {
            this.imgId = R.drawable.download_4;
        } else if (TextUtils.equals(imgName, Imgs.PIC_5.getId())) {
            this.imgId = R.drawable.download_5;
        } else if (TextUtils.equals(imgName, Imgs.PIC_6.getId())) {
            this.imgId = R.drawable.download_6;
        } else if (TextUtils.equals(imgName, Imgs.PIC_7.getId())) {
            this.imgId = R.drawable.download_7;
        } else if (TextUtils.equals(imgName, Imgs.PIC_8.getId())) {
            this.imgId = R.drawable.download_8;
        } else if (TextUtils.equals(imgName, Imgs.PIC_9.getId())) {
            this.imgId = R.drawable.download_9;
        }
    }

    private enum Imgs {

        PIC_0("download_0"),
        PIC_1("download_1"),
        PIC_2("download_2"),
        PIC_3("download_3"),
        PIC_4("download_4"),
        PIC_5("download_5"),
        PIC_6("download_6"),
        PIC_7("download_7"),
        PIC_8("download_8"),
        PIC_9("download_9");

        private String id;

        Imgs (String id) {
            this.id = id;
        }

        public String getId () {
            return id;
        }

    }

}
