package q1;

import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t extends r {

    /* renamed from: f, reason: collision with root package name */
    public static final WeakReference f11258f = new WeakReference(null);

    /* renamed from: e, reason: collision with root package name */
    public WeakReference f11259e;

    public t(byte[] bArr) {
        super(bArr);
        this.f11259e = f11258f;
    }

    @Override // q1.r
    public final byte[] b0() {
        byte[] bArrC0;
        synchronized (this) {
            try {
                bArrC0 = (byte[]) this.f11259e.get();
                if (bArrC0 == null) {
                    bArrC0 = c0();
                    this.f11259e = new WeakReference(bArrC0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrC0;
    }

    public abstract byte[] c0();
}
