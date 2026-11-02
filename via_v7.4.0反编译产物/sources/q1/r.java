package q1;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import t1.m0;
import t1.n0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class r extends m0 {

    /* renamed from: d, reason: collision with root package name */
    public final int f11256d;

    public r(byte[] bArr) {
        t1.f.a(bArr.length == 25);
        this.f11256d = Arrays.hashCode(bArr);
    }

    public static byte[] a0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // t1.n0
    public final int b() {
        return this.f11256d;
    }

    public abstract byte[] b0();

    @Override // t1.n0
    public final y1.a c() {
        return y1.b.b0(b0());
    }

    public final boolean equals(Object obj) {
        y1.a aVarC;
        if (obj != null && (obj instanceof n0)) {
            try {
                n0 n0Var = (n0) obj;
                if (n0Var.b() == this.f11256d && (aVarC = n0Var.c()) != null) {
                    return Arrays.equals(b0(), (byte[]) y1.b.a0(aVarC));
                }
                return false;
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11256d;
    }
}
