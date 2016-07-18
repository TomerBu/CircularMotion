package tomerbu.edu.simpletransitiondemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.Transition;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupArcMotion();

        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupArcMotion() {
        //Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.arcit);  //Same as in code.
        Transition transition = getTransition();

        //getWindow().setSharedElementReturnTransition(transition);
        getWindow().setSharedElementEnterTransition(transition);
        //getWindow().setSharedElementExitTransition(transition);
        //getWindow().setSharedElementReenterTransition(transition);
    }

    @NonNull
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Transition getTransition() {
        Transition transition1 = new ChangeBounds();
        ArcMotion arc = new ArcMotion();
        //These parameters are quite meaningless
        arc.setMinimumHorizontalAngle(15f);
        arc.setMinimumVerticalAngle(0f);
        arc.setMaximumAngle(90f);
        transition1.setPathMotion(arc);
        return transition1;
    }
}
