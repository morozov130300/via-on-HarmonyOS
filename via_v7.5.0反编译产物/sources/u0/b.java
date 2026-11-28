package u0;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u6.d f12729a = new u6.d() { // from class: u0.a
        @Override // u6.d
        public final boolean a() {
            return b.a();
        }
    };

    public static /* synthetic */ boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b() {
        return t0.a.a(f12729a);
    }
}
