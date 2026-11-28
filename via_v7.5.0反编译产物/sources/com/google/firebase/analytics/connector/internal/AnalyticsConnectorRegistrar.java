package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import h3.d;
import i2.e;
import java.util.Arrays;
import java.util.List;
import k2.a;
import n2.c;
import n2.h;
import n2.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<c> getComponents() {
        return Arrays.asList(c.c(a.class).b(r.i(e.class)).b(r.i(Context.class)).b(r.i(d.class)).e(new h() { // from class: l2.a
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return k2.b.c((i2.e) eVar.a(i2.e.class), (Context) eVar.a(Context.class), (h3.d) eVar.a(h3.d.class));
            }
        }).d().c(), p3.h.b("fire-analytics", "21.3.0"));
    }
}
