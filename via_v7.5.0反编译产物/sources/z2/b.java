package z2;

import a3.g;
import android.content.Context;
import b1.f;
import e1.t;
import java.nio.charset.Charset;
import t2.a0;
import t2.p;
import v2.b0;
import w2.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f15132c = new h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15133d = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f15134e = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b1.d f15135f = new b1.d() { // from class: z2.a
        @Override // b1.d
        public final Object apply(Object obj) {
            return b.f15132c.G((b0) obj).getBytes(Charset.forName("UTF-8"));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f15136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1.d f15137b;

    public b(e eVar, b1.d dVar) {
        this.f15136a = eVar;
        this.f15137b = dVar;
    }

    public static b b(Context context, g gVar, a0 a0Var) {
        t.f(context);
        f fVarG = t.c().g(new c1.a(f15133d, f15134e));
        b1.b bVarB = b1.b.b("json");
        b1.d dVar = f15135f;
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

    public h2.f c(p pVar, boolean z10) {
        return this.f15136a.i(pVar, z10).a();
    }
}
