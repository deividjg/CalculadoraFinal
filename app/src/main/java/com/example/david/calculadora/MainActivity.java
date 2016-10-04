package com.example.david.calculadora;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pantalla;
    Double aux;
    String operacionSeleccionada;
    Boolean sustituirPantalla;
    Double res;
    Double mem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalla = (TextView)findViewById(R.id.tvPantalla);
        sustituirPantalla=true;
        operacionSeleccionada="";
        res=0.0;
        mem=0.0;
    }

    protected void leeNum(View view){
        TextView tecla = (TextView)findViewById(view.getId());
        if(sustituirPantalla){
            pantalla.setText("");
        }
        pantalla.append(tecla.getText());
        sustituirPantalla=false;
    }

    protected void leeOperador(View view){
        sustituirPantalla=true;
        TextView operador = (TextView)findViewById(view.getId());

        if(operador.getText().equals("+")){
            aux = valorPantalla();
            operacionSeleccionada = "suma";
        }

        if(operador.getText().equals("-")){
            aux = valorPantalla();
            operacionSeleccionada = "resta";
        }

        if(operador.getText().equals("x")){
            aux = valorPantalla();
            operacionSeleccionada = "multiplica";
        }

        if(operador.getText().equals("/")){
            aux = valorPantalla();
            operacionSeleccionada = "divide";
        }

        if(operador.getText().equals("Sen")){
            aux = valorPantalla();
            operacionSeleccionada = "seno";
            resuelve(view);
        }

        if(operador.getText().equals("Cos")){
            aux = valorPantalla();
            operacionSeleccionada = "coseno";
            resuelve(view);
        }

        if(operador.getText().equals("Tan")){
            aux = valorPantalla();
            operacionSeleccionada = "tangente";
            resuelve(view);
        }

        if(operador.getText().equals("Raiz")){
            aux = valorPantalla();
            operacionSeleccionada = "raiz";
            resuelve(view);
        }

        if(operador.getText().equals("M+")){
            mem += valorPantalla();
        }

        if(operador.getText().equals("M-")){
            mem -= valorPantalla();
        }

        if(operador.getText().equals("MR")){
            pantalla.setText(mem + "");
        }

        if(operador.getText().equals("CM")){
            mem = 0.0;
        }

        if(operador.getText().equals("CE")){
            pantalla.setText("0");
        }

        if(operador.getText().equals("DEL")){
            StringBuffer sb = new StringBuffer(pantalla.getText().toString());
            if(sb.length()>0) {
                sb.delete(sb.length() - 1, sb.length());
                pantalla.setText(sb.toString());
            }
            if(sb.length()==0){
                pantalla.setText("0");
            }
        }

        if(operador.getText().equals("C")){
            res = 0.0;
            operacionSeleccionada=null;
            pantalla.setText("0");
        }
    }

    protected double valorPantalla(){
        return Double.parseDouble(pantalla.getText().toString());
    }

    protected void resuelve(View view){

        if(operacionSeleccionada.equals("suma")){
            res = aux + valorPantalla();
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("resta")){
            res = aux - valorPantalla();
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("multiplica")){
            res = aux * valorPantalla();
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("divide")){
            if(valorPantalla()==0){
                pantalla.setText("Error");
            }else{
                res = aux / valorPantalla();
                pantalla.setText(res+"");
            }
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("seno")){
            res = Math.sin(valorPantalla());
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("coseno")){
            res = Math.cos(valorPantalla());
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("tangente")){
            res = Math.tan(valorPantalla());
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(operacionSeleccionada.equals("raiz")){
            res = Math.sqrt(valorPantalla());
            pantalla.setText(res+"");
            sustituirPantalla = true;
        }

        if(res>9999999999.0){
            pantalla.setText("Error");
            sustituirPantalla = true;
        }
    }
}
