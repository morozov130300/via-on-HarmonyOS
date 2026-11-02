package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements f {

    /* renamed from: e, reason: collision with root package name */
    public final Object f1021e;

    /* renamed from: j, reason: collision with root package name */
    public final b.a f1022j;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1021e = obj;
        this.f1022j = b.f1035c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.f
    public void a(h hVar, Lifecycle.Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f1022j.a(hVar, event, this.f1021e);
    }
}
