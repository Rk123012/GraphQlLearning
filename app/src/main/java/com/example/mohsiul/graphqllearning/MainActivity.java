package com.example.mohsiul.graphqllearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

public class MainActivity extends AppCompatActivity {
    public final String TAG="MainActivity";
    private EditText Edemail, Edpassword;
    private Button btnLogin;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edemail=findViewById(R.id.email);
        Edpassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        textView=findViewById(R.id.textView);
        btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                MyApolloClient.getMyApolloClient().query(
                        QueryLoginNewQuery.builder().email(Edemail.getText().toString()).password(Edpassword.getText().toString()).build()
                ).enqueue(new ApolloCall.Callback<QueryLoginNewQuery.Data>() {
                    @Override
                    public void onResponse(@Nonnull final Response<QueryLoginNewQuery.Data> response) {
                        Log.d(TAG, "onResponse: flsajl");
                        Log.e(TAG, "onResponse: " + response.data().login().loginKey.toString());






                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {

                       Log.d(TAG, "onFailure: "+e.getMessage());


                    }
                });

            }
        });



    }
}
