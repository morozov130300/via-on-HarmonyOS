package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;
import q1.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@KeepName
/* loaded from: classes.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int zza;

    public GooglePlayServicesManifestException(int i10, String str) {
        super(str);
        this.zza = i10;
    }

    public int getActualVersion() {
        return this.zza;
    }

    public int getExpectedVersion() {
        return b.f11237a;
    }
}
