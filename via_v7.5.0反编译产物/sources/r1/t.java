package r1;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t extends r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final WeakReference f11948f = new WeakReference(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference f11949e;

    public t(byte[] bArr) {
        super(bArr);
        this.f11949e = f11948f;
    }

    @Override // r1.r
    public final byte[] b0() {
        byte[] bArrC0;
        synchronized (this) {
            try {
                bArrC0 = (byte[]) this.f11949e.get();
                if (bArrC0 == null) {
                    bArrC0 = c0();
                    this.f11949e = new WeakReference(bArrC0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrC0;
    }

    public abstract byte[] c0();
}
