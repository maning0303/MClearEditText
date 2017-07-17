# MClearEditText（Android Studio）
    带有删除功能的EditText

## 屏幕截图
![screenshots](https://github.com/maning0303/MClearEditText/blob/master/screenshots/mn_clear_edittext_screenshot_001.png)
![screenshots](https://github.com/maning0303/MClearEditText/blob/master/screenshots/mn_clear_edittext_screenshot_002.png)


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
	     compile 'com.maning:librarymclearedittext:1.1.0'
	}
```

### 2:源码Model添加：
#### 直接关联calendarlibrary

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

    

