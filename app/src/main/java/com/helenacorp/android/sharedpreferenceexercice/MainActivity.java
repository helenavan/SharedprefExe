package com.helenacorp.android.sharedpreferenceexercice;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public  static final String KEY_EDIT = "key";

    EditText edit1,edit2,edit3;
    Button btn;
    List<MaClasseObjectJson> maClasseO = new ArrayList<>();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit_1);
        edit2 = findViewById(R.id.edit_2);
        edit3 = findViewById(R.id.edit_3);
        btn =  findViewById(R.id.btn);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eNom = edit1.getText().toString();
                String ePrenom = edit2.getText().toString();
                String company = edit3.getText().toString();
                MaClasseObjectJson maClasseObjectJson = new MaClasseObjectJson(eNom,ePrenom,company);
                maClasseO.add(maClasseObjectJson);
                savePreferencesForImages(KEY_EDIT, maClasseO);
            }
        });
        try{
            loadPreferences();
            edit1.getText();
        }catch(Exception e){

        }

    }

    private void savePreferencesForImages(String key, List<MaClasseObjectJson> imageList)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(imageList);
        editor.putString(key,json);
        editor.apply();
    }


    //Storing Local data.
    private void loadPreferences()
    {

        Gson gson = new Gson();
        Type type = new TypeToken<List<MaClasseObjectJson>>(){}.getType();
        String gsonString = sharedPreferences.getString(KEY_EDIT , "");

        List<MaClasseObjectJson> maClasseObjectJsons = gson.fromJson(gsonString, type);
           for (MaClasseObjectJson ma: maClasseObjectJsons) {
                edit1.setText(ma.getNom());
                edit2.setText(ma.getPrenom());
                edit3.setText(ma.getCompany());
            }

       // edit1.setText(gsonString);
    }
}
