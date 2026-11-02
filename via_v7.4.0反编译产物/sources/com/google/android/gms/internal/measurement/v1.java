package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v1 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3832m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3833n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Context f3834o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Bundle f3835p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u2 f3836q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(u2 u2Var, String str, String str2, Context context, Bundle bundle) {
        super(u2Var, true);
        this.f3836q = u2Var;
        this.f3832m = str;
        this.f3833n = str2;
        this.f3834o = context;
        this.f3835p = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        String str;
        String str2;
        String str3;
        try {
            if (this.f3836q.k(this.f3832m, this.f3833n)) {
                str3 = this.f3833n;
                str2 = this.f3832m;
                str = this.f3836q.f3812a;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            t1.f.h(this.f3834o);
            u2 u2Var = this.f3836q;
            u2Var.f3820i = u2Var.p(this.f3834o, true);
            if (this.f3836q.f3820i == null) {
                Log.w(this.f3836q.f3812a, "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(this.f3834o, ModuleDescriptor.MODULE_ID);
            ((h1) t1.f.h(this.f3836q.f3820i)).initialize(y1.b.b0(this.f3834o), new zzcl(79000L, Math.max(iA, r0), DynamiteModule.b(this.f3834o, ModuleDescriptor.MODULE_ID) < iA, str, str2, str3, this.f3835p, f2.z4.a(this.f3834o)), this.f3568e);
        } catch (Exception e10) {
            this.f3836q.h(e10, true, false);
        }
    }
}
