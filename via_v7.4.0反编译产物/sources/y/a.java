package y;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: e, reason: collision with root package name */
    public final int f14350e;

    /* renamed from: j, reason: collision with root package name */
    public final d0 f14351j;

    /* renamed from: k, reason: collision with root package name */
    public final int f14352k;

    public a(int i10, d0 d0Var, int i11) {
        this.f14350e = i10;
        this.f14351j = d0Var;
        this.f14352k = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f14350e);
        this.f14351j.L(this.f14352k, bundle);
    }
}
