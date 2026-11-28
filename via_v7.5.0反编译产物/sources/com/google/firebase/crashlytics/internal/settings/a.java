package com.google.firebase.crashlytics.internal.settings;

import a3.b;
import a3.c;
import a3.d;
import a3.e;
import a3.g;
import a3.h;
import a3.i;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import h2.f;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import t2.o0;
import t2.r;
import t2.s;
import t2.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f3317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f3318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f3319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a3.a f3320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f3321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f3322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference f3323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f3324i;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.settings.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0041a implements h2.e {
        public C0041a() {
        }

        @Override // h2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Void r10) throws Throwable {
            JSONObject jSONObjectA = a.this.f3321f.a(a.this.f3317b, true);
            if (jSONObjectA != null) {
                d dVarB = a.this.f3318c.b(jSONObjectA);
                a.this.f3320e.c(dVarB.f32c, jSONObjectA);
                a.this.q(jSONObjectA, "Loaded settings: ");
                a aVar = a.this;
                aVar.r(aVar.f3317b.f49f);
                a.this.f3323h.set(dVarB);
                ((h2.g) a.this.f3324i.get()).e(dVarB);
            }
            return h2.i.e(null);
        }
    }

    public a(Context context, h hVar, r rVar, e eVar, a3.a aVar, i iVar, s sVar) {
        AtomicReference atomicReference = new AtomicReference();
        this.f3323h = atomicReference;
        this.f3324i = new AtomicReference(new h2.g());
        this.f3316a = context;
        this.f3317b = hVar;
        this.f3319d = rVar;
        this.f3318c = eVar;
        this.f3320e = aVar;
        this.f3321f = iVar;
        this.f3322g = sVar;
        atomicReference.set(b.b(rVar));
    }

    public static a l(Context context, String str, v vVar, x2.b bVar, String str2, String str3, y2.g gVar, s sVar) {
        String strG = vVar.g();
        o0 o0Var = new o0();
        return new a(context, new h(str, vVar.h(), vVar.i(), vVar.j(), vVar, CommonUtils.h(CommonUtils.o(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(strG).getId()), o0Var, new e(o0Var), new a3.a(gVar), new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), bVar), sVar);
    }

    @Override // a3.g
    public f a() {
        return ((h2.g) this.f3324i.get()).a();
    }

    @Override // a3.g
    public d b() {
        return (d) this.f3323h.get();
    }

    public boolean k() {
        return !n().equals(this.f3317b.f49f);
    }

    public final d m(SettingsCacheBehavior settingsCacheBehavior) throws Throwable {
        d dVar = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject jSONObjectB = this.f3320e.b();
                if (jSONObjectB != null) {
                    d dVarB = this.f3318c.b(jSONObjectB);
                    if (dVarB == null) {
                        q2.f.f().e("Failed to parse cached settings data.", null);
                        return null;
                    }
                    q(jSONObjectB, "Loaded cached settings: ");
                    long jA = this.f3319d.a();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && dVarB.a(jA)) {
                        q2.f.f().i("Cached settings have expired.");
                        return null;
                    }
                    try {
                        q2.f.f().i("Returning cached settings.");
                        return dVarB;
                    } catch (Exception e10) {
                        e = e10;
                        dVar = dVarB;
                        q2.f.f().e("Failed to get cached settings", e);
                        return dVar;
                    }
                }
                q2.f.f().b("No cached settings data found.");
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final String n() {
        return CommonUtils.s(this.f3316a).getString("existing_instance_identifier", "");
    }

    public f o(SettingsCacheBehavior settingsCacheBehavior, Executor executor) throws Throwable {
        d dVarM;
        if (!k() && (dVarM = m(settingsCacheBehavior)) != null) {
            this.f3323h.set(dVarM);
            ((h2.g) this.f3324i.get()).e(dVarM);
            return h2.i.e(null);
        }
        d dVarM2 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (dVarM2 != null) {
            this.f3323h.set(dVarM2);
            ((h2.g) this.f3324i.get()).e(dVarM2);
        }
        return this.f3322g.h(executor).m(executor, new C0041a());
    }

    public f p(Executor executor) {
        return o(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public final void q(JSONObject jSONObject, String str) {
        q2.f.f().b(str + jSONObject.toString());
    }

    public final boolean r(String str) {
        SharedPreferences.Editor editorEdit = CommonUtils.s(this.f3316a).edit();
        editorEdit.putString("existing_instance_identifier", str);
        editorEdit.apply();
        return true;
    }
}
