package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import g2.f;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import s2.o0;
import s2.r;
import s2.s;
import s2.v;
import z2.b;
import z2.c;
import z2.d;
import z2.e;
import z2.g;
import z2.h;
import z2.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4019a;

    /* renamed from: b, reason: collision with root package name */
    public final h f4020b;

    /* renamed from: c, reason: collision with root package name */
    public final e f4021c;

    /* renamed from: d, reason: collision with root package name */
    public final r f4022d;

    /* renamed from: e, reason: collision with root package name */
    public final z2.a f4023e;

    /* renamed from: f, reason: collision with root package name */
    public final i f4024f;

    /* renamed from: g, reason: collision with root package name */
    public final s f4025g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference f4026h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReference f4027i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.firebase.crashlytics.internal.settings.a$a, reason: collision with other inner class name */
    public class C0047a implements g2.e {
        public C0047a() {
        }

        @Override // g2.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Void r52) throws Throwable {
            JSONObject jSONObjectA = a.this.f4024f.a(a.this.f4020b, true);
            if (jSONObjectA != null) {
                d dVarB = a.this.f4021c.b(jSONObjectA);
                a.this.f4023e.c(dVarB.f14564c, jSONObjectA);
                a.this.q(jSONObjectA, "Loaded settings: ");
                a aVar = a.this;
                aVar.r(aVar.f4020b.f14581f);
                a.this.f4026h.set(dVarB);
                ((g2.g) a.this.f4027i.get()).e(dVarB);
            }
            return g2.i.e(null);
        }
    }

    public a(Context context, h hVar, r rVar, e eVar, z2.a aVar, i iVar, s sVar) {
        AtomicReference atomicReference = new AtomicReference();
        this.f4026h = atomicReference;
        this.f4027i = new AtomicReference(new g2.g());
        this.f4019a = context;
        this.f4020b = hVar;
        this.f4022d = rVar;
        this.f4021c = eVar;
        this.f4023e = aVar;
        this.f4024f = iVar;
        this.f4025g = sVar;
        atomicReference.set(b.b(rVar));
    }

    public static a l(Context context, String str, v vVar, w2.b bVar, String str2, String str3, x2.g gVar, s sVar) {
        String strG = vVar.g();
        o0 o0Var = new o0();
        return new a(context, new h(str, vVar.h(), vVar.i(), vVar.j(), vVar, CommonUtils.h(CommonUtils.o(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(strG).getId()), o0Var, new e(o0Var), new z2.a(gVar), new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), sVar);
    }

    @Override // z2.g
    public f a() {
        return ((g2.g) this.f4027i.get()).a();
    }

    @Override // z2.g
    public d b() {
        return (d) this.f4026h.get();
    }

    public boolean k() {
        return !n().equals(this.f4020b.f14581f);
    }

    public final d m(SettingsCacheBehavior settingsCacheBehavior) throws Throwable {
        d dVar = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject jSONObjectB = this.f4023e.b();
                if (jSONObjectB != null) {
                    d dVarB = this.f4021c.b(jSONObjectB);
                    if (dVarB == null) {
                        p2.f.f().e("Failed to parse cached settings data.", null);
                        return null;
                    }
                    q(jSONObjectB, "Loaded cached settings: ");
                    long jA = this.f4022d.a();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && dVarB.a(jA)) {
                        p2.f.f().i("Cached settings have expired.");
                        return null;
                    }
                    try {
                        p2.f.f().i("Returning cached settings.");
                        return dVarB;
                    } catch (Exception e10) {
                        e = e10;
                        dVar = dVarB;
                        p2.f.f().e("Failed to get cached settings", e);
                        return dVar;
                    }
                }
                p2.f.f().b("No cached settings data found.");
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final String n() {
        return CommonUtils.s(this.f4019a).getString("existing_instance_identifier", "");
    }

    public f o(SettingsCacheBehavior settingsCacheBehavior, Executor executor) throws Throwable {
        d dVarM;
        if (!k() && (dVarM = m(settingsCacheBehavior)) != null) {
            this.f4026h.set(dVarM);
            ((g2.g) this.f4027i.get()).e(dVarM);
            return g2.i.e(null);
        }
        d dVarM2 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (dVarM2 != null) {
            this.f4026h.set(dVarM2);
            ((g2.g) this.f4027i.get()).e(dVarM2);
        }
        return this.f4025g.h(executor).m(executor, new C0047a());
    }

    public f p(Executor executor) {
        return o(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public final void q(JSONObject jSONObject, String str) {
        p2.f.f().b(str + jSONObject.toString());
    }

    public final boolean r(String str) {
        SharedPreferences.Editor editorEdit = CommonUtils.s(this.f4019a).edit();
        editorEdit.putString("existing_instance_identifier", str);
        editorEdit.apply();
        return true;
    }
}
