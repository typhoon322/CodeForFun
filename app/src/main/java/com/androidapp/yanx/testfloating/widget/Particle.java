package com.androidapp.yanx.testfloating.widget;

import android.graphics.Point;
import android.graphics.Rect;

import java.util.Random;

/**
 * com.androidapp.yanx.testfloating.widget
 * Created by yanx on 12/11/15 4:22 PM.
 * Description ${TODO}
 */
public class Particle {
    public static final int PART_W = 8;
    static Random random = new Random();
    float cx;
    float cy;
    float radius;
    int color;
    float alpha;
    Rect bound;

    public static Particle generateParticle(int color, Rect bound, Point point) {
        int row = point.y;
        int column = point.x;

        Particle particle = new Particle();
        particle.bound = bound;
        particle.color = color;
        particle.alpha = 1f;

        particle.radius = PART_W;
        particle.cx = bound.left + PART_W * column;
        particle.cy = bound.top + PART_W * row;

        return particle;
    }

    public void advance(float factor) {
        cx = cx + factor * random.nextInt(bound.width()) * (random.nextFloat() - 0.5f);
        cy = cy + factor * random.nextInt(bound.height() / 2);
        radius = radius - factor * random.nextInt(2);
        alpha = (1f - factor) * (1 + random.nextFloat());
    }

}
