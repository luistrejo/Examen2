package jairfranco.com.tec2.pfran.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent iAdd, iShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iAdd = new Intent(this, AddRestaurant.class);
        iShow = new Intent(this, RestaurantList.class);

    }

    public void onClickAdd(View v) {
        startActivity(iAdd);
    }

    public void onClickShow(View v) {
        startActivity(iShow);
    }

    public void salir(View v) {
        finish();
    }
}
