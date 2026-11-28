package a1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ec.c f10a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f11b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List f12c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f13a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f14b;

        public List a() {
            return this.f14b;
        }

        public j b() {
            return this.f13a;
        }

        public boolean c() {
            return (a() == null || b() == null) ? false : true;
        }

        public b d(h hVar) {
            if (hVar != null) {
                List list = this.f14b;
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.f14b = arrayList;
                    arrayList.add(hVar);
                    return this;
                }
                if (!list.contains(hVar)) {
                    this.f14b.add(hVar);
                }
            }
            return this;
        }

        public b(List list) {
            if (list != null) {
                this.f14b = new ArrayList(list);
            }
            this.f13a = new a1.b();
        }
    }

    public static void a(h hVar) {
        if (hVar == null || hVar.a() == null || hVar.a().size() == 0) {
            return;
        }
        d(new b(f12c).d(hVar));
    }

    public static short b(byte[] bArr, byte[] bArr2, int i10) {
        int i11 = i10 % 8;
        short s10 = (short) (bArr2[i10] & 255);
        return (bArr[i10 / 8] & g.f21a[i11]) != 0 ? (short) (s10 | 256) : s10;
    }

    public static int c(char c10) {
        int i10 = c10 - 19968;
        if (i10 < 0 || i10 >= 7000) {
            return (7000 > i10 || i10 >= 14000) ? b(f.f19a, f.f20b, c10 - 33968) : b(e.f17a, e.f18b, c10 - 26968);
        }
        return b(d.f15a, d.f16b, i10);
    }

    public static void d(b bVar) {
        if (bVar == null) {
            f12c = null;
            f10a = null;
            f11b = null;
        } else if (bVar.c()) {
            f12c = Collections.unmodifiableList(bVar.a());
            f10a = k.a(bVar.a());
            f11b = bVar.b();
        }
    }

    public static boolean e(char c10) {
        return (19968 <= c10 && c10 <= 40869 && c(c10) > 0) || 12295 == c10;
    }

    public static String f(char c10) {
        if (e(c10)) {
            return c10 == 12295 ? "LING" : g.f22b[c(c10)];
        }
        return String.valueOf(c10);
    }

    public static String g(String str, String str2) {
        return a1.a.b(str, f10a, f12c, str2, f11b);
    }
}
