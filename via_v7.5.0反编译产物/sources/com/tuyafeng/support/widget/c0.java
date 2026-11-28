package com.tuyafeng.support.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3706f;

    public c0(int i10) {
        this.f3703c = i10;
        this.f3702b = i10;
        this.f3704d = i10;
        this.f3701a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.set(this.f3703c, this.f3701a, this.f3704d, this.f3702b);
        int iI0 = recyclerView.i0(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (iI0 == -1 || adapter == null) {
            return;
        }
        if (iI0 == 0) {
            rect.top += this.f3705e;
        }
        if (iI0 == adapter.g() - 1) {
            rect.bottom += this.f3706f;
        }
    }

    public void l(int i10) {
        this.f3706f = i10;
    }

    public c0(int i10, int i11) {
        this.f3703c = i11;
        this.f3702b = i10;
        this.f3704d = i11;
        this.f3701a = i10;
    }
}
