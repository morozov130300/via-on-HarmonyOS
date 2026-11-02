package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final Map f1057a = new HashMap();

    public boolean a(String name, int i10) {
        kotlin.jvm.internal.h.f(name, "name");
        Integer num = (Integer) this.f1057a.get(name);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z10 = (iIntValue & i10) != 0;
        this.f1057a.put(name, Integer.valueOf(i10 | iIntValue));
        return !z10;
    }
}
