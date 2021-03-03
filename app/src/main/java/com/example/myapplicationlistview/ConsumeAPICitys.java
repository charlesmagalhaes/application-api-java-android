package com.example.myapplicationlistview;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumeAPICitys {
    public static List<CitysBrazil> jsonDados(String conteudo){

        try{
            List<CitysBrazil> citysBrazilList = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(conteudo);

            for (int i = 0; i<jsonArray.length();i++) {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);

                CitysBrazil citysBrazil = new CitysBrazil();

                citysBrazil.setNome(jsonObject.getString("nome"));

                citysBrazilList.add(citysBrazil);

            }

            return citysBrazilList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }


}
