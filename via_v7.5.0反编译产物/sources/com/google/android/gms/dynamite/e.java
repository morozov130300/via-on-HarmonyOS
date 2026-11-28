package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0040a interfaceC0040a) {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        bVar.f2681a = interfaceC0040a.b(context, str);
        int iA = interfaceC0040a.a(context, str, true);
        bVar.f2682b = iA;
        int i10 = bVar.f2681a;
        if (i10 == 0) {
            i10 = 0;
            if (iA == 0) {
                bVar.f2683c = 0;
                return bVar;
            }
        }
        if (i10 >= iA) {
            bVar.f2683c = -1;
            return bVar;
        }
        bVar.f2683c = 1;
        return bVar;
    }
}
