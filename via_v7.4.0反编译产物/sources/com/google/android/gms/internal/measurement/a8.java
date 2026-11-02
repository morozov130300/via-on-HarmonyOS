package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a8 implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzka zzkaVar = (zzka) obj;
        zzka zzkaVar2 = (zzka) obj2;
        z7 z7Var = new z7(zzkaVar);
        z7 z7Var2 = new z7(zzkaVar2);
        while (z7Var.hasNext() && z7Var2.hasNext()) {
            int iCompareTo = Integer.valueOf(z7Var.zza() & 255).compareTo(Integer.valueOf(z7Var2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzkaVar.zzd()).compareTo(Integer.valueOf(zzkaVar2.zzd()));
    }
}
