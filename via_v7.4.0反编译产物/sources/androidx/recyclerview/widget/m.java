package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    public int f1576b;

    /* renamed from: c, reason: collision with root package name */
    public int f1577c;

    /* renamed from: d, reason: collision with root package name */
    public int f1578d;

    /* renamed from: e, reason: collision with root package name */
    public int f1579e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1582h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1583i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1575a = true;

    /* renamed from: f, reason: collision with root package name */
    public int f1580f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f1581g = 0;

    public boolean a(RecyclerView.z zVar) {
        int i10 = this.f1577c;
        return i10 >= 0 && i10 < zVar.b();
    }

    public View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.f1577c);
        this.f1577c += this.f1578d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1576b + ", mCurrentPosition=" + this.f1577c + ", mItemDirection=" + this.f1578d + ", mLayoutDirection=" + this.f1579e + ", mStartLine=" + this.f1580f + ", mEndLine=" + this.f1581g + '}';
    }
}
