package br.com.gwr.constraintlayoutanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFirstAnimation(View view) {
        startActivity(new Intent(this, FirstAnimationActivity.class));
    }

    public void openSecondAnimation(View view) {
        startActivity(new Intent(this, SecondAnimationActivity.class));
    }

    public void openThirdAnimation(View view) {
        startActivity(new Intent(this, ThirdAnimationActivity.class));
    }
}
