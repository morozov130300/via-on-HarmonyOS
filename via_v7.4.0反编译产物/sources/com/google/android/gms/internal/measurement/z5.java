package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z5 {

    /* renamed from: a, reason: collision with root package name */
    public final k.g f3909a;

    public z5(k.g gVar) {
        this.f3909a = gVar;
    }

    public final String a(Uri uri, String str, String str2, String str3) {
        k.g gVar;
        if (uri != null) {
            gVar = (k.g) this.f3909a.get(uri.toString());
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(str3));
    }
}
