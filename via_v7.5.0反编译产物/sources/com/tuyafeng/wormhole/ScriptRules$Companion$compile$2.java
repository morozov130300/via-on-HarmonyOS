package com.tuyafeng.wormhole;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import p7.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ScriptRules$Companion$compile$2 extends FunctionReferenceImpl implements l {
    public ScriptRules$Companion$compile$2(Object obj) {
        super(1, obj, Regex.class, "matches", "matches(Ljava/lang/CharSequence;)Z", 0);
    }

    @Override // p7.l
    public final Boolean invoke(CharSequence p10) {
        h.f(p10, "p0");
        return Boolean.valueOf(((Regex) this.receiver).matches(p10));
    }
}
