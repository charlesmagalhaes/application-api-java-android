package com.example.myapplicationlistview;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumeAPI {

    public static List<StatesBrazil> jsonDados(String conteudo, Boolean isRegionSigla, String value ){

        try{
            List<StatesBrazil> statesBrazilList = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(conteudo);

            for (int i = 0; i<jsonArray.length();i++) {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);

                StatesBrazil statesBrazil = new StatesBrazil();

                statesBrazil.setNome(jsonObject.getString("nome"));
                statesBrazil.setSigla(jsonObject.getString("sigla"));

                if(isRegionSigla  && jsonObject.getJSONObject("regiao").getString("sigla").equals(value)){
                    statesBrazil.setSiglaRegiao(jsonObject.getJSONObject("regiao").getString("sigla"));
                    statesBrazilList.add(statesBrazil);
                }else if (!isRegionSigla){

                    statesBrazilList.add(statesBrazil);
                }



            }

            return statesBrazilList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
