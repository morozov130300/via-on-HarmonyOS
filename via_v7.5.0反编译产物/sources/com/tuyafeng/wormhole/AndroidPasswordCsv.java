package com.tuyafeng.wormhole;

import c6.v0;
import java.io.BufferedReader;
import java.util.List;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPasswordCsv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidPasswordCsv f3782a = new AndroidPasswordCsv();

    public final List a(BufferedReader reader) {
        h.f(reader, "reader");
        return v0.f2112a.d(new AndroidPasswordCsv$read$1(reader));
    }
}
