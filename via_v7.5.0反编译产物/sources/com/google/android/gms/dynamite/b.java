package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0040a interfaceC0040a) {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iA = interfaceC0040a.a(context, str, true);
        bVar.f2682b = iA;
        if (iA != 0) {
            bVar.f2683c = 1;
            return bVar;
        }
        int iB = interfaceC0040a.b(context, str);
        bVar.f2681a = iB;
        if (iB != 0) {
            bVar.f2683c = -1;
        }
        return bVar;
    }
}
