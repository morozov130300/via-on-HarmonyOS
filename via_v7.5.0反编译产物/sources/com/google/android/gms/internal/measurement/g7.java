package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g7 {
    public static d7 a(d7 d7Var) {
        if ((d7Var instanceof f7) || (d7Var instanceof zzin)) {
            return d7Var;
        }
        return d7Var instanceof Serializable ? new zzin(d7Var) : new f7(d7Var);
    }

    public static d7 b(Object obj) {
        return new zziq(obj);
    }
}
