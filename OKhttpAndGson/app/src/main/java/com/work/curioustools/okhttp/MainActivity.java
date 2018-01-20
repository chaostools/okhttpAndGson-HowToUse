package com.work.curioustools.okhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button btGo;
    EditText etUrl;
    TextView tvScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGo = findViewById(R.id.bt_downnload);
        etUrl = findViewById(R.id.et_url);
        tvScreen = findViewById(R.id.textView);
        etUrl.setText("http://pokeapi.co/api/v2/pokemon/1/");
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadAndDisplayJson();
            }
        });

        funwithGson();


    }



    private void downloadAndDisplayJson() {
        String url=etUrl.getText().toString();
        new async().execute(url);



    }

    public class async extends AsyncTask<String, Void, String > {

        @Override
        protected String doInBackground(String... myurl) {
            final String[] recievedData = {"no data"};
            final OkHttpClient client = new OkHttpClient();
            final Request req = new Request.Builder().url(myurl[0]).build();


            try {
                Log.e(">>>>>>>>", "downloadAndDisplayJson: try block running");
                Response returnedResponse = client.newCall(req).execute();
                recievedData[0] = returnedResponse.body().string();
                Log.e(">>>>>>>", "downloadAndDisplayJson:returned data=" + recievedData[0]);



            } catch (IOException e) {
                e.printStackTrace();
                recievedData[0] = "ERROR";
                Log.e(">>>>>>>>>>>>", "downloadAndDisplayJson: ERROR OCCURED,RUNNING CATCH BLOCK" + e.getMessage());

            }
            return recievedData[0];
        }

        @Override
        protected void onPostExecute(String recievedData) {
            super.onPostExecute(recievedData);
            afterLoadingDataChanges(recievedData);
        }
    }

    private void afterLoadingDataChanges(String recievedData) {
        tvScreen.setText(recievedData);

    }

    private void funwithGson() {

            /*Student class is a perfect eg for serialisation and deserialistation which can help
            understad you following things / clear the following doubts:*/
           /*  -how Gson Works*///: Gson is nothing but a direct java to json and vice versa translattor
//              so you don't need to write jsonString.getString("blah blah",default value). it does
//              not need a searching for that perticular String name  and it automatically gives a
//              defult value of 0/false/null while serialising/ deserialising
           /*  -how to create a pojo(plain Old Java class's Object)*/// :java follows camelCase notation:
//               no spaces,every space is replaced by a capital starting ofNextLetter <-- Like this.
//               while JSON uses snake_case very strictly:no spaces,no capitals,spaces replaced_by '_'
//               ,like_this.And both type casses are needed to be respected with reference to
//               language(a json having any object with even a single capital letter is a straight
//               Compile time ERROR!!) . So Gson has come up with a possible solution of
//               @SerialisedName("json_styled_name") annotation which can handle serialising and
//               deserialising perfectly , according to the language.
           /*  -Structure of a JSON's POJO*///:private variables allowed, all classes needs to have an
//               empty constructor,it is better if parent class's empty constructor has a new object()
//               for child class,only primitives allowed,For collection,only List<ObjDataType> allowed,
//               child classes should be public
//



        Student.ClassDetails details=  new Student().new ClassDetails("2nd","CSE", Arrays.asList("ds", "java"));
        Student.Acadamics acadmics =new Student().new Acadamics("98%",true);

        Student ansh=new Student("ansh",19,"41325501716",details,acadmics);
        Log.e(">>>>>>>", "Object: "+ansh );

        //serialisation:converting java object to json string
        String jsonObjAnsh= (new Gson()).toJson(ansh);
        Log.e(">>>>>>>", "JSOM string: "+jsonObjAnsh);

        //deserialisation:converting json string to javaObject
        Student ansh_desrialised=(new Gson()).fromJson(jsonObjAnsh,Student.class);
        Log.e(">>>>>>>", "Object From Json: "+ansh_desrialised);





    }
}
