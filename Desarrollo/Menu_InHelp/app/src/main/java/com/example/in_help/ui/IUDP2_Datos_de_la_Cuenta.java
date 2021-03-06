package com.example.in_help.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.in_help.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IUDP2_Datos_de_la_Cuenta extends AppCompatActivity {

    public TextView correo , password;
    public String content;
    private static final String TAG = "Log";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iudp2__datos_de_la__cuenta);

        correo = (TextView)findViewById(R.id.textView76);
        password = (TextView)findViewById(R.id.textView78);
        ObtenerDatosCuenta(2);
    }

    public void ObtenerDatosCuenta (Integer id_usuario){
        APIServer service = Cliente.getAPIServer();

        final DatosCuentaRequest datosCuentaRequest = new DatosCuentaRequest();
        Call<List<DatosCuentaRequest>> respuesta = service.ObtenerinfoDatosCuenta(id_usuario);
    respuesta.enqueue(new Callback<List<DatosCuentaRequest>>() {
        @Override
        public void onResponse(Call<List<DatosCuentaRequest>> call, Response<List<DatosCuentaRequest>> response) {
            Toast.makeText(IUDP2_Datos_de_la_Cuenta.this, "BUENOTE", Toast.LENGTH_SHORT).show();
            List<DatosCuentaRequest> listPost = response.body();
            content = "";
            for(DatosCuentaRequest datosCuentaRequest: listPost){
                content +="Correo: "+datosCuentaRequest.getTx_login();
                content +="Password: "+datosCuentaRequest.getTx_password();

            }
            correo.setText(content);
            Log.d(TAG, "Respuesta: "+content);
        }

        @Override
        public void onFailure(Call<List<DatosCuentaRequest>> call, Throwable t) {
            Toast.makeText(IUDP2_Datos_de_la_Cuenta.this, "MALOTE"+t, Toast.LENGTH_SHORT).show();
        }
    });

    }


}
