package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f972a = new HashMap();

    public boolean a(String name, int i10) {
        kotlin.jvm.internal.h.f(name, "name");
        Integer num = (Integer) this.f972a.get(name);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z10 = (iIntValue & i10) != 0;
        this.f972a.put(name, Integer.valueOf(i10 | iIntValue));
        return !z10;
    }
}
