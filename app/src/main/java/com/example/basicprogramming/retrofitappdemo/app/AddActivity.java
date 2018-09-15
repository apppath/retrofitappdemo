package com.example.basicprogramming.retrofitappdemo.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.basicprogramming.retrofitappdemo.R;
import com.example.basicprogramming.retrofitappdemo.apiservices.ApiServices;
import com.example.basicprogramming.retrofitappdemo.apiservices.ClientInstance;
import com.example.basicprogramming.retrofitappdemo.model.Users;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private EditText first_name_edit_text, last_name_edit_text,
            email_id_edit_text, age_edit_text;
    private MDToast mdToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        first_name_edit_text = findViewById(R.id.first_name_edit_text);
        last_name_edit_text = findViewById(R.id.last_name_edit_text);
        email_id_edit_text = findViewById(R.id.email_id_edit_text);
        age_edit_text = findViewById(R.id.age_edit_text);

        fab.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void addUsers() {

        ApiServices apiServices = ClientInstance.getRetrofitInstance().create(ApiServices.class);

        Map<String, String> map = new HashMap<>();

        String first_name = first_name_edit_text.getText().toString().trim();
        String last_name = last_name_edit_text.getText().toString().trim();
        String email_id = email_id_edit_text.getText().toString().trim();
        String user_age = age_edit_text.getText().toString().trim();

        if (first_name.isEmpty()) {
            mdToast = MDToast.makeText(AddActivity.this,
                    "first name is require",
                    MDToast.LENGTH_LONG,
                    MDToast.TYPE_INFO);
            mdToast.show();
            return;
        }

        if (last_name.isEmpty()) {
            mdToast = MDToast.makeText(AddActivity.this,
                    "last name is require",
                    MDToast.LENGTH_LONG,
                    MDToast.TYPE_INFO);
            mdToast.show();
            return;
        }

        if (email_id.isEmpty()) {
            mdToast = MDToast.makeText(AddActivity.this,
                    "email id is require",
                    MDToast.LENGTH_LONG,
                    MDToast.TYPE_INFO);
            mdToast.show();
            return;
        }

        if (user_age.isEmpty()) {
            mdToast = MDToast.makeText(AddActivity.this,
                    "age is require",
                    MDToast.LENGTH_LONG,
                    MDToast.TYPE_INFO);
            mdToast.show();
            return;
        }

        map.put("first_name", first_name);
        map.put("last_name", last_name);
        map.put("email_id", email_id);
        map.put("age", user_age);

        Call<Users> call = apiServices.createUsers(map);

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                mdToast = MDToast.makeText(AddActivity.this,
                        "User Saved Successfully Into Api",
                        MDToast.LENGTH_LONG,
                        MDToast.TYPE_INFO);
                mdToast.show();
                first_name_edit_text.setText("");
                last_name_edit_text.setText("");
                email_id_edit_text.setText("");
                age_edit_text.setText("");
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                t.printStackTrace();
                mdToast = MDToast.makeText(AddActivity.this, t.getMessage(),
                        MDToast.LENGTH_LONG,
                        MDToast.TYPE_INFO);
                mdToast.show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        addUsers();
    }
}
