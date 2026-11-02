package mark.via.common.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l1 extends HorizontalScrollView {

    /* renamed from: e, reason: collision with root package name */
    public EditText f9680e;

    public l1(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFillViewport(true);
        r3.f(this);
        EditText editText = new EditText(getContext());
        this.f9680e = editText;
        editText.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        x8.g.k(this.f9680e);
        r3.n(this.f9680e);
        this.f9680e.setBackgroundColor(0);
        this.f9680e.setPadding(0, 0, 0, 0);
        x8.g.h(this.f9680e);
        addView(this.f9680e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public EditText getEditText() {
        return this.f9680e;
    }
}
