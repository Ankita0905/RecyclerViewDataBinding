package com.example.recyclerviewdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.recyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding mainBinding;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapter(this,prepareUser());
        mainBinding.recyclerView.setAdapter(adapter);
    }

    private List<Users> prepareUser()
    {
        List<String> names= Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> email=Arrays.asList(getResources().getStringArray(R.array.emails));
        int[] images={R.drawable.ad,R.drawable.ae,R.drawable.af,R.drawable.ad,R.drawable.ar};

        List<Users> Names=new ArrayList<>();
        int count=0;

        for(String name:names)
        {
            Names.add(new Users(name,email.get(count),images[count]));
            count++;
        }
        return Names;

    }

}
