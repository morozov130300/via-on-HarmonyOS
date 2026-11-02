package qa;

import androidx.lifecycle.LiveData;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f1 extends androidx.lifecycle.x {

    /* renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.l f11362d;

    /* renamed from: e, reason: collision with root package name */
    public LiveData f11363e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.l f11364f;

    /* renamed from: g, reason: collision with root package name */
    public LiveData f11365g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.l f11366h;

    /* renamed from: i, reason: collision with root package name */
    public LiveData f11367i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f11368j;

    /* renamed from: k, reason: collision with root package name */
    public LiveData f11369k;

    /* renamed from: l, reason: collision with root package name */
    public int f11370l;

    public f1() {
        androidx.lifecycle.l lVar = new androidx.lifecycle.l();
        this.f11362d = lVar;
        this.f11363e = lVar;
        androidx.lifecycle.l lVar2 = new androidx.lifecycle.l();
        this.f11364f = lVar2;
        this.f11365g = lVar2;
        androidx.lifecycle.l lVar3 = new androidx.lifecycle.l();
        this.f11366h = lVar3;
        this.f11367i = lVar3;
        androidx.lifecycle.l lVar4 = new androidx.lifecycle.l();
        this.f11368j = lVar4;
        this.f11369k = lVar4;
        this.f11370l = 0;
    }

    public void j(boolean z10) {
        this.f11368j.m(Boolean.valueOf(z10));
    }

    public int k() {
        return this.f11370l;
    }

    public void l(int i10) {
        this.f11370l = i10;
    }

    public void m(n9.b bVar) {
        if (bVar != null) {
            this.f11364f.m(bVar);
        }
        this.f11362d.m(1);
    }

    public void n(n9.b bVar) {
        if (bVar != null) {
            this.f11366h.m(bVar);
        }
        this.f11362d.m(0);
    }
}
