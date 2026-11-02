package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0046a interfaceC0046a) {
        int iA;
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iB = interfaceC0046a.b(context, str);
        bVar.f3382a = iB;
        int i10 = 0;
        if (iB != 0) {
            iA = interfaceC0046a.a(context, str, false);
            bVar.f3383b = iA;
        } else {
            iA = interfaceC0046a.a(context, str, true);
            bVar.f3383b = iA;
        }
        int i11 = bVar.f3382a;
        if (i11 != 0) {
            i10 = i11;
        } else if (iA == 0) {
            bVar.f3384c = 0;
            return bVar;
        }
        if (iA >= i10) {
            bVar.f3384c = 1;
            return bVar;
        }
        bVar.f3384c = -1;
        return bVar;
    }
}
