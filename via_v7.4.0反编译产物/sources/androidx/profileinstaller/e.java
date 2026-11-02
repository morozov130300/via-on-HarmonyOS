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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final l.b f1107a = l.b.r();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1108b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f1109c = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f1110a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1111b;

        /* renamed from: c, reason: collision with root package name */
        public final long f1112c;

        /* renamed from: d, reason: collision with root package name */
        public final long f1113d;

        public b(int i10, int i11, long j10, long j11) {
            this.f1110a = i10;
            this.f1111b = i11;
            this.f1112c = j10;
            this.f1113d = j11;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } finally {
            }
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f1110a);
                dataOutputStream.writeInt(this.f1111b);
                dataOutputStream.writeLong(this.f1112c);
                dataOutputStream.writeLong(this.f1113d);
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
                if (this.f1111b == bVar.f1111b && this.f1112c == bVar.f1112c && this.f1110a == bVar.f1110a && this.f1113d == bVar.f1113d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1111b), Long.valueOf(this.f1112c), Integer.valueOf(this.f1110a), Long.valueOf(this.f1113d));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f1114a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1115b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f1116c;

        public c(int i10, boolean z10, boolean z11) {
            this.f1114a = i10;
            this.f1116c = z11;
            this.f1115b = z10;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i10, boolean z10, boolean z11) {
        c cVar = new c(i10, z10, z11);
        f1109c = cVar;
        f1107a.n(cVar);
        return f1109c;
    }

    public static c c(Context context, boolean z10) {
        b bVarA;
        int i10;
        c cVar;
        if (!z10 && (cVar = f1109c) != null) {
            return cVar;
        }
        synchronized (f1108b) {
            if (!z10) {
                try {
                    c cVar2 = f1109c;
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
                    if (bVarA != null && bVarA.f1112c == jA && (i10 = bVarA.f1111b) != 2) {
                        i12 = i10;
                    } else if (z11) {
                        i12 = 1;
                    } else if (z12) {
                        i12 = 2;
                    }
                    if (z10 && z12 && i12 != 1) {
                        i12 = 2;
                    }
                    int i13 = (bVarA == null || bVarA.f1111b != 2 || i12 != 1 || length >= bVarA.f1113d) ? i12 : 3;
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
