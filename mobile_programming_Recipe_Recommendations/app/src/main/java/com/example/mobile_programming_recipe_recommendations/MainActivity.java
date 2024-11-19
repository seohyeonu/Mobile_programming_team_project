package com.example.mobile_programming_recipe_recommendations;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public class MyGridAdapter  extends BaseAdapter {
        Context context;

        Integer[] buttonID = {
                R.drawable.button_side, R.drawable.button_noodle,R.drawable.button_soup,
                R.drawable.button_snack,R.drawable.button_heart,R.drawable.button_main,
                R.drawable.button_salad,R.drawable.button_night,R.drawable.button_else
        };

        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return buttonID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200)); // 적절한 크기로 설정
            imageView.setAdjustViewBounds(true); // 이미지 크기 조정 가능
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // 이미지 중앙 맞춤
//            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(buttonID[position]);

            return imageView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final GridView gv  =(GridView) findViewById(R.id.grid);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

    }
}