package com.example.commonlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.commonlib.R;
import com.example.commonlib.utils.DensityUtil;

import java.lang.reflect.Field;

/**
 * @description: BottomNavigationBar封装实现类
 *
 * @author: Li Xiuliang
 * @date: 2020/8/14 15:38
 * @version: 1.0
 */
public class BottomNaviBar extends BottomNavigationBar {
    private Context mContext;
    private BottomNavigationItem mHomeItem;
    private BottomNavigationItem mVideoItem;
    private BottomNavigationItem mMiniVideoItem;
    private BottomNavigationItem mMyInfoItem;
    private TextBadgeItem mHomeBadge;
    private TextBadgeItem mVideoBadge;
    private TextBadgeItem mMiniVideoBadge;
    private ShapeBadgeItem mMyInfoBadge;

    public BottomNaviBar(Context context) {
        this(context, null);
    }

    public BottomNaviBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNaviBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mHomeBadge = new TextBadgeItem();
        mVideoBadge = new TextBadgeItem();
        mMiniVideoBadge = new TextBadgeItem();
        mMyInfoBadge = new ShapeBadgeItem();


        mHomeItem = new BottomNavigationItem(R.drawable.nav_item_1_selected, getResources().getString(R.string.mainpage_navi_item_homepage))
                .setInactiveIconResource(R.drawable.nav_item_1)
                .setActiveColorResource(R.color.orange)
                .setInActiveColorResource(R.color.dark_grey);
        mHomeItem.setBadgeItem(mHomeBadge);
        mHomeBadge.hide();

        mVideoItem = new BottomNavigationItem(R.drawable.nav_item_2_selected, getResources().getString(R.string.mainpage_navi_item_minivideo))
                .setInactiveIconResource(R.drawable.nav_item_2)
                .setActiveColorResource(R.color.orange)
                .setInActiveColorResource(R.color.dark_grey);
        mVideoItem.setBadgeItem(mVideoBadge);
        mVideoBadge.hide();

        mMiniVideoItem = new BottomNavigationItem(R.drawable.nav_item_3_selected, getResources().getString(R.string.mainpage_navi_item_minivideo))
                .setInactiveIconResource(R.drawable.nav_item_3)
                .setActiveColorResource(R.color.orange)
                .setInActiveColorResource(R.color.dark_grey);
        mMiniVideoItem.setBadgeItem(mMiniVideoBadge);
        mMiniVideoBadge.hide();

        mMyInfoItem = new BottomNavigationItem(R.drawable.nav_item_4_selected, getResources().getString(R.string.mainpage_navi_item_myinfo))
                .setInactiveIconResource(R.drawable.nav_item_4)
                .setActiveColorResource(R.color.orange)
                .setInActiveColorResource(R.color.dark_grey);
        mMyInfoItem.setBadgeItem(mMyInfoBadge);
        mMyInfoBadge.hide();

        setMode(BottomNavigationBar.MODE_FIXED);
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        setBarBackgroundColor(R.color.white);
        addItem(mHomeItem).addItem(mVideoItem).addItem(mMiniVideoItem).addItem(mMyInfoItem).initialise();
        setFirstSelectedPosition(0);
        setBottomNavigationItem(7, 21);
    }

    public void setItemBadge(int position, int count) {
        switch (position) {
            case 0:
                if (count > 0) {
                    mHomeBadge.setText(String.valueOf(count));
                    mHomeBadge.show();
                } else {
                    mHomeBadge.hide();
                }
                break;
            case 1:
                if (count > 0) {
                    mVideoBadge.setText(String.valueOf(count));
                    mVideoBadge.show();
                } else {
                    mVideoBadge.hide();
                }
                break;
            case 2:
                if (count > 0) {
                    mMiniVideoBadge.setText(String.valueOf(count));
                    mMiniVideoBadge.show();
                } else {
                    mMiniVideoBadge.hide();
                }
                break;
            case 3:
                if (count > 0) {
                    mMyInfoBadge.setShape(ShapeBadgeItem.SHAPE_OVAL);
                    mMyInfoBadge.setSizeInDp(mContext, 10, 10);
                    mMyInfoBadge.show();
                } else {
                    mMyInfoBadge.hide();
                }
                break;
        }

    }

    private void setBottomNavigationItem(int space, int imgLen) {
        // 反射得到 mTabContainer
        try {
            float contentLen = 36;
            Class barClass = getClass().getSuperclass();
            Field field = barClass.getDeclaredField("mTabContainer");
            if (field != null){
                field.setAccessible(true);
                LinearLayout mTabContainer = (LinearLayout) field.get(this);
                for (int j = 0; j < mTabContainer.getChildCount(); j++) {
                    //获取到容器内的各个 Tab
                    View view = mTabContainer.getChildAt(j);
                    //获取到Tab内的各个显示控件
                    // 获取到Tab内的文字控件
                    TextView labelView = (TextView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title);
                    //计算文字的高度DP值并设置，setTextSize为设置文字正方形的对角线长度，所以：文字高度（总内容高度减去间距和图片高度）*根号2即为对角线长度，此处用DP值，设置该值即可。
                    labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (float) (Math.sqrt(2) * (contentLen - imgLen - space)));
                    //获取到Tab内的图像控件
                    ImageView iconView = (ImageView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon);
                    //设置图片参数，其中，MethodUtils.dip2px()：换算dp值
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) DensityUtil.dip2px(mContext, imgLen), (int) DensityUtil.dip2px(mContext, imgLen));
                    params.gravity = Gravity.CENTER;
                    iconView.setLayoutParams(params);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
