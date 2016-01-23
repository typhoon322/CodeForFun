package com.androidapp.yanx.testfloating.verticalpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;


/**
 * Created by landsnail on 14-9-30.
 *
 * @author hongyun.fang
 * @email  fanghongyun@gmail.com
 */
public class VerticalScrollView extends ScrollView {

    public interface OnScroll {
        public void onScrollChanged(VerticalScrollView scrollView, int x, int y, int oldx, int oldy);
    }

    private OnScroll onScroll;

    public VerticalScrollView(Context context) {
        super(context);
    }

    public VerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalScrollView(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
    }

    public void setOnScroll(OnScroll onScroll) {
        this.onScroll = onScroll;
    }

    float mLastMotionX = 0;
	float mLastMotionY = 0;


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

//        getParent().requestDisallowInterceptTouchEvent(false);

        final float x = ((MotionEvent) event).getX();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionX = x;
    			mLastMotionY = event.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_MOVE: {

                if ((getChildAt(0).getMeasuredHeight() <= (getScrollY() + getHeight()))) {
//                    Log.i("msg", "offset---------" + getParent().toString());
                    getParent().requestDisallowInterceptTouchEvent(false);
                    //获得 VerticalViewPager 的实例
                    ((View) getParent()).onTouchEvent(event);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }

                float direction = mLastMotionY - event.getY();
    			mLastMotionY = event.getY();
    			if (getScrollY() <= 0 && direction < -5) {
    				getParent().requestDisallowInterceptTouchEvent(false);
    				((View) getParent().getParent()).onTouchEvent(event);
    			} else {
    				getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
    			}
            }
            break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }

        try {
            return super.dispatchTouchEvent(event);
        }catch (Exception ex){
        	ex.printStackTrace();
//            Log.d("dispatchTouchEvent Exception:", ex.getLocalizedMessage());
            return false;
        }

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (onScroll != null) {
            onScroll.onScrollChanged(this, l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
