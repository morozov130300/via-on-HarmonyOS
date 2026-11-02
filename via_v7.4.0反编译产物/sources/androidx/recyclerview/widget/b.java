package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements o {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f1380a;

    public b(RecyclerView.Adapter adapter) {
        this.f1380a = adapter;
    }

    @Override // androidx.recyclerview.widget.o
    public void a(int i10, int i11) {
        this.f1380a.p(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void b(int i10, int i11) {
        this.f1380a.s(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void c(int i10, int i11) {
        this.f1380a.t(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void d(int i10, int i11, Object obj) {
        this.f1380a.r(i10, i11, obj);
    }
}
