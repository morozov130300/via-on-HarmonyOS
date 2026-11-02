package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class Lambda<R> implements g, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strD = j.d(this);
        h.e(strD, "renderLambdaToString(this)");
        return strD;
    }
}
