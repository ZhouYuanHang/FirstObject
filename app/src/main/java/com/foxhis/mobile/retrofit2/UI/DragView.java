package com.foxhis.mobile.retrofit2.UI;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.foxhis.mobile.retrofit2.R;
import com.foxhis.mobile.retrofit2.utils.ScreenUtils;

/**
 * Created by zyh on 2018/1/8.
 */

public class DragView extends View {
    private int x, y;
    private static final String TAG = "123";
    private Context mContext;
    private LinearLayout baseLayout;

    public DragView(Context context) {
        super(context);
        mContext = context;
    }

    public DragView(Context context, LinearLayout baseLayout) {
        super(context);
        mContext = context;
        this.baseLayout = baseLayout;
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DragView);
        String zyh = a.getString(R.styleable.DragView_zyh);
        Log.e(TAG, "zyh: " + zyh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth((float) 5.0);

        int screenHeight = getHeight();
        int screenWidth = getWidth();
//        int screenHeight = ScreenUtils.getScreenHeight(mContext);
//        int screenWidth = ScreenUtils.getScreenWidth(mContext);
        float[] f = new float[]{screenWidth * 1 / 4, 0, screenWidth * 1 / 4, screenHeight, screenWidth * 1 / 2, 0, screenWidth * 1 / 2, screenHeight, screenWidth * 3 / 4, 0, screenWidth * 3 / 4, screenHeight, 0, screenHeight * 1 / 6, screenWidth, screenHeight * 1 / 6, 0, screenHeight * 1 / 3, screenWidth, screenHeight * 1 / 3, 0, screenHeight * 1 / 2, screenWidth, screenHeight * 1 / 2, 0, screenHeight * 2 / 3, screenWidth, screenHeight * 2 / 3, 0, screenHeight * 5 / 6, screenWidth, screenHeight * 5 / 6};
        canvas.drawLines(f, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, (float) getWidth() / 2 - bitmap.getWidth() / 2, (float) getHeight() / 2 - bitmap.getHeight() / 2, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        Log.e("123", "X=" + x + ",Y=" + y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                bringToFront();
                baseLayout.bringChildToFront(this);
                requestLayout();
                baseLayout.invalidate();
//                baseLayout.updateViewLayout(this, getLayoutParams());
//                AnimatorSet setDown = new AnimatorSet();
//                setDown.playTogether(
//                        ObjectAnimator.ofFloat(this, "scaleX", 1f, 1.5f),
//                        ObjectAnimator.ofFloat(this, "scaleY", 1f, 1.5f),
//                        ObjectAnimator.ofFloat(this, "alpha", 1f, 0.5f)
//                );
//                setDown.start();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("123", "x=" + x + ",y=" + y + ",getLeft()=" + getLeft() + ",getTop()=" + getTop() + ",getTranslationX()=" + getTranslationX() + ",getTranslationY()=" + getTranslationY());
                setX(x + getLeft() + getTranslationX() - getWidth() / 2);
                setY(y + getTop() + getTranslationY() - getHeight() / 2);
                break;
            case MotionEvent.ACTION_UP:
//                AnimatorSet setUp = new AnimatorSet();
//                setUp.playTogether(
//                        ObjectAnimator.ofFloat(this, "scaleX", 1.5f, 1f),
//                        ObjectAnimator.ofFloat(this, "scaleY", 1.5f, 1f),
//                        ObjectAnimator.ofFloat(this, "alpha", 0.5f, 1f)
//                );
//                setUp.start();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}
