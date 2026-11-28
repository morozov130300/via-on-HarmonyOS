package q6;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11820a = p6.a.d(new Callable() { // from class: q6.a
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return b.a.f11821a;
        }
    });

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f11821a = new d(new Handler(Looper.getMainLooper()), true);
    }

    public static p b() {
        return p6.a.e(f11820a);
    }
}
