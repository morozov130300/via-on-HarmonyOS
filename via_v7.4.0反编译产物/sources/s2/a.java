package s2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11655a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11656b;

    /* renamed from: c, reason: collision with root package name */
    public final List f11657c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11658d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11659e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11660f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11661g;

    /* renamed from: h, reason: collision with root package name */
    public final p2.e f11662h;

    public a(String str, String str2, List list, String str3, String str4, String str5, String str6, p2.e eVar) {
        this.f11655a = str;
        this.f11656b = str2;
        this.f11657c = list;
        this.f11658d = str3;
        this.f11659e = str4;
        this.f11660f = str5;
        this.f11661g = str6;
        this.f11662h = eVar;
    }

    public static a a(Context context, v vVar, String str, String str2, List list, p2.e eVar) throws PackageManager.NameNotFoundException {
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
