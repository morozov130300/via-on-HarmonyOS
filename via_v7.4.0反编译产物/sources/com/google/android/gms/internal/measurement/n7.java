package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n7 {

    /* renamed from: a, reason: collision with root package name */
    public final Map f3631a = new HashMap();

    public final void a(String str, Callable callable) {
        this.f3631a.put(str, callable);
    }
}
