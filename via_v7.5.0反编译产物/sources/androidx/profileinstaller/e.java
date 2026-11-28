package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l.b f1010a = l.b.t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1011b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f1012c = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f1015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f1016d;

        public b(int i10, int i11, long j10, long j11) {
            this.f1013a = i10;
            this.f1014b = i11;
            this.f1015c = j10;
            this.f1016d = j11;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f1013a);
                dataOutputStream.writeInt(this.f1014b);
                dataOutputStream.writeLong(this.f1015c);
                dataOutputStream.writeLong(this.f1016d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (this.f1014b == bVar.f1014b && this.f1015c == bVar.f1015c && this.f1013a == bVar.f1013a && this.f1016d == bVar.f1016d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1014b), Long.valueOf(this.f1015c), Integer.valueOf(this.f1013a), Long.valueOf(this.f1016d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1019c;

        public c(int i10, boolean z10, boolean z11) {
            this.f1017a = i10;
            this.f1019c = z11;
            this.f1018b = z10;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i10, boolean z10, boolean z11) {
        c cVar = new c(i10, z10, z11);
        f1012c = cVar;
        f1010a.p(cVar);
        return f1012c;
    }

    public static c c(Context context, boolean z10) {
        b bVarA;
        int i10;
        c cVar;
        if (!z10 && (cVar = f1012c) != null) {
            return cVar;
        }
        synchronized (f1011b) {
            if (!z10) {
                try {
                    c cVar2 = f1012c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i11 = Build.VERSION.SDK_INT;
            int i12 = 0;
            if (i11 >= 28 && i11 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z11 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z12 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(131072, z11, z12);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f1015c == jA && (i10 = bVarA.f1014b) != 2) {
                        i12 = i10;
                    } else if (z11) {
                        i12 = 1;
                    } else if (z12) {
                        i12 = 2;
                    }
                    if (z10 && z12 && i12 != 1) {
                        i12 = 2;
                    }
                    int i13 = (bVarA == null || bVarA.f1014b != 2 || i12 != 1 || length >= bVarA.f1016d) ? i12 : 3;
                    b bVar = new b(1, i13, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i13 = 196608;
                        }
                    }
                    return b(i13, z11, z12);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z11, z12);
                }
            }
            return b(262144, false, false);
        }
    }
}
