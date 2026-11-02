package z8;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h1 extends a0.a {

    /* renamed from: q, reason: collision with root package name */
    public final TextView f14704q;

    /* renamed from: r, reason: collision with root package name */
    public final Context f14705r;

    /* renamed from: s, reason: collision with root package name */
    public final String f14706s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f14707t;

    public h1(TextView textView, Context context, String str) {
        super(textView);
        this.f14707t = new Rect();
        this.f14704q = textView;
        this.f14705r = context;
        this.f14706s = str;
    }

    @Override // a0.a
    public void B(int i10, y.d0 d0Var) {
        String str = this.f14706s;
        if (str != null) {
            d0Var.k0(str);
        }
        ClickableSpan clickableSpanK = K(i10);
        if (clickableSpanK != null) {
            d0Var.X(L(clickableSpanK).toString());
        } else {
            pc.a.c("LinkSpan is null for offset: %s", Integer.valueOf(i10));
            d0Var.X(this.f14704q.getText());
        }
        d0Var.Z(true);
        d0Var.U(true);
        J(clickableSpanK, this.f14707t);
        if (this.f14707t.isEmpty()) {
            pc.a.c("LinkSpan bounds is empty for: %s", Integer.valueOf(i10));
            this.f14707t.set(0, 0, 1, 1);
        }
        d0Var.R(this.f14707t);
        d0Var.a(16);
    }

    public final Rect J(ClickableSpan clickableSpan, Rect rect) {
        Layout layout;
        CharSequence text = this.f14704q.getText();
        rect.setEmpty();
        if ((text instanceof Spanned) && (layout = this.f14704q.getLayout()) != null) {
            Spanned spanned = (Spanned) text;
            int spanStart = spanned.getSpanStart(clickableSpan);
            int spanEnd = spanned.getSpanEnd(clickableSpan);
            float primaryHorizontal = layout.getPrimaryHorizontal(spanStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(spanEnd);
            int lineForOffset = layout.getLineForOffset(spanStart);
            int lineForOffset2 = layout.getLineForOffset(spanEnd);
            layout.getLineBounds(lineForOffset, rect);
            if (lineForOffset2 == lineForOffset) {
                rect.left = (int) Math.min(primaryHorizontal, primaryHorizontal2);
                rect.right = (int) Math.max(primaryHorizontal, primaryHorizontal2);
                return rect;
            }
            if (layout.getParagraphDirection(lineForOffset) == -1) {
                rect.right = (int) primaryHorizontal;
            } else {
                rect.left = (int) primaryHorizontal;
            }
            rect.offset(this.f14704q.getTotalPaddingLeft(), this.f14704q.getTotalPaddingTop());
        }
        return rect;
    }

    public final ClickableSpan K(int i10) {
        CharSequence text = this.f14704q.getText();
        if (!(text instanceof Spanned)) {
            return null;
        }
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(i10, i10, ClickableSpan.class);
        if (clickableSpanArr.length == 1) {
            return clickableSpanArr[0];
        }
        return null;
    }

    public final CharSequence L(ClickableSpan clickableSpan) {
        CharSequence text = this.f14704q.getText();
        if (!(text instanceof Spanned)) {
            return text;
        }
        Spanned spanned = (Spanned) text;
        return spanned.subSequence(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan));
    }

    @Override // a0.a
    public void u(List list) {
        CharSequence text = this.f14704q.getText();
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            for (ClickableSpan clickableSpan : (ClickableSpan[]) spanned.getSpans(0, text.length(), ClickableSpan.class)) {
                list.add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
            }
        }
    }

    @Override // a0.a
    public boolean x(int i10, int i11, Bundle bundle) {
        if (i11 == 16) {
            ClickableSpan clickableSpanK = K(i10);
            if (clickableSpanK != null) {
                clickableSpanK.onClick(this.f14704q);
                return true;
            }
            pc.a.c("LinkSpan is null for offset: %s", Integer.valueOf(i10));
        }
        return false;
    }

    @Override // a0.a
    public void z(int i10, AccessibilityEvent accessibilityEvent) {
        ClickableSpan clickableSpanK = K(i10);
        if (clickableSpanK == null) {
            pc.a.c("LinkSpan is null for offset: %s", Integer.valueOf(i10));
            accessibilityEvent.setContentDescription(this.f14704q.getText().toString());
        } else {
            accessibilityEvent.setContentDescription(L(clickableSpanK).toString() + "link.");
        }
    }
}
