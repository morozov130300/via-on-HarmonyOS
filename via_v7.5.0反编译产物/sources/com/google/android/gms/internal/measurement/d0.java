package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Comparator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2735c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q4 f2736e;

    public d0(k kVar, q4 q4Var) {
        this.f2735c = kVar;
        this.f2736e = q4Var;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        r rVar = (r) obj;
        boolean z10 = rVar instanceof w;
        r rVar2 = (r) obj2;
        k kVar = this.f2735c;
        q4 q4Var = this.f2736e;
        if (z10) {
            return !(rVar2 instanceof w) ? 1 : 0;
        }
        if (rVar2 instanceof w) {
            return -1;
        }
        return kVar == null ? rVar.f().compareTo(rVar2.f()) : (int) r5.a(kVar.a(q4Var, Arrays.asList(rVar, rVar2)).e().doubleValue());
    }
}
