package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g7 {
    public static d7 a(d7 d7Var) {
        return ((d7Var instanceof f7) || (d7Var instanceof zzin)) ? d7Var : d7Var instanceof Serializable ? new zzin(d7Var) : new f7(d7Var);
    }

    public static d7 b(Object obj) {
        return new zziq(obj);
    }
}
