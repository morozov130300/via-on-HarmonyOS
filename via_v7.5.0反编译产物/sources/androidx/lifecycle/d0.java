package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f957a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f957a.values().iterator();
        while (it.hasNext()) {
            ((z) it.next()).e();
        }
        this.f957a.clear();
    }

    public final z b(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        return (z) this.f957a.get(key);
    }

    public final Set c() {
        return new HashSet(this.f957a.keySet());
    }

    public final void d(String key, z viewModel) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(viewModel, "viewModel");
        z zVar = (z) this.f957a.put(key, viewModel);
        if (zVar != null) {
            zVar.h();
        }
    }
}
