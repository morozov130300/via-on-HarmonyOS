package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.g f3208a;

    public z5(k.g gVar) {
        this.f3208a = gVar;
    }

    public final String a(Uri uri, String str, String str2, String str3) {
        k.g gVar;
        if (uri != null) {
            gVar = (k.g) this.f3208a.get(uri.toString());
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(str3));
    }
}
