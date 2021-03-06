package com.example.in_help.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.in_help.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class IUGV1_2_Registrar_Vehiculo extends AppCompatActivity {
    private static final String TAG = "Log";
    public Integer info=1;
    public String content;
    public String fecha;


    public EditText editTextPlacas;
    public EditText editTextNoPoliza;
    public EditText editTextFhPoliza;
    public EditText editDia;
    public EditText editMes;
    public EditText editAnio;

    public RadioGroup Detalles;
    public RadioButton SiDetalles;
    public RadioButton NoDetalles;

    public RadioGroup Aseguradora;
    public RadioButton SiAseg;
    public RadioButton NoAseg;

    public TextView txt_Placas;
    public TextView txt_Detalles;
    public TextView txt_Aseg;
    public TextView txt_NoPoliza;
    public TextView txt_Dia;
    public TextView txt_Mes;
    public TextView txt_Anio;
    public TextView txt_Fhpoliza;

    public Button Btn_Listo;
    private Integer id_vehiculo;
    private Integer id_configuracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iugv1_2__registrar__vehiculo);

       setupActionBar();
/*
        final Datos_IUGV1 objetoVeh = (Datos_IUGV1) getIntent().getExtras().getSerializable("DatosAnt");
        String id_carro = Integer.toString(objetoVeh.getId());
        final Datos_IUGC1 objetoCont = (Datos_IUGC1) getIntent().getExtras().getSerializable("DatosIUGC1");
        String id_cont = Integer.toString(objetoCont.getId_contacto());
        final Datos_IUGC1 objetoTipCont = (Datos_IUGC1) getIntent().getExtras().getSerializable("DatosIUGC1");
        String id_tipo_cont = Integer.toString(objetoTipCont.getId_tipo());
*/


        //Toast.makeText(this, "Id_vehiculo:"+objeto.getId(), Toast.LENGTH_SHORT).show();

        editTextPlacas = (EditText) findViewById(R.id.editText13);
        editTextNoPoliza = (EditText) findViewById(R.id.editText8);
        editDia = (EditText) findViewById(R.id.editText9);
        editMes = (EditText) findViewById(R.id.editTextMes);
        editAnio = (EditText) findViewById(R.id.editTextAnio);

        Detalles = (RadioGroup) findViewById(R.id.radioGroup4);
        SiDetalles = (RadioButton) findViewById(R.id.radioButton8);
        NoDetalles = (RadioButton) findViewById(R.id.radioButton3);

        Aseguradora = (RadioGroup) findViewById(R.id.radioGroup5);
        SiAseg = (RadioButton) findViewById(R.id.radioButton10);
        NoAseg = (RadioButton) findViewById(R.id.radioButton11);

        txt_Placas = (TextView) findViewById(R.id.textView53);
        txt_Detalles = (TextView) findViewById(R.id.textView35);
        txt_Aseg = (TextView) findViewById(R.id.textView36);
        txt_NoPoliza = (TextView) findViewById(R.id.textView37);
        txt_Dia = (TextView) findViewById(R.id.TextDia);
        txt_Mes = (TextView) findViewById(R.id.TextMes);
        txt_Anio = (TextView) findViewById(R.id.TextAnio);
        txt_Fhpoliza = (TextView) findViewById(R.id.textView38);

        //ObtenerVehiculos3(1,objeto.getId());
        //ObtenerPoliza(1,objeto.getId());

        Btn_Listo = (Button) findViewById(R.id.button10);


        SiDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_Aseg.setVisibility(View.VISIBLE);
                Aseguradora.setVisibility(View.VISIBLE);

            }
        });




        NoDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_Aseg.setVisibility(View.GONE);
                Aseguradora.setVisibility(View.GONE);
                editDia.setVisibility(View.GONE);
                editMes.setVisibility(View.GONE);
                editAnio.setVisibility(View.GONE);
                txt_Dia.setVisibility(View.GONE);
                txt_Mes.setVisibility(View.GONE);
                txt_Anio.setVisibility(View.GONE);
                editTextNoPoliza.setVisibility(View.GONE);
                txt_NoPoliza.setVisibility(View.GONE);
                txt_Fhpoliza.setVisibility(View.GONE);
            }
        });

        SiAseg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_NoPoliza.setVisibility(View.VISIBLE);
                editTextNoPoliza.setVisibility(View.VISIBLE);
                txt_Fhpoliza.setVisibility(View.VISIBLE);
                editDia.setVisibility(View.VISIBLE);
                editMes.setVisibility(View.VISIBLE);
                editAnio.setVisibility(View.VISIBLE);
                txt_Dia.setVisibility(View.VISIBLE);
                txt_Mes.setVisibility(View.VISIBLE);
                txt_Anio.setVisibility(View.VISIBLE);



            }
        });

        NoAseg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_NoPoliza.setVisibility(View.GONE);
                editTextNoPoliza.setVisibility(View.GONE);
                txt_Fhpoliza.setVisibility(View.GONE);
                editDia.setVisibility(View.GONE);
                editMes.setVisibility(View.GONE);
                editAnio.setVisibility(View.GONE);
                txt_Dia.setVisibility(View.GONE);
                txt_Mes.setVisibility(View.GONE);
                txt_Anio.setVisibility(View.GONE);
            }
        });


        Btn_Listo.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             StringBuilder fecha2 = new StringBuilder();
                                             int info=1;
                                             fecha2.append(editAnio.getText());
                                             fecha2.append("-");
                                             fecha2.append(editMes.getText());
                                             fecha2.append("-");
                                             fecha2.append(editDia.getText());
                                             fecha = fecha2.toString();


                                             if(editTextNoPoliza.length() == 0){
                                                 editTextNoPoliza.setError("Campo obligatorio");
                                                 info = 0;
                                             }else if(editTextNoPoliza.length() > 0 && editTextNoPoliza.length()<17){
                                                 editTextNoPoliza.setError("El numero de poliza debe tener al menos 16 caracteres");
                                                 info = 0;
                                             }

                                             if(editDia.length() == 0){
                                                 editDia.setError("Campo obligatorio");
                                                 info = 0;
                                             }else if(editDia.length() > 0 && editDia.length()<2){
                                                 editDia.setError("El día debe tener 2 caracteres");
                                                 info = 0;
                                             }else if(editDia.getText().toString().equals("00")){
                                                 editDia.setError("Error en formato");
                                                 info = 0;
                                             }else if(editDia.length() > 0){
                                                 Integer intDia = Integer.valueOf(editDia.getText().toString());
                                                 if(intDia > 31){
                                                     editDia.setError("Día inválido");
                                                     info = 0;
                                                 }
                                             }

                                             if(editMes.length() == 0){
                                                 editMes.setError("Campo obligatorio");
                                                 info = 0;
                                             }else if(editMes.length() > 0 && editMes.length()<2){
                                                 editMes.setError("El mes debe tener 2 caracteres");
                                                 info = 0;
                                             }else if(editMes.getText().toString().equals("00")){
                                                 editMes.setError("Error en formato");
                                                 info = 0;
                                             }else if(editMes.length() > 0){
                                                 Integer intMes = Integer.valueOf(editMes.getText().toString());
                                                 if(intMes > 12){
                                                     editMes.setError("Mes inválido");
                                                     info = 0;
                                                 }
                                             }

                                             if(editAnio.length() == 0){
                                                 editAnio.setError("Campo obligatorio");
                                                 info = 0;
                                             }else if(editAnio.length() > 0 && editAnio.length()<2){
                                                 editAnio.setError("El año debe tener 4 caracteres");
                                                 info = 0;
                                             }else if(editAnio.getText().toString().equals("0000")){
                                                 editAnio.setError("Error en formato");
                                                 info = 0;
                                             }else if(editAnio.length() > 0){
                                                 Integer intAnio = Integer.valueOf(editAnio.getText().toString());
                                                 if(intAnio < 2018){
                                                     editAnio.setError("Año inválido");
                                                     info = 0;
                                                 }
                                             }
                                             if (info==1){
                                                 InsertaPlacas();
                                                 registrarPoliza();
                                                 GoRegVeh();
                                                 ObtenerIdVehiculo(1);
                                              //   ObtenerId_Seguro(editTextNoPoliza.getText().toString(),fecha);
                                                 //ActualizaIntermediaVehiculos(1,ObtenerId_Seguro(););

                                             }
                                         }

        });



    }




