package t2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v implements w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f12467g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12468h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f12469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k3.e f12472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f12473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f12474f;

    public v(Context context, String str, k3.e eVar, s sVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f12470b = context;
        this.f12471c = str;
        this.f12472d = eVar;
        this.f12473e = sVar;
        this.f12469a = new x();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return f12467g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    @Override // t2.w
    public synchronized String a() {
        try {
            String str = this.f12474f;
            if (str != null) {
                return str;
            }
            q2.f.f().i("Determining Crashlytics installation ID...");
            SharedPreferences sharedPreferencesS = CommonUtils.s(this.f12470b);
            String string = sharedPreferencesS.getString("firebase.installation.id", null);
            q2.f.f().i("Cached Firebase Installation ID: " + string);
            if (this.f12473e.d()) {
                String strD = d();
                q2.f.f().i("Fetched Firebase Installation ID: " + strD);
                if (strD == null) {
                    strD = string == null ? c() : string;
                }
                if (strD.equals(string)) {
                    this.f12474f = l(sharedPreferencesS);
                } else {
                    this.f12474f = b(strD, sharedPreferencesS);
                }
            } else if (k(string)) {
                this.f12474f = l(sharedPreferencesS);
            } else {
                this.f12474f = b(c(), sharedPreferencesS);
            }
            if (this.f12474f == null) {
                q2.f.f().k("Unable to determine Crashlytics Install Id, creating a new one.");
                this.f12474f = b(c(), sharedPreferencesS);
            }
            q2.f.f().i("Crashlytics installation ID: " + this.f12474f);
            return this.f12474f;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        q2.f.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    public final String d() {
        try {
            return (String) u0.f(this.f12472d.getId());
        } catch (Exception e10) {
            q2.f.f().l("Failed to retrieve Firebase Installations ID.", e10);
            return null;
        }
    }

    public String f() {
        return this.f12471c;
    }

    public String g() {
        return this.f12469a.a(this.f12470b);
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
        return str.replaceAll(f12468h, "");
    }
}
