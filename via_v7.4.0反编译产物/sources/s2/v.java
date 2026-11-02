package s2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v implements w {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f11799g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h, reason: collision with root package name */
    public static final String f11800h = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    public final x f11801a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11802b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11803c;

    /* renamed from: d, reason: collision with root package name */
    public final j3.e f11804d;

    /* renamed from: e, reason: collision with root package name */
    public final s f11805e;

    /* renamed from: f, reason: collision with root package name */
    public String f11806f;

    public v(Context context, String str, j3.e eVar, s sVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f11802b = context;
        this.f11803c = str;
        this.f11804d = eVar;
        this.f11805e = sVar;
        this.f11801a = new x();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return f11799g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    @Override // s2.w
    public synchronized String a() {
        try {
            String str = this.f11806f;
            if (str != null) {
                return str;
            }
            p2.f.f().i("Determining Crashlytics installation ID...");
            SharedPreferences sharedPreferencesS = CommonUtils.s(this.f11802b);
            String string = sharedPreferencesS.getString("firebase.installation.id", null);
            p2.f.f().i("Cached Firebase Installation ID: " + string);
            if (this.f11805e.d()) {
                String strD = d();
                p2.f.f().i("Fetched Firebase Installation ID: " + strD);
                if (strD == null) {
                    strD = string == null ? c() : string;
                }
                if (strD.equals(string)) {
                    this.f11806f = l(sharedPreferencesS);
                } else {
                    this.f11806f = b(strD, sharedPreferencesS);
                }
            } else if (k(string)) {
                this.f11806f = l(sharedPreferencesS);
            } else {
                this.f11806f = b(c(), sharedPreferencesS);
            }
            if (this.f11806f == null) {
                p2.f.f().k("Unable to determine Crashlytics Install Id, creating a new one.");
                this.f11806f = b(c(), sharedPreferencesS);
            }
            p2.f.f().i("Crashlytics installation ID: " + this.f11806f);
            return this.f11806f;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        p2.f.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    public final String d() {
        try {
            return (String) u0.f(this.f11804d.getId());
        } catch (Exception e10) {
            p2.f.f().l("Failed to retrieve Firebase Installations ID.", e10);
            return null;
        }
    }

    public String f() {
        return this.f11803c;
    }

    public String g() {
        return this.f11801a.a(this.f11802b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }

    public final String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    public final String m(String str) {
        return str.replaceAll(f11800h, "");
    }
}
