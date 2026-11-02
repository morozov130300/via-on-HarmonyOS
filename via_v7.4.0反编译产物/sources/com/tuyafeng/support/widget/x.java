package com.tuyafeng.support.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class x extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    public int f4390a;

    /* renamed from: b, reason: collision with root package name */
    public int f4391b;

    /* renamed from: c, reason: collision with root package name */
    public int f4392c;

    /* renamed from: d, reason: collision with root package name */
    public int f4393d;

    public x(int i10, int i11) {
        this.f4392c = i11;
        this.f4391b = i10;
        this.f4393d = i11;
        this.f4390a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.top = this.f4390a;
        rect.left = this.f4392c;
        rect.right = this.f4393d;
        rect.bottom = this.f4391b;
    }
}
