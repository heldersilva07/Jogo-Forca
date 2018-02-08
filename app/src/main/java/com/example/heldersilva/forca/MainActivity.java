package com.example.heldersilva.forca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected Button btnJogar;
    protected Button btnReiniciar;
    protected TextView lblVidas;
    protected TextView lblletrasUsadas;
    protected TextView lblPalavraEscolhida;
    protected EditText txtInserir;
    protected TextView txtGanhou;
    protected TextView txtPerdeu;
    protected String palavra;
    protected int numeroVidas = 6;
    protected char traco = '_';
    protected List<String> list = new ArrayList<String>();
    protected char[] palavr;
    protected char[] letras;
    protected List<String> listaPalavrasUtilizadas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar =(Button)findViewById(R.id.btnJogar);
        lblVidas = (TextView) findViewById(R.id.lblVidas);
        lblletrasUsadas = (TextView) findViewById(R.id.lblLetrasUsadas);
        lblPalavraEscolhida = (TextView) findViewById(R.id.lblPalavraEscolhida);
        txtInserir = (EditText) findViewById(R.id.txtInserir);
        btnReiniciar =(Button) findViewById(R.id.btnReiniciar);
        txtGanhou = (TextView) findViewById(R.id.txtGanhou);
        txtPerdeu = (TextView) findViewById(R.id.txtPerdeu);

        btnReiniciar.setVisibility(View.INVISIBLE);
        txtPerdeu.setVisibility(View.INVISIBLE);
        txtGanhou.setVisibility(View.INVISIBLE);
        palavra = this.GetList();
        lblVidas.setText(String.valueOf(numeroVidas));
        lblPalavraEscolhida.setText(palavra.replaceAll("[^0-9.]", "_").replace("", " ").trim());
        palavr = palavra.toCharArray();
        letras = new char[palavra.length()];
        java.util.Arrays.fill(letras,'_');

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = txtInserir.getText().toString();
                String TextoFinal = "";
                boolean existe = false;

                for (int i = 0; i < palavr.length; i++) {
                    if (texto.charAt(0) == palavr[i]) {

                        letras[i] = texto.charAt(0);
                        existe = true;
                    }
                }

                if (existe) {
                    TextoFinal = new String(letras);
                    lblPalavraEscolhida.setText(TextoFinal.replace("", " ").trim());
                }else
                {
                   numeroVidas -= 1;
                    listaPalavrasUtilizadas.add(texto);
                    String s = TextUtils.join(",", listaPalavrasUtilizadas);
                    lblletrasUsadas.setText(s);
                }

                lblVidas.setText(String.valueOf(numeroVidas));

                if (numeroVidas == 0)
                {
                    txtPerdeu.setVisibility(View.VISIBLE);
                    btnJogar.setVisibility(View.INVISIBLE);
                    btnReiniciar.setVisibility(View.VISIBLE);
                }else if( TextoFinal.equals(palavra))
                {
                    txtGanhou.setVisibility(View.VISIBLE);
                    btnJogar.setVisibility(View.INVISIBLE);
                    btnReiniciar.setVisibility(View.VISIBLE);
                }

                txtInserir.setText("");
            }

        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }

        });

    }

    private String GetList()
    {
        list.add("ola");
        list.add("bom");
        list.add("fim");
        list.add("dia");
        list.add("carro");
        list.add("rato");
        list.add("teclado");
        list.add("memorias");
        list.add("processador");
        list.add("discos");
        list.add("adeus");
        list.add("felicidade");
        list.add("liberdade");
        list.add("reciprocidade");
        list.add("risos");
        list.add("sentir");
        list.add("singularidades");
        list.add("caminhos");
        list.add("esperança");
        list.add("infinito");
        list.add("melancolia");
        list.add("Respeito");
        list.add("saudade");
        list.add("sublime");
        list.add("vida");
        list.add("guimaraes");
        list.add("porto");
        list.add("maia");
        list.add("trofa");
        list.add("torcato");
        Random rand = new Random();
        String random = list.get(rand.nextInt(list.size()));

        return random;
    }
}
