package com.example.myapplicationlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StatesActivity extends AppCompatActivity {

    private Button bntPesquisar;
    private ListView lista;
    private List<StatesBrazil> listStates = new ArrayList<>();
    private ArrayAdapter<StatesBrazil> adapter;
    private EditText txtPesquisar;
    private Boolean isRegionSigla = false;
    private String value;

    private List<StatesBrazil> listStates2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados);
        txtPesquisar = (EditText) findViewById(R.id.txtPesquisarStates);
        bntPesquisar = (Button) findViewById(R.id.btnPesquisarStates);

        Bundle b = getIntent().getExtras();
        if(b!=null) {
            value = b.getString("sigla");
            String isRegion = b.getString("IsSiglaRegiao");
            if (isRegion != null) {

                isRegionSigla = true;
            }
        }
        lista = findViewById(R.id.listViewStates);


        adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_activated_1, listStates);

        lista.setAdapter(adapter);


        StatesActivity.Tasks tarefa = new StatesActivity.Tasks();
        tarefa.execute("https://servicodados.ibge.gov.br/api/v1/localidades/estados");

        bntPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = txtPesquisar.getText().toString();

                if (nome == null || nome.isEmpty()) {
                    adapter.clear();
                    StatesActivity.Tasks tarefa = new StatesActivity.Tasks();
                    tarefa.execute("https://servicodados.ibge.gov.br/api/v1/localidades/estados");
                    return;

                }

                List<StatesBrazil> listStatesAux = new ArrayList<>();

                for (StatesBrazil st : listStates) {

                    if (st.toString().contains(nome)) {
                        listStatesAux.add(st);
                    }

                }

                if (listStatesAux.size() > 0) {
                    adapter.clear();
                    adapter.addAll(listStatesAux);
                } else {
                    adapter.clear();
                }


            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ActivityCitys.class);
                StatesBrazil obj = (StatesBrazil) lista.getAdapter().getItem(position);
                String value = obj.getSigla();
                intent.putExtra("sigla", value);
                startActivity(intent);
            }
        });


    }

    public class Tasks extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Connection.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            List<StatesBrazil>  listStates = ConsumeAPI.jsonDados(s, isRegionSigla, value);
            adapter.addAll(listStates);

        }
    }


}
