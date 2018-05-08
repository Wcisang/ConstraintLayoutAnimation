package br.com.gwr.constraintlayoutanimation;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class FirstAnimationActivity extends AppCompatActivity {

    ConstraintLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_animation);
        root = findViewById(R.id.root);
        addAnimationOperations();
    }

    private void addAnimationOperations() {
        final ConstraintSet constraint1 = new ConstraintSet();
        constraint1.clone(root);
        final ConstraintSet constraint2 = new ConstraintSet();
        constraint2.clone(this, R.layout.activity_first_animation_alt);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(root);
                    ConstraintSet constraint = constraint2;
                    constraint.applyTo(root);
                }
            }
        });
    }
}
