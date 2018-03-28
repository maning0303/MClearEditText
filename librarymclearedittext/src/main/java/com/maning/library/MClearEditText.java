package com.maning.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by maning on 16/1/22.
 * <p/>
 * 有清除功能的EditText：只有当有焦点和文本不为空的时候才显示
 */
public class MClearEditText extends EditText implements View.OnFocusChangeListener, TextWatcher {

    private Context context;
    /**
     * 画线
     */
    private Paint mPaint;
    /**
     * 右边可以清除的小图标
     */
    private Drawable mClearDrawable;
    /**
     * 右边可以清除的小图标
     */
    private Drawable mLeftDrawable;
    /**
     * 标记
     */
    private static final int DRAWABLE_LEFT = 0; //左边图标
    private static final int DRAWABLE_TOP = 1;
    private static final int DRAWABLE_RIGHT = 2;
    private static final int DRAWABLE_BOTTOM = 3;
    /**
     * 控件是否有焦点
     */
    private boolean hasFoucs = true;


    //底部线的颜色
    private int defaultBottomLineColor;
    //是否展示底部线
    private boolean showBottomLine;
    //底部线的宽度
    private float bottomLineWidth;
    //清除功能是否可用
    private boolean disableClean;
    //左边图标的大小
    private float leftDrawableSize;
    //右边图标的大小
    private float rightDrawableSize;

    public MClearEditText(Context context) {
        this(context, null);
    }

    public MClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public MClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCustomAttrs(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     */
    private void init(Context context) {
        this.context = context;

        //设置对其方式:center_vertical
        setGravity(Gravity.CENTER_VERTICAL);

        //初始化画笔等
        initDrawLine();
        //设置图标
        setDrawable();
        //设置监听
        this.setOnFocusChangeListener(this);
        this.addTextChangedListener(this);
        //默认状态
        updateDrawable(true);
    }

    /**
     * 获取自定义属性
     */
    private void initCustomAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        //获取自定义属性。
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MClearEditText, defStyleAttr, 0);
        //是否展示底部线
        showBottomLine = ta.getBoolean(R.styleable.MClearEditText_mClearEditText_showBottomLine, true);
        //底部线的颜色
        defaultBottomLineColor = ta.getColor(R.styleable.MClearEditText_mClearEditText_bottomLineColor, Color.parseColor("#666666"));
        //底部线的宽度dp
        bottomLineWidth = ta.getDimension(R.styleable.MClearEditText_mClearEditText_bottomLineWidth, dip2px(context, 1));
        //左边按钮的大小dp
        leftDrawableSize = ta.getDimension(R.styleable.MClearEditText_mClearEditText_leftDrawableSize, dip2px(context, 20));
        //清除功能是否可用
        disableClean = ta.getBoolean(R.styleable.MClearEditText_mClearEditText_disableClear, true);
        //右边按钮的大小dp
        rightDrawableSize = ta.getDimension(R.styleable.MClearEditText_mClearEditText_rightDrawableSize, dip2px(context, 20));
        ta.recycle();
    }

    private void initDrawLine() {
        //隐藏自带的线
        setBackgroundDrawable(null);
        //初始化画笔
        mPaint = new Paint();
        mPaint.setStrokeWidth(bottomLineWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showBottomLine) {
            //画线
            mPaint.setColor(defaultBottomLineColor);
            canvas.drawLine(dip2px(context, 2), this.getHeight() - 1, this.getWidth() - dip2px(context, 2),
                    this.getHeight() - 1, mPaint);
        }
    }

    private void setDrawable() {
        //获取EditText的DrawableRight,假如没有设置我们就使用默认的图片:左上右下（0123）
        mClearDrawable = getCompoundDrawables()[DRAWABLE_RIGHT];
        if (mClearDrawable == null) {
            //获取默认图标
            mClearDrawable = getResources().getDrawable(R.drawable.mn_mclearedittext_clear_icon);
        }
        mClearDrawable.setBounds(0, 0, (int) rightDrawableSize, (int) rightDrawableSize);
        //左边图标
        mLeftDrawable = getCompoundDrawables()[DRAWABLE_LEFT];
        if (mLeftDrawable != null) {
            mLeftDrawable.setBounds(0, 0, (int) leftDrawableSize, (int) leftDrawableSize);
        }
    }

    // 更新删除图片状态: 当内容不为空，而且获得焦点，才显示右侧删除按钮
    private void updateDrawable(boolean hasFocus) {
        if (length() > 0 && hasFocus) {
            if (disableClean) {
                setCompoundDrawables(mLeftDrawable, getCompoundDrawables()[DRAWABLE_TOP], mClearDrawable, getCompoundDrawables()[DRAWABLE_BOTTOM]);
            } else {
                setCompoundDrawables(mLeftDrawable, getCompoundDrawables()[DRAWABLE_TOP], null, getCompoundDrawables()[DRAWABLE_BOTTOM]);
            }
        } else {
            setCompoundDrawables(mLeftDrawable, getCompoundDrawables()[DRAWABLE_TOP], null, getCompoundDrawables()[DRAWABLE_BOTTOM]);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //可以获得上下左右四个drawable，右侧排第二。图标没有设置则为空。
        Drawable rightIcon = getCompoundDrawables()[DRAWABLE_RIGHT];
        if (rightIcon != null && event.getAction() == MotionEvent.ACTION_UP) {
            //检查点击的位置是否是右侧的删除图标
            //注意，使用getRwwX()是获取相对屏幕的位置，getX()可能获取相对父组件的位置
            int leftEdgeOfRightDrawable = getRight() - getPaddingRight()
                    - rightIcon.getBounds().width();
            if (event.getRawX() >= leftEdgeOfRightDrawable) {
                setText("");
                if (mOnClearClickListener != null) {
                    mOnClearClickListener.onClick();
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFoucs = hasFocus;
        updateDrawable(hasFoucs);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        //更新状态
        updateDrawable(true);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    @Override
    protected void finalize() throws Throwable {
        mClearDrawable = null;
        super.finalize();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    //右边按钮的点击事件
    public interface OnClearClickListener {
        void onClick();
    }

    private OnClearClickListener mOnClearClickListener;

    //设置监听
    public void setOnClearClickListener(OnClearClickListener mOnClearClickListener) {
        this.mOnClearClickListener = mOnClearClickListener;
    }


}
