package jairfranco.com.tec2.pfran.examen2;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class FirebaseDatabaseControl {
    private static Query mQuery;
    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private static AdapterRestaurantes adapterRestaurantes;
    private static ArrayList<Restaurant> mAdapterItems;
    private static ArrayList<String> mAdapterKeys;

    public static void setUpDataBase() {
        if (firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
            databaseReference = firebaseDatabase.getReference();
        }
    }

    public static FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public static Query getQuery() {
        mQuery = databaseReference.child("Restaurantes");
        return mQuery;
    }

    public static AdapterRestaurantes Adapter() {
        if (adapterRestaurantes == null) {
            adapterRestaurantes = new AdapterRestaurantes(getQuery(), Restaurant.class, mAdapterItems, mAdapterKeys);
            return adapterRestaurantes;
        } else {
            return adapterRestaurantes;
        }
    }

    public static void addRestaurante(Restaurant restaurante) {
        FirebaseDatabaseControl.setUpDataBase();
        FirebaseDatabase database = FirebaseDatabaseControl.getFirebaseDatabase();
        DatabaseReference newRestaurante = database.getReference().child("Restaurantes").child(restaurante.getsName());
        newRestaurante.setValue(restaurante);
    }
}
