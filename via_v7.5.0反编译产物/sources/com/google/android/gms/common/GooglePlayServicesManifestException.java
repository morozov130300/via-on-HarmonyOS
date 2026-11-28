package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;
import r1.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@KeepName
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
        return b.f11927a;
    }
}
