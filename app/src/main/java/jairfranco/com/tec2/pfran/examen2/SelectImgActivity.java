package jairfranco.com.tec2.pfran.examen2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectImgActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lstVwImagenes;
    static ArrayList<Integer> asImagenes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_img);

        asImagenes.add(R.drawable.barrafina);
        asImagenes.add(R.drawable.cafedeadend);
        asImagenes.add(R.drawable.cafelore);
        asImagenes.add(R.drawable.confessional);
        asImagenes.add(R.drawable.donostia);
        asImagenes.add(R.drawable.forkeerestaurant);
        asImagenes.add(R.drawable.posatelier);


        lstVwImagenes = findViewById(R.id.lstVwImagenes);
        lstVwImagenes.setAdapter(new ImagenesAdapter<Integer>(getApplicationContext(), asImagenes));
        lstVwImagenes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int iImg = asImagenes.get(position);
        Intent inDatos = new Intent();
        inDatos.putExtra("IMAGEN", iImg);
        setResult(Activity.RESULT_OK, inDatos);
        finish();
    }
}
