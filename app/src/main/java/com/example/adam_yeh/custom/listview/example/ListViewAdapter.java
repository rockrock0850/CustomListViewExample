package com.example.adam_yeh.custom.listview.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * BaseAdapter
 * Activity
 * Why View holder
 * Method數量25536限制
 *
 * @author adam_yeh
 * @date 7/9/18
 */
public class ListViewAdapter extends ArrayAdapter<ListViewVO> implements AdapterView.OnItemClickListener, View.OnClickListener {

    private final String TAG = this.getClass().getSimpleName();

    private final Activity context;
    private List<ListViewVO> dataList;

    // 不要將Activty耦合, 容易造成OOM, 很難被GC, 直到外在Activity被回收之後才會被釋放
    public ListViewAdapter (Activity context, List<ListViewVO> dataList) {
        super(context, R.layout.item, dataList);
        this.context = context;
        this.dataList = setImgId(dataList);

    }

    @Override
    public View getView (int position, View view, ViewGroup parent) {
        ListViewVO vo = super.getItem(position);

        LayoutInflater inflater = context.getLayoutInflater();

        // root 父類別view 樹狀連結 影響ui why inflate root attachToRoot
        View itemView = inflater.inflate(R.layout.item, null, true);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.icon);
        TextView title = (TextView) itemView.findViewById(R.id.title);
        TextView subTitle = (TextView) itemView.findViewById(R.id.subtitle);
        Button button = (Button) itemView.findViewById(R.id.button);

        if (position % 2 == 0) {
            itemView.setBackgroundColor(Color.YELLOW);
        }

        if (!vo.isShowButton()) {
            button.setVisibility(View.INVISIBLE);
        }

        imageView.setImageResource(vo.getImgId());

        title.setText(vo.getTitle());
        subTitle.setText(vo.getSubTitle());
        button.setOnClickListener(this);

        return itemView;
    }

    @Override
    public void onItemClick (AdapterView<?> adapterView, View v, int position, long l) {
        Intent i = new Intent(adapterView.getContext(), Main2Activity.class);
        i.putExtra("position", "Item clicked No. " + position + " item.");
        v.getContext().startActivity(i);
    }

    @Override
    public void onClick (View v) {
        View row = (View) v.getParent();
        ListView listView = (ListView) v.getParent().getParent();
        int position = listView.getPositionForView(row);

        Toast.makeText(v.getContext(), "Button clicked No. " + position + " item.", Toast.LENGTH_SHORT).show();
    }

    private List<ListViewVO> setImgId (List<ListViewVO> dataList) {
        for (ListViewVO vo : dataList) {
            vo.setImgId(vo.getImgName());
        }

        return dataList;
    }

}
