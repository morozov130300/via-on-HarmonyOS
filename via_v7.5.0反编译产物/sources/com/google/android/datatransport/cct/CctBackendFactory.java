package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import c1.d;
import f1.c;
import f1.f;
import f1.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class CctBackendFactory implements c {
    @Override // f1.c
    public k create(f fVar) {
        return new d(fVar.b(), fVar.e(), fVar.d());
    }
}
