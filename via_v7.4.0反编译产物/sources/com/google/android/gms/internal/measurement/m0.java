package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m0 extends y {
    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        if (str == null || str.isEmpty() || !q4Var.h(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", str));
        }
        r rVarD = q4Var.d(str);
        if (rVarD instanceof k) {
            return ((k) rVarD).a(q4Var, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", str));
    }
}
