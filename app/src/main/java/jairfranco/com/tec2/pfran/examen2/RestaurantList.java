package jairfranco.com.tec2.pfran.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        RecyclerView recVwRestaurantes = findViewById(R.id.recVwRestaurantes);
        recVwRestaurantes.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        recVwRestaurantes.addItemDecoration(mDividerItemDecoration);
        FirebaseDatabaseControl.setUpDataBase();
        recVwRestaurantes.setAdapter(FirebaseDatabaseControl.Adapter());
        recVwRestaurantes.addOnItemTouchListener(new RecyclerItemClickListener(this, (view, position) -> {

            Intent inDetalle = new Intent(this, DetalleRestaurantActivity.class);
            inDetalle.putExtra("SELECCION", FirebaseDatabaseControl.Adapter().getItem(position));

            startActivity(inDetalle);
        }));
    }
}
