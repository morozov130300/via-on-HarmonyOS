package t2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q2.e f12330h;

    public a(String str, String str2, List list, String str3, String str4, String str5, String str6, q2.e eVar) {
        this.f12323a = str;
        this.f12324b = str2;
        this.f12325c = list;
        this.f12326d = str3;
        this.f12327e = str4;
        this.f12328f = str5;
        this.f12329g = str6;
        this.f12330h = eVar;
    }

    public static a a(Context context, v vVar, String str, String str2, List list, q2.e eVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = vVar.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String string = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, list, strG, packageName, string, str3, eVar);
    }
}
