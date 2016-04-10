package fabmotiontest.com.fabtest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by WingHinChan on 2016/04/10.
 */
public class FloatingActionButtonBehavior extends CoordinatorLayout.Behavior<TextView> {

    public FloatingActionButtonBehavior(Context context, AttributeSet attrs) {
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {

        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}