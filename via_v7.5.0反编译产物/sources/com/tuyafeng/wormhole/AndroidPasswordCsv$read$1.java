package com.tuyafeng.wormhole;

import java.io.BufferedReader;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p7.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class AndroidPasswordCsv$read$1 extends FunctionReferenceImpl implements a {
    public AndroidPasswordCsv$read$1(Object obj) {
        super(0, obj, BufferedReader.class, "read", "read()I", 0);
    }

    @Override // p7.a
    public final Integer invoke() {
        return Integer.valueOf(((BufferedReader) this.receiver).read());
    }
}
