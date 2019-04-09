package jairfranco.com.tec2.pfran.examen2;


import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * Created by Matteo on 24/08/2015.
 */
public class AdapterRestaurantes extends FirebaseAdapterRestaurantes<AdapterRestaurantes.ViewHolder, Restaurant> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtVwNombre, txtVwDireccion, txtVwDesc, txtVwTel;
        private ImageView imgVwFoto;
        private RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            txtVwNombre = view.findViewById(R.id.txtVwTitulo);
            txtVwDireccion = view.findViewById(R.id.txtVwDireccion);
            txtVwDesc = view.findViewById(R.id.txtVwDesc);
            txtVwTel = view.findViewById(R.id.txtVwTel);
            imgVwFoto = view.findViewById(R.id.imgVwFoto);
            ratingBar = view.findViewById(R.id.ratingBar);
        }
    }

    public AdapterRestaurantes(Query query, Class<Restaurant> itemClass, @Nullable ArrayList<Restaurant> items,
                               @Nullable ArrayList<String> keys) {
        super(query, itemClass, items, keys);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurantes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurant restaurant = getItem(position);

        holder.txtVwNombre.setText(restaurant.getsName());
        holder.txtVwDesc.setText(restaurant.getsDesc());
        holder.txtVwDireccion.setText(restaurant.getsDir());
        holder.txtVwTel.setText(restaurant.getsTel());
        int idImg = 0;
        switch (restaurant.getImgRest()) {
            case 0:
                idImg = R.drawable.barrafina;
                break;
            case 1:
                idImg = R.drawable.cafedeadend;
                break;
            case 2:
                idImg = R.drawable.cafelore;
                break;
            case 3:
                idImg = R.drawable.confessional;
                break;
            case 4:
                idImg = R.drawable.donostia;
                break;
            case 5:
                idImg = R.drawable.forkeerestaurant;
                break;
            case 6:
                idImg = R.drawable.posatelier;
                break;
        }
        holder.imgVwFoto.setImageResource(idImg);
        holder.ratingBar.setRating((float) restaurant.getdCalif());

    }

    @Override
    protected void itemAdded(Restaurant item, String key, int position) {
    }

    @Override
    protected void itemChanged(Restaurant oldItem, Restaurant newItem, String key, int position) {
    }

    @Override
    protected void itemRemoved(Restaurant item, String key, int position) {
    }

    @Override
    protected void itemMoved(Restaurant item, String key, int oldPosition, int newPosition) {
    }
}