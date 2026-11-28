package g5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(int i10) {
        return e(i10) || b(i10);
    }

    public static boolean b(int i10) {
        return i10 >= 200 && i10 < 300;
    }

    public static boolean c(int i10) {
        return i10 == 80;
    }

    public static boolean d(int i10) {
        return i10 > 0 && i10 < 100 && !c(i10);
    }

    public static boolean e(int i10) {
        return i10 >= 100 && i10 < 200;
    }

    public static boolean f(int i10) {
        return i10 == 95;
    }
}
