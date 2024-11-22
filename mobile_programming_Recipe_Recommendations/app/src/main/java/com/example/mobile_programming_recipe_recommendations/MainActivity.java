package com.example.mobile_programming_recipe_recommendations;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        Integer[] frontImages = {
                R.drawable.button_side, R.drawable.button_noodle, R.drawable.button_soup,
                R.drawable.button_snack, R.drawable.button_heart, R.drawable.button_main,
                R.drawable.button_salad, R.drawable.button_night, R.drawable.button_else
        };

        String[] backTexts = {
                "사이드 메뉴", "국수", "스프",
                "간식", "하트", "메인 요리",
                "샐러드", "야식", "기타"
        };

        public MyGridAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return frontImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View gridItemView = View.inflate(context, R.layout.grid_item, null);

            // 앞면과 뒷면 초기화
            ImageView frontImage = gridItemView.findViewById(R.id.front_image);
            TextView backText = gridItemView.findViewById(R.id.back_text);

            // 앞면 이미지와 뒷면 텍스트 설정
            frontImage.setImageResource(frontImages[position]);
            backText.setText(backTexts[position]);

            // GridView의 각 아이템 크기 설정
            gridItemView.setLayoutParams(new GridView.LayoutParams(200, 200)); // Image 크기와 동일

            // 클릭 시 카드 뒤집기
            gridItemView.setOnClickListener(v -> flipCard(frontImage, backText));

            return gridItemView;
        }


        // 카드 뒤집기 애니메이션
        private void flipCard(ImageView frontImage, TextView backText) {
            AnimatorSet frontAnim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.flip_front);
            AnimatorSet backAnim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.flip_back);

            if (frontImage.getVisibility() == View.VISIBLE) {
                frontAnim.setTarget(frontImage);
                backAnim.setTarget(backText);

                frontAnim.start();
                backAnim.start();

                frontImage.setVisibility(View.INVISIBLE);
                backText.setVisibility(View.VISIBLE);
            } else {
                backAnim.setTarget(frontImage);
                frontAnim.setTarget(backText);

                backAnim.start();
                frontAnim.start();

                backText.setVisibility(View.INVISIBLE);
                frontImage.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = findViewById(R.id.grid);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
}
