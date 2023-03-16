package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<UserModal> arrayList;
 RecyclerView recyclerView;
    UserRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    recyclerView=findViewById(R.id.recylerViewMian);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiControler.getInstance().getapi().UserData().enqueue(new Callback<List<UserModal>>() {
            @Override
            public void onResponse(Call<List<UserModal>> call, Response<List<UserModal>> response) {
                Log.e("api","everthing right");
                arrayList=response.body();
                adapter=new UserRecyclerAdapter(MainActivity.this,arrayList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<UserModal>> call, Throwable t) {
                Log.e("api","something went wrong");
            }
        });

    }
}