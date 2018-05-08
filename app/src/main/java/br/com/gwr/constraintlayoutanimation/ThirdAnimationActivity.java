package br.com.gwr.constraintlayoutanimation;

import android.support.annotation.LayoutRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class ThirdAnimationActivity extends AppCompatActivity {

    ConstraintLayout shoppingRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_animation);
        shoppingRoot = findViewById(R.id.shoppingRoot);
        setupAnimations();
    }

    private void setupAnimations() {
        findViewById(R.id.askSize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateConstraints(R.layout.activity_third_animation_alt);
                ((Button) findViewById(R.id.askSize)).setText("ADD TO CART - 1234 INR");
            }
        });

        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateConstraints(R.layout.activity_third_animation);
                ((Button) findViewById(R.id.askSize)).setText("SELECT SIZE");
            }
        });
    }

    private void updateConstraints(@LayoutRes int id) {
        ConstraintSet newConstraintSet = new ConstraintSet();
        newConstraintSet.clone(this, id);
        newConstraintSet.applyTo(shoppingRoot);
        ChangeBounds transition = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            transition = new ChangeBounds();
            transition.setInterpolator(new OvershootInterpolator());
            TransitionManager.beginDelayedTransition(shoppingRoot, transition);
        }

    }
}
