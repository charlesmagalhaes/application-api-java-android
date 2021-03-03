package com.example.myapplicationlistview;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class Tasks extends AsyncTask<String, String, String> {

    private List<StatesBrazil> statesBrazilsList = new ArrayList<>();

    @Override
    protected String doInBackground(String... strings) {
        String retorno = Connection.getDados(strings[0]);
        return retorno;
    }

    @Override
    protected void onPostExecute(String s) {
        statesBrazilsList = ConsumeAPI.jsonDados(s, false, null);


    }

    public List<StatesBrazil> getStatesBrazilsList() {
        return statesBrazilsList;
    }
}

