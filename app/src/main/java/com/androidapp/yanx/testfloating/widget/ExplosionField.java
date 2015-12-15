package com.androidapp.yanx.testfloating.widget;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.androidapp.yanx.testfloating.utils.DeviceUtil;

import java.util.ArrayList;

/**
 * com.androidapp.yanx.testfloating.widget
 * Created by yanx on 12/11/15 4:23 PM.
 * Description ${TODO}
 */
public class ExplosionField extends View {

    private static final String TAG = "ExplosionField";
    private static final Canvas mCanvas = new Canvas();
    private ArrayList<ExplosionAnimator> explosionAnimators;
    private OnClickListener onClickListener;

    public ExplosionField(Context context) {
        super(context);
        init();
    }

    public ExplosionField(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExplosionField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Bitmap createBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap != null) {
            synchronized (mCanvas) {
                mCanvas.setBitmap(bitmap);
                view.draw(mCanvas);
                mCanvas.setBitmap(null);
            }
        }
        return bitmap;
    }


    private void init() {
        explosionAnimators = new ArrayList<>();
        attach2Activity((Activity) getContext());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (ExplosionAnimator animator : explosionAnimators) {
            animator.draw(canvas);
        }
    }

    public void explode(final View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        rect.offset(0, DeviceUtil.dp2px(25));

        final ExplosionAnimator animator = new ExplosionAnimator(this, createBitmapFromView(view), rect);
        explosionAnimators.add(animator);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                view.animate().alpha(0f).setDuration(150).start();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.animate().alpha(1f).setDuration(150).start();

                explosionAnimators.remove(animator);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }

    private void attach2Activity(Activity activity) {
        ViewGroup rootView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.addView(this, lp);
    }

    public void addListener(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                addListener(viewGroup.getChildAt(i));
            }
        } else {
            view.setClickable(true);
            if(view.hasOnClickListeners()){
                Log.i(TAG, "addListener: view.hasOnclickListener = true");
            }
            view.setOnClickListener(getOnClickListener());
        }
    }


    private OnClickListener getOnClickListener() {

         OnClickListener   onClickListener = new OnClickListener() {
                @Override
                public void onClick(View view) {
                    explode(view);
                }
            };

        return onClickListener;
    }
}
