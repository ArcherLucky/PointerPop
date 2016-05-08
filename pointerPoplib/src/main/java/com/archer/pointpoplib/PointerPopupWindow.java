package com.archer.pointpoplib;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by 84113 on 2016/5/8.
 */
public class PointerPopupWindow extends PopupWindow {

    enum PointGravity {
        TOP, BOTTOM
    }

    public PointerPopupWindow(Context context) {
        super(context);
    }

    public PointerPopupWindow() {
        super();
    }

    public PointerPopupWindow(View contentView) {
        super(contentView);
    }

    public PointerPopupWindow(View contentView, int width, int height) {
        super(contentView, width, height);
    }
}
