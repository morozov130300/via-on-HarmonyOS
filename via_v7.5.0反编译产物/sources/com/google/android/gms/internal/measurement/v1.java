package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Context f3133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Bundle f3134r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ u2 f3135s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(u2 u2Var, String str, String str2, Context context, Bundle bundle) {
        super(u2Var, true);
        this.f3135s = u2Var;
        this.f3131o = str;
        this.f3132p = str2;
        this.f3133q = context;
        this.f3134r = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        String str;
        String str2;
        String str3;
        try {
            if (this.f3135s.k(this.f3131o, this.f3132p)) {
                str3 = this.f3132p;
                str2 = this.f3131o;
                str = this.f3135s.f3111a;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            u1.f.h(this.f3133q);
            u2 u2Var = this.f3135s;
            u2Var.f3119i = u2Var.p(this.f3133q, true);
            if (this.f3135s.f3119i == null) {
                Log.w(this.f3135s.f3111a, "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(this.f3133q, ModuleDescriptor.MODULE_ID);
            int iB = DynamiteModule.b(this.f3133q, ModuleDescriptor.MODULE_ID);
            ((h1) u1.f.h(this.f3135s.f3119i)).initialize(z1.b.b0(this.f3133q), new zzcl(79000L, Math.max(iA, iB), iB < iA, str, str2, str3, this.f3134r, g2.z4.a(this.f3133q)), this.f2867c);
        } catch (Exception e10) {
            this.f3135s.h(e10, true, false);
        }
    }
}
