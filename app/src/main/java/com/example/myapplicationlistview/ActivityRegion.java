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

public class ActivityRegion extends AppCompatActivity {

    private Button bntPesquisar;
    private ListView lista;
    private List<StatesBrazil> listRegiao = new ArrayList<>();
    private ArrayAdapter<StatesBrazil> adapter;
    private EditText txtPesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiao);
        txtPesquisar = (EditText) findViewById(R.id.txtPesquisarRegiao);
        bntPesquisar = (Button) findViewById(R.id.bntPesquisarRegiao);

        lista = findViewById(R.id.listViewRegiao);


        adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_activated_1, listRegiao);

        lista.setAdapter(adapter);


        ActivityRegion.Tasks tarefa = new ActivityRegion.Tasks();
        tarefa.execute("https://servicodados.ibge.gov.br/api/v1/localidades/regioes?orderBy=nome");

        bntPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = txtPesquisar.getText().toString();

                if (nome == null || nome.isEmpty()) {
                    adapter.addAll(listRegiao);
                    return;

                }

                List<StatesBrazil> listStatesAux = new ArrayList<>();

                for (StatesBrazil st : listRegiao) {

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
                Intent intent = new Intent(getApplicationContext(), StatesActivity.class);
                StatesBrazil obj = (StatesBrazil) lista.getAdapter().getItem(position);
                String value = obj.getSigla();
                intent.putExtra("sigla", value);
                intent.putExtra("IsSiglaRegiao","1");
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
            listRegiao = ConsumeAPI.jsonDados(s, false, null);
            adapter.addAll(listRegiao);
        }
    }


}
