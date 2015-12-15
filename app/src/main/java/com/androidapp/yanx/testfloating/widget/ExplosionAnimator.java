package com.androidapp.yanx.testfloating.widget;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/**
 * com.androidapp.yanx.testfloating.widget
 * Created by yanx on 12/11/15 5:25 PM.
 * Description ${TODO}
 */
public class ExplosionAnimator extends ValueAnimator {
    public static final int DEFAULT_DURATION = 1500;
    private Particle[][] mParticles;
    private Paint mPaint;
    private View mContainer;


    public ExplosionAnimator(View view, Bitmap bitmap, Rect bound) {
        mPaint = new Paint();
        mContainer = view;
        setFloatValues(0.0f, 1.0f);
        setDuration(DEFAULT_DURATION);
        mParticles = generateParticles(bitmap, bound);
    }

    private Particle[][] generateParticles(Bitmap bitmap, Rect bound) {
        int w = bound.width();
        int h = bound.height();

        int partW_count = w / Particle.PART_W;
        int partH_count = h / Particle.PART_W;

        int bitmap_part_w = bitmap.getWidth() / partW_count;
        int bitmap_part_h = bitmap.getHeight() / partH_count;

        Particle[][] particles = new Particle[partH_count][partW_count];
        Point point = null;
        for (int row = 0; row < partH_count; row++) {
            for (int column = 0; column < partW_count; column++) {
                int color = bitmap.getPixel(column * bitmap_part_w, row * bitmap_part_h);
                point = new Point(column, row);
                particles[row][column] = Particle.generateParticle(color, bound, point);
            }
        }
        return particles;

    }


    public void draw(Canvas canvas) {
        if (!isStarted()) {
            return;
        }
        for (Particle[] particle : mParticles) {

            for (Particle p : particle) {
                p.advance((Float) getAnimatedValue());
                mPaint.setColor(p.color);
                mPaint.setAlpha((int) (Color.alpha(p.color) * p.alpha));
                canvas.drawCircle(p.cx, p.cy, p.radius, mPaint);
            }
        }
        mContainer.invalidate();
    }

    @Override
    public void start() {
        super.start();
        mContainer.invalidate();
    }
}
