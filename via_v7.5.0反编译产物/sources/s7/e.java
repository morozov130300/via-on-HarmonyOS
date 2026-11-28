package s7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends d {
    public static int a(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static int b(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static int c(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i10 < i11) {
                return i11;
            }
            return i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static a d(int i10, int i11) {
        return a.f12216n.a(i10, i11, -1);
    }

    public static c e(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? c.f12224o.a() : new c(i10, i11 - 1);
    }
}
