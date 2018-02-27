# MagicItemDecoration

[![Apache 2.0 License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0.html)

RecycleViw分割线
* 可配置每边颜色、粗细、边距
* 支持配置任意一边

## 效果图
<img src="app/src/main/image/example1.jpg" width="280px"/><img src="app/src/main/image/example2.jpg" width="280px"/><img src="app/src/main/image/example3.jpg" width="280px"/><img src="app/src/main/image/example4.jpg" width="280px"/>

#### 使用方式：
 
 
#### 1.gradle
```
compile 'com.xwc:recyclerview-decoration:1.0.1' 
```

#### 2-1.使用xml方式配置：

```
    <com.xwc.itemdecoration.DRecycleView
        android:id="@+id/recycle_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:x_decoration_color="#D8D8D8"        分割线颜色
        app:x_decoration_end_padding="0dp"      末端边距
        app:x_decoration_start_padding="0dp"    开始边距
        app:x_decoration_width="1dp"            线宽
        app:x_gridlayout_spanCount="3" />       使用GridLayoutManager并且一排三个，默认LinearLayoutManager
```


####2-2.使用Java代码方式配置：

```
   recycleView.addItemDecoration(new DRecycleViewDivider(this) {

            @Nullable
            @Override
            public Divider getDivider(int itemPosition) {
                Divider divider = null;
                switch (itemPosition) {
                    case 0:
                        divider = new DividerBuilder()
                                .setLeftSideLine(true, 0xFFFF0000, dip2px(16), 0, 0)
                                .setRightSideLine(true, 0xFFFF0000, dip2px(16), 0, 0)
                                .setBottomSideLine(true, 0xFF000000, dip2px(16), 0, 0)
                                .setTopSideLine(true, 0xFF000000, dip2px(16), 0, 0)
                                .create();
                        break;
                    case 1:
                        divider = new DividerBuilder()
                                .setLeftSideLine(true, 0xFF0000FF, dip2px(5), dip2px(8), dip2px(8))
                                .setRightSideLine(true, 0xFF0000FF, dip2px(5), dip2px(8), dip2px(8))
                                .setBottomSideLine(true, 0xFF0000FF, dip2px(16), 0, 0)
                                .setTopSideLine(true, 0xFF0000FF, dip2px(16), 0, 0)
                                .create();
                        break;
                    case 2:
                        divider = new DividerBuilder()
                                .setLeftSideLine(true, 0xFFFF0000, dip2px(15), 0, 0)
                                .setRightSideLine(true, 0xFFFF0000, dip2px(15), 0, 0)
                                .setBottomSideLine(true, 0xFFFF0000, dip2px(10), 0, dip2px(30))
                                .setTopSideLine(true, 0xFFFF0000, dip2px(10), dip2px(8), dip2px(8))
                                .create();
                        break;
                    case 3:
                        divider = new DividerBuilder()
                                .setBottomSideLine(true, Color.DKGRAY, dip2px(5), dip2px(10), dip2px(5))
                                .create();
                        break;
                    default:
                        divider = new DividerBuilder()
                                .setBottomSideLine(true, Color.parseColor("#D8D8D8"), 1, 0, 0)
                                .create();
                        break;
                }
                return divider;
            }
        });
```





## <a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=947017886@qq.com" >联系邮箱</a>
