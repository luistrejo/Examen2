package jairfranco.com.tec2.pfran.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetalleRestaurantActivity extends AppCompatActivity {
    private Restaurant restaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_restaurant);

        Intent intent = getIntent();
        if (intent != null) {
            //Recuperamos la ruta seleccionada enviada en el bundle
            restaurant = intent.getParcelableExtra("SELECCION");
        }
        TextView txtVwNombre = findViewById(R.id.txtNombreDetalle);
        TextView txtVwDireccion = findViewById(R.id.txtDireccionDetalle);
        TextView txtVwDesc = findViewById(R.id.txtDescDetalle);
        TextView txtVwTel = findViewById(R.id.txtTelDetalle);
        ImageView imgVwFoto = findViewById(R.id.imgViewDetalle);
        RatingBar ratingBar1 = findViewById(R.id.ratingBarDetalle);

        txtVwNombre.setText(restaurant.getsName());
        txtVwDesc.setText(restaurant.getsDesc());
        txtVwDireccion.setText(restaurant.getsDir());
        txtVwTel.setText(restaurant.getsTel());
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
        imgVwFoto.setImageResource(idImg);
        ratingBar1.setRating((float) restaurant.getdCalif());

        //Listener que cada vez que cambia el rating bar actualiza la bd con el nuevo valor
        ratingBar1.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            restaurant.setdCalif(rating);
            FirebaseDatabaseControl.addRestaurante(restaurant);
        });

    }
}
