package com.bellxu.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView testImage;
    private Button test_button;
    private Button test_button2;
    private RelativeLayout root;
    private ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testImage = (ImageView) findViewById(R.id.test_image);
        root = (RelativeLayout) findViewById(R.id.root);
        test_button = (Button) findViewById(R.id.test_button);
        test_button2 = (Button) findViewById(R.id.test_button2);
        test_button.setOnClickListener(this);
        test_button2.setOnClickListener(this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testImage.setVisibility(View.GONE);
            }
        },2000);



        scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f);
        //动画持续时间
        scaleAnimation.setDuration(5000);
        //如果设置为true，控件动画结束时，将保持动画最后时的状态
        scaleAnimation.setFillAfter(true);
//        //如果设置为true,控件动画结束时，还原到开始动画前的状态
//        scaleAnimation.setFillBefore(false);
        //重复次数
//        scaleAnimation.setRepeatCount(2);
        root.startAnimation(scaleAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_button:
                if (testImage.getVisibility()==View.VISIBLE){
                    testImage.setVisibility(View.GONE);
                }else {
                    testImage.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.test_button2:
                Intent intent =new Intent(MainActivity.this,ViewPageActivity.class);
                startActivity(intent);

                break;
        }
    }
}
