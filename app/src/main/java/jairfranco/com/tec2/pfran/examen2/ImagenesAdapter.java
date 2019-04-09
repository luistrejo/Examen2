package jairfranco.com.tec2.pfran.examen2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImagenesAdapter<Integer> extends ArrayAdapter<java.lang.Integer> {

    private Context mContext;
    private ArrayList<java.lang.Integer> imgList;

    public ImagenesAdapter(@NonNull Context context, ArrayList<java.lang.Integer> list) {
        super(context, 0, list);
        mContext = context;
        imgList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_imagenes, parent, false);

        ImageView image = listItem.findViewById(R.id.imgVwFotografia);
        image.setImageResource(imgList.get(position));

        return listItem;
    }
}
