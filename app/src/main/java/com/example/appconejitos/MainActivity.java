package com.example.appconejitos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    ImageView[] ranas;

    int [] ids ={R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ranas= new ImageView[7];
        for (int i=0; i<ranas.length; i++){
            ranas[i]=findViewById(ids[i]);
            int index = i;
            ranas[i].setOnClickListener(v -> {
                moverRanas(index);
                for (ImageView iv : ranas) {
                    asignarimagenes(iv);
                }
            });
        }

        inicializar();
        for (ImageView iv : ranas) {
            asignarimagenes(iv);
        }

        Button fin = findViewById(R.id.btnFin);
        fin.setOnClickListener(v -> startActivity(new Intent(this, ResultActivity.class)));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void inicializar(){
        ranas[0].setTag(1);
        ranas[1].setTag(2);
        ranas[2].setTag(3);
        ranas[3].setTag(0);
        ranas[4].setTag(4);
        ranas[5].setTag(5);
        ranas[6].setTag(6);
    }

    private void asignarimagenes(ImageView imagen){
        int tag = (int) imagen.getTag();

        switch (tag){
            case 0:
                imagen.setImageDrawable(null);
                break;

            case 1:
            case 2:
            case 3:
                imagen.setImageResource(R.drawable.iz);
                break;

            case 4:
            case 5:
            case 6:
                imagen.setImageResource(R.drawable.der);
                break;
        }


    }
    private int posicionvacia() {
        for (int i = 0; i < ranas.length; i++) {
            if ((int) ranas[i].getTag() == 0) {
                return i;
            }
        }
        return -1;
    }
    private void moverRanas(int desde) {
        int vacio = posicionvacia();
        if (vacio == -1)
            return;

        int tagDesde = (int) ranas[desde].getTag();

        if (tagDesde == 0)
            return;

        if (Math.abs(vacio - desde) == 1) {
            if (tagDesde >= 1 && tagDesde <= 3 && vacio > desde) {
                intercambiarTag(desde, vacio);
            } else if (tagDesde >= 4 && tagDesde <= 6 && vacio < desde) {
                intercambiarTag(desde, vacio);
            }
        }

        if (Math.abs(vacio - desde) == 2) {
            int medio = (desde + vacio) / 2;
            int tagmedio = (int) ranas[medio].getTag();
            if (tagmedio != 0) {
                if (tagDesde >= 1 && tagDesde <= 3 && vacio > desde) {
                    intercambiarTag(desde, vacio);
                } else if (tagDesde >= 4 && tagDesde <= 6 && vacio < desde) {
                    intercambiarTag(desde, vacio);
                }
            }
        }



    }
    private void intercambiarTag(int pos1, int pos2) {
        Object temp = ranas[pos1].getTag();
        ranas[pos1].setTag(ranas[pos2].getTag());
        ranas[pos2].setTag(temp);
    }
}