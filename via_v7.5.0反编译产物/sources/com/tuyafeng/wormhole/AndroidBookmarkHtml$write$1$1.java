package com.tuyafeng.wormhole;

import d7.h;
import java.io.BufferedWriter;
import java.io.IOException;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p7.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class AndroidBookmarkHtml$write$1$1 extends FunctionReferenceImpl implements l {
    public AndroidBookmarkHtml$write$1$1(Object obj) {
        super(1, obj, BufferedWriter.class, "write", "write(Ljava/lang/String;)V", 0);
    }

    @Override // p7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IOException {
        invoke((String) obj);
        return h.f3935a;
    }

    public final void invoke(String str) throws IOException {
        ((BufferedWriter) this.receiver).write(str);
    }
}
