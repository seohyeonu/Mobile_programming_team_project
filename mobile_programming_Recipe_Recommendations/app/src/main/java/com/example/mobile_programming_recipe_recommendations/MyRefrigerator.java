package com.example.mobile_programming_recipe_recommendations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MyRefrigerator extends AppCompatActivity {
    ImageButton button_goto_addLayout;
    ArrayList<String> midList;
    ListView list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.my_refrigerator);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        button_goto_addLayout = (ImageButton)findViewById(R.id.goto_addLayout);
        button_goto_addLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_addLayout = new Intent(MyRefrigerator.this, AddIngredients.class);
                startActivityForResult(goto_addLayout, 1);
            }
        });

        midList = new ArrayList<String>();
        list = (ListView)findViewById(R.id.listItem);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);

        list.setAdapter(adapter);
        //__________________________________________________________________________________
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_refrigerator), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            int selectedNumber = data.getIntExtra("SelectedNumber", -1);
            String selectedDate = data.getStringExtra("SelectedDate");
            if (selectedNumber == 0){
                midList.add("사과 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 1){
                midList.add("미역 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 2){
                midList.add("양배추 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 3){
                midList.add("마요네즈 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 4){
                midList.add("우유 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 5){
                midList.add("느타리버섯 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 6){
                midList.add("완두콩 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 7){
                midList.add("시금치 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }
            else if (selectedNumber == 8){
                midList.add("고구마 [" + selectedDate + "]");
                adapter.notifyDataSetChanged();
            }

        }
    }
}