package jairfranco.com.tec2.pfran.examen2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class AddRestaurant extends AppCompatActivity {

    private static final int SELECT_IMG_REQUEST = 333;
    private ImageView imgVwFotografia;
    private EditText etName, etDesc, etDir, etTel;
    private int idImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        imgVwFotografia = findViewById(R.id.imgVwFotografia);
        imgVwFotografia.setOnClickListener(v -> {
            Intent inSelectImg = new Intent(getApplicationContext(), SelectImgActivity.class);
            startActivityForResult(inSelectImg, SELECT_IMG_REQUEST);
        });

        etName = findViewById(R.id.etName);
        etDesc = findViewById(R.id.etDesc);
        etDir = findViewById(R.id.etDir);
        etTel = findViewById(R.id.etTel);

    }

    //Metodo que guarda los datos recuperados de los campos en la BD
    public void OnClickRegistrar(View v) {
        String sName, sDesc, sDir, sTel;

        sName = etName.getText().toString();
        sDesc = etDesc.getText().toString();
        sDir = etDir.getText().toString();
        sTel = etTel.getText().toString();

        Restaurant newRestaurant = new Restaurant(idImg, sName, sDesc, sDir, sTel, 3);
        FirebaseDatabaseControl.addRestaurante(newRestaurant);
        Toast.makeText(this, "Restaurante Registrado con exito", Toast.LENGTH_LONG).show();
        finish();
    }

    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SELECT_IMG_REQUEST:
                if (resultCode == Activity.RESULT_OK) {
                    int returnedData = data.getIntExtra("IMAGEN", 0);
                    imgVwFotografia.setImageResource(returnedData);
                    switch (returnedData) {
                        case R.drawable.barrafina:
                            idImg = 0;
                            break;
                        case R.drawable.cafedeadend:
                            idImg = 1;
                            break;
                        case R.drawable.cafelore:
                            idImg = 2;
                            break;
                        case R.drawable.confessional:
                            idImg = 3;
                            break;
                        case R.drawable.donostia:
                            idImg = 4;
                            break;
                        case R.drawable.forkeerestaurant:
                            idImg = 5;
                            break;
                        case R.drawable.posatelier:
                            idImg = 6;
                            break;
                    }
                }
                break;
        }
    }
}
