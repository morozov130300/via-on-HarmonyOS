package o6;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements MovementMethod {

    /* renamed from: a, reason: collision with root package name */
    public final MovementMethod f10412a;

    public a(MovementMethod movementMethod) {
        this.f10412a = movementMethod;
    }

    public static a a() {
        return new a(LinkMovementMethod.getInstance());
    }

    public static boolean b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        c cVar;
        Layout layoutE;
        if (motionEvent.getAction() != 1) {
            return false;
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
        c[] cVarArr = (c[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, c.class);
        if (cVarArr.length != 0 && (layoutE = (cVar = cVarArr[0]).e(scrollX)) != null) {
            int offsetForHorizontal2 = layoutE.getOffsetForHorizontal(layoutE.getLineForVertical(scrollY - layout.getLineTop(lineForVertical)), scrollX % cVar.c());
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) layoutE.getText()).getSpans(offsetForHorizontal2, offsetForHorizontal2, ClickableSpan.class);
            if (clickableSpanArr.length > 0) {
                clickableSpanArr[0].onClick(textView);
                return true;
            }
        }
        return false;
    }

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return this.f10412a.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
        this.f10412a.initialize(textView, spannable);
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return this.f10412a.onGenericMotionEvent(textView, spannable, motionEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView textView, Spannable spannable, int i10, KeyEvent keyEvent) {
        return this.f10412a.onKeyDown(textView, spannable, i10, keyEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return this.f10412a.onKeyOther(textView, spannable, keyEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView textView, Spannable spannable, int i10, KeyEvent keyEvent) {
        return this.f10412a.onKeyUp(textView, spannable, i10, keyEvent);
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i10) {
        this.f10412a.onTakeFocus(textView, spannable, i10);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return this.f10412a.onTouchEvent(textView, spannable, motionEvent) || b(textView, spannable, motionEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return this.f10412a.onTrackballEvent(textView, spannable, motionEvent);
    }
}
