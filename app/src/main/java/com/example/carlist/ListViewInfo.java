package com.example.carlist;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carlist.models.Car;

import java.util.ArrayList;
import java.util.List;

public class ListViewInfo extends AppCompatActivity {

    List<Car> crList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_info);

        crList = new ArrayList<>();

        crList.add(new Car(R.drawable.astra, "Astra", "Chevrolet"));
        crList.add(new Car(R.drawable.c4_pallas, "C4 Pallas", "Citroen"));
        crList.add(new Car(R.drawable.city, "City", "Honda"));
        crList.add(new Car(R.drawable.civic, "Civic", "Honda"));
        crList.add(new Car(R.drawable.corolla, "Corolla", "Toyota"));
        crList.add(new Car(R.drawable.cruze, "Cruze", "Chevrolet"));
        crList.add(new Car(R.drawable.focus, "Focus", "Ford"));
        crList.add(new Car(R.drawable.onix, "Onix", "Chevrolet"));
        crList.add(new Car(R.drawable.sentra, "Sentra", "Nissan"));
        crList.add(new Car(R.drawable.fusion, "Fusion", "Ford"));

        listView = (ListView) findViewById(R.id.listView);

        ListAdapter adapter = new ListAdapter(this, R.layout.layout_my_list_item, crList);

        listView.setAdapter(adapter);
    }
}
