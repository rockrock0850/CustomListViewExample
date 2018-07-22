package com.example.adam_yeh.custom.listview.example;

import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 資源檔共用工具
 *
 * @author adam_yeh
 * @date 7/16/18
 */
public class AssetsUtil {

    private static final String TAG = AssetsUtil.class.getSimpleName();

    public static List<ListViewVO> getJSONFromAsset (AssetManager manager) {
        return getJSONFromAsset(null, manager);
    }

    public static List<ListViewVO> getJSONFromAsset (String index, AssetManager manager) {
        String jsonData = "";
        JSONArray jsonArray = null;
        ListViewVO vo = null;
        List<ListViewVO> list = new ArrayList<>();

        try {
            index = TextUtils.isEmpty(index) ? "" : "_" + index;
            InputStream is = manager.open("rowData" + index + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            jsonData = new String(buffer, "UTF-8");
            jsonArray = new JSONArray(jsonData);

            Log.d(TAG, jsonArray.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonData = jsonArray.getString(i);
                vo = new Gson().fromJson(jsonData, ListViewVO.class);
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