/* Metodos de insercion*/

    public void InsertaPlacas(){
        APIServer service = Cliente.getAPIServer();
       CrearVehiculoRequest insertaPlacas = new CrearVehiculoRequest(null,1,editTextPlacas.getText().toString(),null,null);
        Call<Response> call=(Call<Response>) service.crearVehiculo(insertaPlacas);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                //Toast.makeText(IUGV1_2_Registrar_Vehiculo.this, "Placas Registradas", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                //Toast.makeText(IUGV1_2_Registrar_Vehiculo.this, "Algo Salio Mal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registrarPoliza(){

        APIServer service = Cliente.getAPIServer();

        RegistrarPolizaRequest poliza = new RegistrarPolizaRequest(editTextNoPoliza.getText().toString(),fecha);


        Call<Response> call = (Call<Response>) service.registrarPoliza(poliza);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                //Toast.makeText(IUGV1_2_Registrar_Vehiculo.this, "Bien", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                //Toast.makeText(IUGV1_2_Registrar_Vehiculo.this, "Mal"+t, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void ObtenerIdVehiculo(Integer id_usuario){

        APIServer service = Cliente.getAPIServer();

        final Datos_IUGV1_Ultimo datosIdContacto_iua1_7 = new Datos_IUGV1_Ultimo();

        Call<List<Datos_IUGV1_Ultimo>> respuesta = service.ObtenerUltimoVehiculo(id_usuario);

        respuesta.enqueue(new Callback<List<Datos_IUGV1_Ultimo>>() {

            @Override
            public void onResponse(Call<List<Datos_IUGV1_Ultimo>> call, retrofit2.Response<List<Datos_IUGV1_Ultimo>> response) {

                List<Datos_IUGV1_Ultimo> datosIdContacto_iua1_7s = response.body();
                for (Datos_IUGV1_Ultimo datosBod : datosIdContacto_iua1_7s){

                     id_vehiculo = datosBod.getId_vehiculo();

                }
                ObtenerContactos(1);
            }

            @Override
            public void onFailure(Call<List<Datos_IUGV1_Ultimo>> call, Throwable t) {

            }
        });
    }




    public void ObtenerContactos(Integer id_usuaio){

        final APIServer service = Cliente.getAPIServer();
        final DatosContacto_IUGC1_1 datosContacto_iugc1_1 = new DatosContacto_IUGC1_1();
        Call<List<DatosContacto_IUGC1_1>> respuesta = service.ObtenerContactosU(id_usuaio);

        respuesta.enqueue(new Callback<List<DatosContacto_IUGC1_1>>() {
            @Override
            public void onResponse(Call<List<DatosContacto_IUGC1_1>> call, retrofit2.Response<List<DatosContacto_IUGC1_1>> response) {

                List<DatosContacto_IUGC1_1> listaDatosContactos = response.body();

                listaDatosContactos.size();


                for (DatosContacto_IUGC1_1 datosBod : listaDatosContactos){

                    Integer id_contacto = datosBod.getId_contacto();
                    Integer id_tipo = datosBod.getId_tipo();
                    Llenaric03(1,id_contacto,id_vehiculo,id_tipo);

                    ObtenerIdtic03(1,id_contacto);

                }
            }

            @Override
            public void onFailure(Call<List<DatosContacto_IUGC1_1>> call, Throwable t) {

            }
        });

    }

    public  void ObtenerIdtic03(Integer id_usuario,Integer id_contacto){

        APIServer server = Cliente.getAPIServer();

        DatosLastTic03 datosLastTic03 = new DatosLastTic03();

        Call<List<DatosLastTic03>> respuesta = server.ObtenerIdTic03(id_contacto,id_usuario);

        respuesta.enqueue(new Callback<List<DatosLastTic03>>() {
            @Override
            public void onResponse(Call<List<DatosLastTic03>> call, retrofit2.Response<List<DatosLastTic03>> response) {
                List<DatosLastTic03> datosLastTic03s = response.body();
                for (DatosLastTic03 datosLastTic031 : datosLastTic03s){
                    id_configuracion = datosLastTic031.getId_configuracion();

                    Llenartn05(id_configuracion,1,1);
                    Llenartn05(id_configuracion,1,2);
                    Llenartn05(id_configuracion,1,3);
                    Llenartn05(id_configuracion,1,4);

                }

            }

            @Override
            public void onFailure(Call<List<DatosLastTic03>> call, Throwable t) {

            }
        });

    }

    public void Llenaric03(Integer id_usuario, final Integer id_contacto, final Integer id_vehiculo, Integer id_tipo){

        APIServer service = Cliente.getAPIServer();

        DatosTIC03 user = new DatosTIC03(id_contacto,id_tipo,id_usuario,id_vehiculo);

        Call<Response> call = (Call<Response>) service.creartic03(user);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }

    public void Llenartn05(Integer id_configuracion,Integer id_estado, Integer id_permiso){

        APIServer service = Cliente.getAPIServer();

        DatosTn05 tn05 = new DatosTn05(id_configuracion,id_estado,id_permiso);

        Call<Response> call = (Call<Response>) service.creartn05(tn05);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.d(TAG, "onResponse: ok tn05");
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }




    public void GoRegVeh(){
        Intent GoRegVeh = new Intent(this, IUGV1_1_Vehiculos_Registrados.class);
        startActivity(GoRegVeh);
        Toast t = Toast.makeText(this,"Vehículo registrado exitosamente", Toast.LENGTH_SHORT);
        t.show();
    }


    private void setupActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }
    }
}
