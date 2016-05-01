package com.woyeyo.woyeyo.ui.CustomUi;

/**
 * Created by fam_000 on 2016/5/1.
 */

        import android.animation.ValueAnimator;
        import android.content.Context;
        import android.content.res.TypedArray;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.RectF;
        import android.util.AttributeSet;
        import android.util.Log;
        import android.view.Display;
        import android.view.View;
        import android.view.WindowManager;
        import android.view.animation.LinearInterpolator;

        import com.woyeyo.woyeyo.R;


public class CustomCircle extends View {

    private Context mContext;
    private Paint circlePaint;
    private Paint textPaint;
    private Paint arcPaint;
    private float progress;
    private float PADDING;
    private RectF rectF;
    private String strs = "总收益\n0.0元";
    private int mTextSize;
    private int mFirstCircleColor;
    private int mSecondtCircleColor;
    private int mCircleTextColor;
    private int mCircleWidth;
    private int mCircleTextSize;
    private int mCircleProgress;
    private int mCirclePandding;
    private int mTextColor;
    private int mStrockWidth;
    private int secondColor;
    private int firstColor;
    private long DURATION = 1;


    public CustomCircle(Context context) {
        super(context);
    }

    public CustomCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public CustomCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }


    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        initAttributes(attrs);

        //圆的画笔
        circlePaint = new Paint();
        circlePaint.setColor(secondColor);
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeJoin(Paint.Join.ROUND);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        circlePaint.setStrokeWidth(mStrockWidth);

        //文字画笔
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(mTextColor);
        textPaint.setTextSize(mTextSize);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);//基点在文字中间

        //弧形画笔
        arcPaint = new Paint();
        arcPaint.setAntiAlias(true);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.SQUARE);
        arcPaint.setStrokeJoin(Paint.Join.ROUND);
        arcPaint.setStrokeWidth(mStrockWidth);
        arcPaint.setColor(firstColor);

    }

    //自定义属性
    private void initAttributes(AttributeSet attributeSet) {
        TypedArray ta = mContext.obtainStyledAttributes(attributeSet, R.styleable.CustomCircle);
        mFirstCircleColor = ta.getColor(R.styleable.CustomCircle_firstCircleColor, Color.BLUE);
        mSecondtCircleColor = ta.getColor(R.styleable.CustomCircle_secondCircleColor, Color.parseColor("#e0e0e0"));
        mCircleTextColor = ta.getColor(R.styleable.CustomCircle_circleTextColor, Color.BLUE);
        mCircleWidth = (int) ta.getDimension(R.styleable.CustomCircle_circleWidth, 48);
        mCircleTextSize = (int) ta.getDimension(R.styleable.CustomCircle_circleTextSize, 78);
        mCircleProgress = (int) ta.getDimension(R.styleable.CustomCircle_circleProgress, 0);
        mCirclePandding = (int) ta.getDimension(R.styleable.CustomCircle_circlePandding, 48);
        ta.recycle();//获取完自定义属性之后，回收资源

        firstColor = mFirstCircleColor;
        mStrockWidth = mCircleWidth;
        secondColor = mSecondtCircleColor;
        mTextColor = mCircleTextColor;
        mTextSize = mCircleTextSize;
        progress = mCircleProgress;
        PADDING = mCirclePandding;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circleHeight = getMeasuredHeight();//获取测量的高度
        int circleWidth = getMeasuredWidth();//获取测量的宽度

        //获取屏幕的宽高
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        int screenWidth = defaultDisplay.getWidth();
        int screenHeight = defaultDisplay.getHeight();

        //绘制圆形
        canvas.drawCircle(circleWidth / 2, circleHeight / 2, circleWidth / 2 - PADDING, circlePaint);

        //绘制文字
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离
        int baseLineY = (int) (circleHeight / 2 - top / 2 - bottom / 2);//基线中间点的y轴计算公式
        canvas.drawText(strs, circleWidth / 2, baseLineY, textPaint);

        //绘制弧形
        rectF = new RectF(PADDING, PADDING, (float) circleWidth - PADDING, (float) circleHeight - PADDING);
        canvas.drawArc(rectF, -270f, progress, false, arcPaint);

    }

    //-------------------------------------------暴露在外面的方法---------------------------------------------------

    //设置文字字体大小
    protected void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    //设置文字的颜色
    protected void setTextColor(int color) {
        mTextColor = color;
    }

    //设置自定义CircleView的进度条宽度
    protected void setStrockWidth(int width) {
        mStrockWidth = width;
    }

    //设置属性动画执行的时间
    protected void setDuration(long duration) {
        DURATION = duration;
    }

    //设置进度
    public void setMoney(final float now, final float future) {

        float mProgress=now/(now+future)*100;
        ValueAnimator animator = ValueAnimator.ofFloat(0, (float) (mProgress * 3.6));
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(DURATION);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                progress = animatedValue;
//                float moneyNum=(float) (animatedValue / 360f * 100);
//                moneyNum   =  (float)(Math.round(moneyNum*100))/100;
                strs = "总收益\n"+String.valueOf(now+future)+"元";
                Log.d("animator", String.valueOf(animatedValue));
                invalidate();
            }
        });
    }
}
