package com.example.carlist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.carlist.models.Car;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Car>
{
    Context ctx;
    int resource;
    List<Car> carList;

    public ListAdapter(Context ctx, int resource, List<Car> carList){
        super(ctx, resource, carList);

        this.ctx = ctx;
        this.resource = resource;
        this.carList = carList;
    }

    /** PREENCHE O LAYOUT COM AS INFORMAÇÕES PARA FORMAR A LISTA NA TELA */
    /** FILL OUT THE LAYOUT WITH THE INFORMATION TO FORM THE LIST ON THE SCREEN */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater lInflater = LayoutInflater.from(ctx);

        /* SET TO THE ITEM DESIGN THROUGH "resource", FOR EXAMPLE layout_my_list_item.xml SETTED IN ListViewInfo.java */
        View view = lInflater.inflate(resource, null);

        TextView txtBrand = view.findViewById(R.id.txtBrand);
        TextView txtName = view.findViewById(R.id.txtName);
        ImageView imageView = view.findViewById(R.id.imageView);

        Car cr = carList.get(position);

        txtBrand.setText(cr.getBrand());
        txtName.setText(cr.getName());
        imageView.setImageDrawable(ctx.getResources().getDrawable(cr.getImage()));

        view.findViewById(R.id.btnDLT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx.getApplicationContext(), "Você clicou no " + cr.getBrand() + " " + cr.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //Log.d("listAdptr", "Position: " + position);

        return view;
    }

    /** DELETE ITEM */
    private void removeItem(final int position)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Tem certeza de que você quer deletar este item?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                carList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
