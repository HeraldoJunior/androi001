package com.example.generalojogo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekDados;
    private TextView quantidadeDados;
    private TextView possibilidades;
    private ArrayList<Dado> listDados;
    private Random random;
    private Button fazerTentativa;
    private TextView dados;
    private CheckBox pTentativa;
    public int finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekDados = findViewById(R.id.seekDados);
        quantidadeDados = findViewById(R.id.quantidadeDados);

        possibilidades = findViewById(R.id.possibilidades);

        fazerTentativa = findViewById(R.id.fazerTentativa);

        dados = findViewById(R.id.dados);

        pTentativa = findViewById(R.id.pTentativa);

        listDados = new ArrayList<Dado>();

        random = new Random();

        seekDados.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantidadeDados.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                /*for (int i = 0;i < seekBar.getProgress();i++){
                    listDados.add(new Dado(seekFaces.getProgress()));
                }

                for (Dado d: listDados) {
                    Random random = new Random();
                    d.setFaces(random.nextInt(d.getFaces()));
                    finalResult += d.getFaces();
                }*/
            }
        });

        pTentativa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    seekDados.setProgress(5);
                }
            }
        });

        fazerTentativa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dados.setText("");
                possibilidades.setText("");
                ArrayList<Integer> jogadas1 = new ArrayList<Integer>();
                ArrayList<Integer> jogadas2 = new ArrayList<Integer>();
                ArrayList<Integer> jogadas3 = new ArrayList<Integer>();
                ArrayList<Integer> jogadas4 = new ArrayList<Integer>();
                ArrayList<Integer> jogadas5 = new ArrayList<Integer>();
                ArrayList<Integer> jogadas6 = new ArrayList<Integer>();

                for (int i = 0;i < seekDados.getProgress();i++){
                    listDados.add(new Dado(6));
                }

                for (final Dado d: listDados) {
                    int rdm = random.nextInt(d.getFaces() + 1);
                    if (rdm == 0) rdm += 1;
                    d.setFaces(rdm);
                    finalResult += d.getFaces();

                    dados.append(String.format("Dado " + (listDados.indexOf(d) + 1) + ": " + d.getFaces()) + "\n");

                    switch (d.getFaces()){
                        case 1:
                            jogadas1.add(d.getFaces());
                            break;
                        case 2:
                            jogadas2.add(d.getFaces());
                            break;
                        case 3:
                            jogadas3.add(d.getFaces());
                            break;
                        case 4:
                            jogadas4.add(d.getFaces());
                            break;
                        case 5:
                            jogadas5.add(d.getFaces());
                            break;
                        case 6:
                            jogadas6.add(d.getFaces());
                            break;
                    }
                }

                if(!jogadas1.isEmpty()){
                    int soma = 0;
                    for (int i = 0;i < jogadas1.size();i++){
                        soma += jogadas1.get(i);
                    }
                    possibilidades.append("Jogada de 1: " + soma + " pontos\n");
                }
                if(!jogadas2.isEmpty()){
                    int soma = 0;
                    for (int i = 0;i < jogadas2.size();i++){
                        soma += jogadas2.get(i);
                    }
                    possibilidades.append("Jogada de 2: " + soma + " pontos\n");
                }
                if(!jogadas3.isEmpty()){
                    int soma = 0;
                    for (int i = 0;i < jogadas3.size();i++){
                        soma += jogadas3.get(i);
                    }
                    possibilidades.append("Jogada de 3: " + soma + " pontos\n");
                }
                if(!jogadas4.isEmpty()){
                    int soma = 0;
                    for (int i = 0;i < jogadas4.size();i++){
                        soma += jogadas4.get(i);
                    }
                    possibilidades.append("Jogada de 4: " + soma + " pontos\n");
                }
                if(!jogadas5.isEmpty()){
                    int soma = 0;
                    for (int i = 0;i < jogadas5.size();i++){
                        soma += jogadas5.get(i);
                    }
                    possibilidades.append("Jogada de 5: " + soma + " pontos\n");
                }
                if(!jogadas6.isEmpty()){
                    int soma = 0;
                    for (int i = 0;i < jogadas6.size();i++){
                        soma += jogadas6.get(i);
                    }
                    possibilidades.append("Jogada de 6: " + soma + " pontos\n");
                }

                if(jogadas1.size() == 3
                        || jogadas2.size() == 3
                        || jogadas3.size() == 3
                        || jogadas4.size() == 3
                        || jogadas5.size() == 3
                        || jogadas6.size() == 3
                ){
                    possibilidades.setText("Temos uma TRINCA!");
                }

                if(jogadas1.size() == 4
                        || jogadas2.size() == 4
                        || jogadas3.size() == 4
                        || jogadas4.size() == 4
                        || jogadas5.size() == 4
                        || jogadas6.size() == 4
                ){
                    possibilidades.setText("Temos uma QUADRA!");
                }

                if(seekDados.getProgress() == 5){
                    if(jogadas1.size() == 2
                            || jogadas2.size() == 2
                            || jogadas3.size() == 2
                            || jogadas4.size() == 2
                            || jogadas5.size() == 2
                            || jogadas6.size() == 2
                    ){
                        if(jogadas1.size() == 3
                                || jogadas2.size() == 3
                                || jogadas3.size() == 3
                                || jogadas4.size() == 3
                                || jogadas5.size() == 3
                                || jogadas6.size() == 3
                        ){
                            possibilidades.setText("Temos um FULL-HAND!");
                        }
                    }
                }

                listDados.clear();
                jogadas1.clear();
                jogadas2.clear();
                jogadas3.clear();
                jogadas4.clear();
                jogadas5.clear();
                jogadas6.clear();

                /*String string = String.valueOf("Resultado para a sua jogada: " + finalResult);
                possibilidades.setText(string);
                listDados.clear();
                finalResult = 0;*/
            }
        });
    }
}
