package p9;

import android.content.Context;
import c6.h1;
import c6.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import r8.f;
import u9.e;
import x8.a0;
import x8.c1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static h1 a() {
        return x.f2131a.c();
    }

    public static synchronized void b(Context context) {
        try {
            e eVar = new e(context, "features");
            x xVar = x.f2131a;
            boolean z10 = xVar.b() && a0.h();
            File file = new File(context.getFilesDir(), z10 ? "features_cn" : "features");
            String str = z10 ? "last_fetched_cn" : "last_fetched";
            if (xVar.e(c1.O(file), eVar.getLong(str, 0L), System.currentTimeMillis())) {
                return;
            }
            String string = eVar.getString("uid", null);
            if (string == null || string.isEmpty()) {
                string = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.ROOT) + a0.b();
                eVar.putString("uid", string);
            }
            String strA = xVar.a(string, "Mozilla/5.0 (Linux; Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36 Via/7.5.0");
            f.a().g(strA != null);
            if (strA == null) {
                return;
            }
            File file2 = new File(context.getFilesDir(), "features.tmp");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(strA.getBytes(k8.a.f7218a));
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    if (!file2.renameTo(file)) {
                        throw new IOException("Could not replace remote configuration cache");
                    }
                    eVar.putLong(str, System.currentTimeMillis());
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (IOException e10) {
                tc.a.j(e10);
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
