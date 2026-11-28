package x8;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g1 extends b0.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f14571q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f14572r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f14573s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f14574t;

    public g1(TextView textView, Context context, String str) {
        super(textView);
        this.f14574t = new Rect();
        this.f14571q = textView;
        this.f14572r = context;
        this.f14573s = str;
    }

    @Override // b0.a
    public void B(int i10, z.d0 d0Var) {
        String str = this.f14573s;
        if (str != null) {
            d0Var.k0(str);
        }
        ClickableSpan clickableSpanK = K(i10);
        if (clickableSpanK != null) {
            d0Var.X(L(clickableSpanK).toString());
        } else {
            tc.a.d("LinkSpan is null for offset: %s", Integer.valueOf(i10));
            d0Var.X(this.f14571q.getText());
        }
        d0Var.Z(true);
        d0Var.U(true);
        J(clickableSpanK, this.f14574t);
        if (this.f14574t.isEmpty()) {
            tc.a.d("LinkSpan bounds is empty for: %s", Integer.valueOf(i10));
            this.f14574t.set(0, 0, 1, 1);
        }
        d0Var.R(this.f14574t);
        d0Var.a(16);
    }

    public final Rect J(ClickableSpan clickableSpan, Rect rect) {
        Layout layout;
        CharSequence text = this.f14571q.getText();
        rect.setEmpty();
        if ((text instanceof Spanned) && (layout = this.f14571q.getLayout()) != null) {
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
            rect.offset(this.f14571q.getTotalPaddingLeft(), this.f14571q.getTotalPaddingTop());
        }
        return rect;
    }

    public final ClickableSpan K(int i10) {
        CharSequence text = this.f14571q.getText();
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
        CharSequence text = this.f14571q.getText();
        if (!(text instanceof Spanned)) {
            return text;
        }
        Spanned spanned = (Spanned) text;
        return spanned.subSequence(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan));
    }

    @Override // b0.a
    public void u(List list) {
        CharSequence text = this.f14571q.getText();
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            for (ClickableSpan clickableSpan : (ClickableSpan[]) spanned.getSpans(0, text.length(), ClickableSpan.class)) {
                list.add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
            }
        }
    }

    @Override // b0.a
    public boolean x(int i10, int i11, Bundle bundle) {
        if (i11 == 16) {
            ClickableSpan clickableSpanK = K(i10);
            if (clickableSpanK != null) {
                clickableSpanK.onClick(this.f14571q);
                return true;
            }
            tc.a.d("LinkSpan is null for offset: %s", Integer.valueOf(i10));
        }
        return false;
    }

    @Override // b0.a
    public void z(int i10, AccessibilityEvent accessibilityEvent) {
        ClickableSpan clickableSpanK = K(i10);
        if (clickableSpanK == null) {
            tc.a.d("LinkSpan is null for offset: %s", Integer.valueOf(i10));
            accessibilityEvent.setContentDescription(this.f14571q.getText().toString());
        } else {
            accessibilityEvent.setContentDescription(L(clickableSpanK).toString() + "link.");
        }
    }
}
