package r1;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import u1.m0;
import u1.n0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends m0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11946d;

    public r(byte[] bArr) {
        u1.f.a(bArr.length == 25);
        this.f11946d = Arrays.hashCode(bArr);
    }

    public static byte[] a0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // u1.n0
    public final int b() {
        return this.f11946d;
    }

    public abstract byte[] b0();

    @Override // u1.n0
    public final z1.a c() {
        return z1.b.b0(b0());
    }

    public final boolean equals(Object obj) {
        z1.a aVarC;
        if (obj != null && (obj instanceof n0)) {
            try {
                n0 n0Var = (n0) obj;
                if (n0Var.b() == this.f11946d && (aVarC = n0Var.c()) != null) {
                    return Arrays.equals(b0(), (byte[]) z1.b.a0(aVarC));
                }
                return false;
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11946d;
    }
}
