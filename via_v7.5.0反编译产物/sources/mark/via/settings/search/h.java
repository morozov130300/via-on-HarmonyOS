package mark.via.settings.search;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import x8.s1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f10388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f10389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f10391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10392f;

    public h(Context context, Class cls, int... iArr) {
        this(context, cls, null, iArr);
    }

    public static boolean g(String str) {
        if (str == null) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (a1.c.e(str.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public void a(int i10, int i11, int i12) {
        e(this.f10388b.getName() + "." + i10, i10, this.f10387a.getString(i11), this.f10387a.getResources().getStringArray(i12));
    }

    public void b(int i10, int i11, String... strArr) {
        c(this.f10388b.getName() + "." + i10, i10, i11, strArr);
    }

    public void c(String str, int i10, int i11, String... strArr) {
        d(str, i10, this.f10387a.getString(i11), strArr);
    }

    public void d(String str, int i10, String str2, String... strArr) {
        if (!this.f10392f && strArr != null) {
            ArrayList arrayList = new ArrayList();
            for (String str3 : strArr) {
                if (!g(str3)) {
                    arrayList.add(str3);
                }
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        e(str, i10, str2, strArr);
    }

    public final void e(String str, int i10, String str2, String[] strArr) {
        this.f10390d.add(new b(str, str2, this.f10389c, this.f10388b, this.f10391e, i10, strArr));
    }

    public List f() {
        return new ArrayList(this.f10390d);
    }

    public h(Context context, Class cls, Bundle bundle, int... iArr) {
        this.f10390d = new ArrayList();
        this.f10387a = context;
        this.f10388b = cls;
        this.f10391e = bundle;
        this.f10392f = "zh".equals(s1.b(context));
        this.f10389c = new String[iArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr = this.f10389c;
            if (i10 >= strArr.length) {
                return;
            }
            strArr[i10] = context.getString(iArr[i10]);
            i10++;
        }
    }
}
