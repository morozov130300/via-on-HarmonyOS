package mark.via.common.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l1 extends HorizontalScrollView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EditText f9971c;

    public l1(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFillViewport(true);
        r3.g(this);
        EditText editText = new EditText(getContext());
        this.f9971c = editText;
        editText.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        v8.g.k(this.f9971c);
        r3.o(this.f9971c);
        this.f9971c.setBackgroundColor(0);
        this.f9971c.setPadding(0, 0, 0, 0);
        v8.g.h(this.f9971c);
        addView(this.f9971c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public EditText getEditText() {
        return this.f9971c;
    }
}
