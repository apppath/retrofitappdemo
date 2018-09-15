package com.example.basicprogramming.retrofitappdemo.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.basicprogramming.retrofitappdemo.R;
import com.example.basicprogramming.retrofitappdemo.adapter.UserAdapter;
import com.example.basicprogramming.retrofitappdemo.apiservices.ApiServices;
import com.example.basicprogramming.retrofitappdemo.apiservices.ClientInstance;
import com.example.basicprogramming.retrofitappdemo.model.Users;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fab.setOnClickListener(this);
        setUserData();
    }


    public void setUserData() {

        ApiServices apiServices = ClientInstance.getRetrofitInstance().create(ApiServices.class);
        Call<List<Users>> call = apiServices.getAllUsers();

        call.enqueue(new Callback<List<Users>>() {

            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                setDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

                t.printStackTrace();
                MDToast mdToast = MDToast.makeText(MainActivity.this,
                        "Something went wrong...Please try later!",
                        MDToast.LENGTH_LONG,
                        MDToast.TYPE_INFO);
                mdToast.show();

            }
        });
    }

    public void setDataList(List<Users> dataList) {

        userAdapter = new UserAdapter(MainActivity.this, dataList);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                MDToast mdToast = MDToast.makeText(MainActivity.this,
                        "Setting menu!",
                        MDToast.LENGTH_LONG,
                        MDToast.TYPE_INFO);
                mdToast.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, AddActivity.class));
    }
}
