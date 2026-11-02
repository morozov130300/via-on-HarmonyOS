package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0046a interfaceC0046a) {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        bVar.f3382a = interfaceC0046a.b(context, str);
        int iA = interfaceC0046a.a(context, str, true);
        bVar.f3383b = iA;
        int i10 = bVar.f3382a;
        if (i10 == 0) {
            i10 = 0;
            if (iA == 0) {
                bVar.f3384c = 0;
                return bVar;
            }
        }
        if (i10 >= iA) {
            bVar.f3384c = -1;
            return bVar;
        }
        bVar.f3384c = 1;
        return bVar;
    }
}
