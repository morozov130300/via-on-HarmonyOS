package o;

import android.content.LocusId;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocusId f10859b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static LocusId a(String str) {
            return new LocusId(str);
        }
    }

    public l(String str) {
        this.f10858a = (String) x.g.d(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f10859b = a.a(str);
        } else {
            this.f10859b = null;
        }
    }

    public String a() {
        return this.f10858a;
    }

    public final String b() {
        return this.f10858a.length() + "_chars";
    }

    public LocusId c() {
        return this.f10859b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        String str = this.f10858a;
        if (str == null) {
            return lVar.f10858a == null;
        }
        return str.equals(lVar.f10858a);
    }

    public int hashCode() {
        String str = this.f10858a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
