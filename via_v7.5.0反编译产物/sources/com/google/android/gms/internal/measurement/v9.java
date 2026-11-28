package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v9 {
    public static final int a(int i10, Object obj, Object obj2) {
        zzmc zzmcVar = (zzmc) obj;
        n.g.a(obj2);
        if (zzmcVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzmcVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object b(Object obj, Object obj2) {
        zzmc zzmcVarZzb = (zzmc) obj;
        zzmc zzmcVar = (zzmc) obj2;
        if (!zzmcVar.isEmpty()) {
            if (!zzmcVarZzb.zze()) {
                zzmcVarZzb = zzmcVarZzb.zzb();
            }
            zzmcVarZzb.zzd(zzmcVar);
        }
        return zzmcVarZzb;
    }
}
