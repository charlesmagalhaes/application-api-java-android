package com.example.myapplicationlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityCitys extends AppCompatActivity {


    private Button btnPesquisar3;
    private EditText txtPesquisar3;
    private  String value;
    private ListView lista3;
    private List<CitysBrazil> listCitys = new ArrayList<>();
    private ArrayAdapter<CitysBrazil> adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citys);
        btnPesquisar3 = (Button) findViewById(R.id.bntPesquisar3);
        txtPesquisar3 = (EditText) findViewById(R.id.txtPesquisar3);

        lista3 = findViewById(R.id.listViewCitys);

        Bundle b = getIntent().getExtras();
        value = b.getString("sigla");

        //CustomAdapter customAdapter = new CustomAdapter(this, listStates);
        //lista.setAdapter(customAdapter);

        adapter3 = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_activated_1, listCitys);

        lista3.setAdapter(adapter3);

        String pesquisa = txtPesquisar3.getText().toString();

        ActivityCitys.Tasks3 tarefa = new ActivityCitys.Tasks3();
        tarefa.execute("https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+value+"/municipios");

        btnPesquisar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome =txtPesquisar3.getText().toString();

                if(nome ==null ||nome.isEmpty()){
                    adapter3.addAll(listCitys);

                }

                List<CitysBrazil> listCitysAux = new ArrayList<>();

                for (CitysBrazil st: listCitys){

                    if (st.toString().contains(nome)) {
                        listCitysAux.add(st);
                    }

                }

                if(listCitysAux.size()>0) {
                    adapter3.clear();
                    adapter3.addAll(listCitysAux);
                }else{
                    adapter3.clear();
                }


            }
        });

    }

    public class Tasks3 extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Connection.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            listCitys = ConsumeAPICitys.jsonDados(s);
            adapter3.addAll(listCitys);
        }
    }



}




