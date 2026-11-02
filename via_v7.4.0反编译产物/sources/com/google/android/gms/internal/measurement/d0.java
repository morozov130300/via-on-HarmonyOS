package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d0 implements Comparator {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k f3436e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q4 f3437j;

    public d0(k kVar, q4 q4Var) {
        this.f3436e = kVar;
        this.f3437j = q4Var;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        r rVar = (r) obj;
        boolean z10 = rVar instanceof w;
        r rVar2 = (r) obj2;
        k kVar = this.f3436e;
        q4 q4Var = this.f3437j;
        if (z10) {
            return !(rVar2 instanceof w) ? 1 : 0;
        }
        if (rVar2 instanceof w) {
            return -1;
        }
        return kVar == null ? rVar.f().compareTo(rVar2.f()) : (int) r5.a(kVar.a(q4Var, Arrays.asList(rVar, rVar2)).e().doubleValue());
    }
}
