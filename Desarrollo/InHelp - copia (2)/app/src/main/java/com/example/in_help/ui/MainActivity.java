package com.example.in_help.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.in_help.Prueba_MenuLateral2;
import com.example.in_help.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
    }
    // Método para ir a la pantalla de login
    public void GoLogin(View view){
        Intent GoLogin = new Intent(this,IUA1_1_Login.class);
        startActivity(GoLogin);
    }

    public void GoRegistro(View view){
        Intent GoRegistro = new Intent(this, IUA1_2_Registro_de_Cuenta.class);
        startActivity(GoRegistro);
    }

    public void GoDatos(View view){
        Intent GoDatos = new Intent(this, Prueba_MenuLateral2.class);
        startActivity(GoDatos);
    }



}
