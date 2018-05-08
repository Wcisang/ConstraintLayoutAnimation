package br.com.gwr.constraintlayoutanimation;

import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class SecondAnimationActivity extends AppCompatActivity {

    ConstraintLayout root;
    ImageView javaImg;
    ImageView kotlinImg;
    ImageView selectedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_animation);
        root = findViewById(R.id.root);
        javaImg = findViewById(R.id.javaImg);
        kotlinImg = findViewById(R.id.kotlinImg);
        setupAnimations();
    }

    private void setupAnimations() {
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDefault();
            }
        });

        javaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedView != javaImg){
                    updateConstraints(R.layout.activity_second_animation_java);
                    selectedView = javaImg;
                }else
                    toDefault();
            }
        });

        kotlinImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedView != kotlinImg){
                    updateConstraints(R.layout.activity_second_animation_kotlin);
                    selectedView = kotlinImg;
                }else
                    toDefault();
            }
        });
    }

    private void toDefault() {
        if (selectedView != null) {
            updateConstraints(R.layout.activity_second_animation);
            selectedView = null;
        }
    }

    private void updateConstraints(@LayoutRes int id) {
        ConstraintSet newConstraintSet = new ConstraintSet();
        newConstraintSet.clone(this, id);
        newConstraintSet.applyTo(root);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(root);
        }
    }
}
