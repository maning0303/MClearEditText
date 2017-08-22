# MClearEditText--带有删除功能的EditText（Android Studio）[![](https://jitpack.io/v/maning0303/MClearEditText.svg)](https://jitpack.io/#maning0303/MClearEditText)
    带有删除功能的EditText

## 屏幕截图
![](https://github.com/maning0303/MClearEditText/raw/master/screenshots/mn_clear_edittext_screenshot_001.png)
![](https://github.com/maning0303/MClearEditText/raw/master/screenshots/mn_clear_edittext_screenshot_002.png)


## 如何添加
### 1:Gradle添加：
#### 1.在Project的build.gradle中添加仓库地址

``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### 2.在app目录下的build.gradle中添加依赖
``` gradle
	dependencies {
	     compile 'com.github.maning0303:MClearEditText:V1.1.0'
	}
```

### 2:源码Model添加：
#### 直接关联librarymclearedittext

``` gradle
	compile project(':librarymclearedittext')

```

## 代码使用:
### 1:自定义属性介绍:

``` java

    <declare-styleable name="MClearEditText">
        <!--是否展示底部线 : 默认显示 -->
        <attr name="mClearEditText_showBottomLine" format="boolean"/>
        <!--底部线的颜色-->
        <attr name="mClearEditText_bottomLineColor" format="color"/>
        <!--底部线的宽度-->
        <attr name="mClearEditText_bottomLineWidth" format="dimension"/>
        <!-- 左边图片的大小 -->
        <attr name="mClearEditText_leftDrawableSize" format="dimension"/>
        <!-- 是否显示右边删除按钮 :默认显示-->
        <attr name="mClearEditText_disableClear" format="boolean"/>
        <!-- 右边图片的大小 -->
        <attr name="mClearEditText_rightDrawableSize" format="dimension"/>
    </declare-styleable>

```


### 2:xml中使用:
``` java

     <com.maning.library.MClearEditText
         android:id="@+id/mClearEditText"
         android:layout_width="match_parent"
         android:layout_height="40dp"
         android:drawableLeft="@drawable/icon_user"
         android:drawablePadding="6dp"
         android:focusable="true"
         android:gravity="center_vertical"
         android:hint="默认显示"
         android:textSize="14sp"
         app:mClearEditText_bottomLineColor="@color/colorAccent"
         app:mClearEditText_disableClear="false"
         app:mClearEditText_rightDrawableSize="20dp"
         app:mClearEditText_bottomLineWidth="1dp"
         />

```

### 3:代码设置-监听清除按钮的事件:
``` java

      mClearEditText.setOnClearClickListener(new MClearEditText.OnClearClickListener() {
          @Override
          public void onClick() {
              Toast.makeText(mContext, "点击了清除按钮", Toast.LENGTH_SHORT).show();
          }
      });

```

### 4:其它查看Demo详情


## 推荐:
Name | Describe |
--- | --- |
[GankMM](https://github.com/maning0303/GankMM) | （Material Design & MVP & Retrofit + OKHttp & RecyclerView ...）Gank.io Android客户端：每天一张美女图片，一个视频短片，若干Android，iOS等程序干货，周一到周五每天更新，数据全部由 干货集中营 提供,持续更新。 |
[MNUpdateAPK](https://github.com/maning0303/MNUpdateAPK) | Android APK 版本更新的下载和安装,适配7.0,简单方便。 |
[MNImageBrowser](https://github.com/maning0303/MNImageBrowser) | 交互特效的图片浏览框架,微信向下滑动动态关闭 |
[MNCalendar](https://github.com/maning0303/MNCalendar) | 简单的日历控件练习，水平方向日历支持手势滑动切换，跳转月份；垂直方向日历选取区间范围。 |
[MClearEditText](https://github.com/maning0303/MClearEditText) | 带有删除功能的EditText |
[MNCrashMonitor](https://github.com/maning0303/MNCrashMonitor) | Debug监听程序崩溃日志,展示崩溃日志列表，方便自己平时调试。 |
[MNProgressHUD](https://github.com/maning0303/MNProgressHUD) | MNProgressHUD是对常用的自定义弹框封装,加载ProgressDialog,状态显示的StatusDialog和自定义Toast,支持背景颜色,圆角,边框和文字的自定义。 |
[MNXUtilsDB](https://github.com/maning0303/MNXUtilsDB) | xUtils3 数据库模块单独抽取出来，方便使用。 |
[MNVideoPlayer](https://github.com/maning0303/MNVideoPlayer) | SurfaceView + MediaPlayer 实现的视频播放器，支持横竖屏切换，手势快进快退、调节音量，亮度等。------代码简单，新手可以看一看。 |
[MNZXingCode](https://github.com/maning0303/MNZXingCode) | 快速集成二维码扫描和生成二维码 |
[MNChangeSkin](https://github.com/maning0303/MNChangeSkin) | Android夜间模式，通过Theme实现 |
[SwitcherView](https://github.com/maning0303/SwitcherView) | 垂直滚动的广告栏文字展示。 |
[MNPasswordEditText](https://github.com/maning0303/MNPasswordEditText) | 类似微信支付宝的密码输入框。 |
[MNSwipeToLoadDemo](https://github.com/maning0303/MNSwipeToLoadDemo) | 利用SwipeToLoadLayout实现的各种下拉刷新效果（饿了吗，京东，百度外卖，美团外卖，天猫下拉刷新等）。 |


    

