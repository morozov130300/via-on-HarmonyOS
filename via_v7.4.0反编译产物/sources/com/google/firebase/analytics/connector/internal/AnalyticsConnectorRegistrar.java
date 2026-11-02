package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import g3.d;
import h2.e;
import j2.a;
import java.util.Arrays;
import java.util.List;
import m2.c;
import m2.h;
import m2.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Keep
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<c> getComponents() {
        return Arrays.asList(c.c(a.class).b(r.i(e.class)).b(r.i(Context.class)).b(r.i(d.class)).e(new h() { // from class: k2.a
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return j2.b.c((h2.e) eVar.a(h2.e.class), (Context) eVar.a(Context.class), (g3.d) eVar.a(g3.d.class));
            }
        }).d().c(), o3.h.b("fire-analytics", "21.3.0"));
    }
}
