package com.fail_x.wickedwizardingworld;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAnimations {

    public MyAnimations() {
    }

    public void ZoomAnimation(TextView textview) {
        final ObjectAnimator zoom1 = ObjectAnimator.ofFloat(textview, "scaleY", 0f, 1f);
        final ObjectAnimator zoom2 = ObjectAnimator.ofFloat(textview, "scaleX", 0f, 1f);

        AnimatorSet A_set = new AnimatorSet();
        A_set.play(zoom1).with(zoom2);
        A_set.setDuration(300);
        A_set.start();
    }

    public void ZoomAnimation(ImageView imageview) {
        imageview.setVisibility(View.VISIBLE);
        final ObjectAnimator zoom1 = ObjectAnimator.ofFloat(imageview, "scaleY", 0f, 1f);
        final ObjectAnimator zoom2 = ObjectAnimator.ofFloat(imageview, "scaleX", 0f, 1f);

        AnimatorSet A_set = new AnimatorSet();
        A_set.play(zoom1).with(zoom2);
        A_set.setDuration(300);
        A_set.start();
    }

    public void PressedAnimation(ImageView imageview) {
        final ObjectAnimator zoom1 = ObjectAnimator.ofFloat(imageview, "scaleY", 1f, 0.95f);
        final ObjectAnimator zoom2 = ObjectAnimator.ofFloat(imageview, "scaleX", 1f, 0.95f);
        final ObjectAnimator zoom3 = ObjectAnimator.ofFloat(imageview, "scaleY", 0.95f, 1f);
        final ObjectAnimator zoom4 = ObjectAnimator.ofFloat(imageview, "scaleX", 0.95f, 1f);

        AnimatorSet A_set = new AnimatorSet();
        A_set.play(zoom1).with(zoom2);
        A_set.setDuration(50);
        A_set.play(zoom3).with(zoom4);
        A_set.setDuration(50);
        A_set.start();
    }
}
