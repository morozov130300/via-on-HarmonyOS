package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import k0.m;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0018c f997c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1002h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k0.d[] f1004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f1005k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1003i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f998d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0018c interfaceC0018c, String str, String str2, String str3, File file) {
        this.f995a = assetManager;
        this.f996b = executor;
        this.f997c = interfaceC0018c;
        this.f1000f = str;
        this.f1001g = str2;
        this.f1002h = str3;
        this.f999e = file;
    }

    public static byte[] d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || i10 > 34) {
            return null;
        }
        switch (i10) {
            case 24:
            case 25:
                return m.f7144e;
            case 26:
                return m.f7143d;
            case 27:
                return m.f7142c;
            case 28:
            case 29:
            case 30:
                return m.f7141b;
            case 31:
            case 32:
            case 33:
            case 34:
                return m.f7140a;
            default:
                return null;
        }
    }

    public static boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || i10 > 34) {
            return false;
        }
        if (i10 != 24 && i10 != 25) {
            switch (i10) {
                case 31:
                case 32:
                case 33:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final b b(k0.d[] dVarArr, byte[] bArr) {
        try {
            InputStream inputStreamG = g(this.f995a, this.f1002h);
            if (inputStreamG == null) {
                if (inputStreamG != null) {
                    inputStreamG.close();
                }
                return null;
            }
            try {
                this.f1004j = d.q(inputStreamG, d.o(inputStreamG, d.f1009b), bArr, dVarArr);
                inputStreamG.close();
                return this;
            } catch (Throwable th) {
                try {
                    inputStreamG.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            this.f997c.b(9, e10);
        } catch (IOException e11) {
            this.f997c.b(7, e11);
        } catch (IllegalStateException e12) {
            this.f1004j = null;
            this.f997c.b(8, e12);
        }
    }

    public final void c() {
        if (!this.f1003i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f998d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f999e.exists()) {
            try {
                this.f999e.createNewFile();
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f999e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f1003i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f1001g);
        } catch (FileNotFoundException e10) {
            this.f997c.b(6, e10);
            return null;
        } catch (IOException e11) {
            this.f997c.b(7, e11);
            return null;
        }
    }

    public final InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f997c.a(5, null);
            }
            return null;
        }
    }

    public b h() {
        b bVarB;
        c();
        if (this.f998d != null) {
            InputStream inputStreamF = f(this.f995a);
            if (inputStreamF != null) {
                this.f1004j = i(inputStreamF);
            }
            k0.d[] dVarArr = this.f1004j;
            if (dVarArr != null && j() && (bVarB = b(dVarArr, this.f998d)) != null) {
                return bVarB;
            }
        }
        return this;
    }

    public final k0.d[] i(InputStream inputStream) {
        try {
            try {
                try {
                    k0.d[] dVarArrW = d.w(inputStream, d.o(inputStream, d.f1008a), this.f1000f);
                    try {
                        inputStream.close();
                        return dVarArrW;
                    } catch (IOException e10) {
                        this.f997c.b(7, e10);
                        return dVarArrW;
                    }
                } catch (IllegalStateException e11) {
                    this.f997c.b(8, e11);
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        this.f997c.b(7, e12);
                    }
                    return null;
                }
            } catch (IOException e13) {
                this.f997c.b(7, e13);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.f997c.b(7, e14);
            }
            throw th;
        }
    }

    public final void k(final int i10, final Object obj) {
        this.f996b.execute(new Runnable() { // from class: k0.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f7120c.f997c.b(i10, obj);
            }
        });
    }

    public b l() {
        k0.d[] dVarArr = this.f1004j;
        byte[] bArr = this.f998d;
        if (dVarArr != null && bArr != null) {
            c();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    d.E(byteArrayOutputStream, bArr);
                    if (!d.B(byteArrayOutputStream, bArr, dVarArr)) {
                        this.f997c.b(5, null);
                        this.f1004j = null;
                        byteArrayOutputStream.close();
                        return this;
                    }
                    this.f1005k = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    this.f1004j = null;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                this.f997c.b(7, e10);
            } catch (IllegalStateException e11) {
                this.f997c.b(8, e11);
            }
        }
        return this;
    }

    public boolean m() {
        byte[] bArr = this.f1005k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f999e);
                    try {
                        k0.e.l(byteArrayInputStream, fileOutputStream);
                        k(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        this.f1005k = null;
                        this.f1004j = null;
                        return true;
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                this.f1005k = null;
                this.f1004j = null;
                throw th5;
            }
        } catch (FileNotFoundException e10) {
            k(6, e10);
            this.f1005k = null;
            this.f1004j = null;
            return false;
        } catch (IOException e11) {
            k(7, e11);
            this.f1005k = null;
            this.f1004j = null;
            return false;
        }
    }
}
