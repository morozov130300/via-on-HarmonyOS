package y2;

import a1.f;
import android.content.Context;
import d1.t;
import java.nio.charset.Charset;
import s2.a0;
import s2.p;
import u2.b0;
import v2.h;
import z2.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final h f14404c = new h();

    /* renamed from: d, reason: collision with root package name */
    public static final String f14405d = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e, reason: collision with root package name */
    public static final String f14406e = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f, reason: collision with root package name */
    public static final a1.d f14407f = new a1.d() { // from class: y2.a
        @Override // a1.d
        public final Object apply(Object obj) {
            return b.f14404c.G((b0) obj).getBytes(Charset.forName("UTF-8"));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final e f14408a;

    /* renamed from: b, reason: collision with root package name */
    public final a1.d f14409b;

    public b(e eVar, a1.d dVar) {
        this.f14408a = eVar;
        this.f14409b = dVar;
    }

    public static b b(Context context, g gVar, a0 a0Var) {
        t.f(context);
        f fVarG = t.c().g(new b1.a(f14405d, f14406e));
        a1.b bVarB = a1.b.b("json");
        a1.d dVar = f14407f;
        return new b(new e(fVarG.a("FIREBASE_CRASHLYTICS_REPORT", b0.class, bVarB, dVar), gVar.b(), a0Var), dVar);
    }

    public static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    public g2.f c(p pVar, boolean z10) {
        return this.f14408a.i(pVar, z10).a();
    }
}
