package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map f1042a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f1042a.values().iterator();
        while (it.hasNext()) {
            ((x) it.next()).e();
        }
        this.f1042a.clear();
    }

    public final x b(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        return (x) this.f1042a.get(key);
    }

    public final Set c() {
        return new HashSet(this.f1042a.keySet());
    }

    public final void d(String key, x viewModel) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(viewModel, "viewModel");
        x xVar = (x) this.f1042a.put(key, viewModel);
        if (xVar != null) {
            xVar.h();
        }
    }
}
