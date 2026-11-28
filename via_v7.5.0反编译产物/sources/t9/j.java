package t9;

import c6.a2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import x8.c1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12595b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s6.b f12597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12598e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f12594a = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12596c = new Object();

    public j(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("filePath == null || filePath.isEmpty()");
        }
        this.f12595b = str;
    }

    public void b() {
        synchronized (this.f12596c) {
            try {
                s6.b bVar = this.f12597d;
                if (bVar != null) {
                    bVar.dispose();
                }
                final long j10 = this.f12598e + 1;
                this.f12598e = j10;
                this.f12597d = a7.a.c().e(new Runnable() { // from class: t9.i
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.f12592c.c(j10);
                    }
                }, 200L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(long j10) throws Throwable {
        synchronized (this.f12596c) {
            try {
                if (j10 != this.f12598e) {
                    return;
                }
                this.f12597d = null;
                ArrayList arrayList = new ArrayList(this.f12594a);
                File file = new File(this.f12595b);
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    return;
                }
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                c1.R(file, arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List d() {
        ArrayList arrayList;
        synchronized (this.f12596c) {
            arrayList = new ArrayList(this.f12594a);
        }
        return arrayList;
    }

    public boolean e(String str, boolean z10) {
        String strF = a2.f1958a.f(str);
        synchronized (this.f12596c) {
            try {
                if (this.f12594a.contains(strF)) {
                    return false;
                }
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() throws Throwable {
        String str = this.f12595b;
        if (str == null || str.isEmpty()) {
            return;
        }
        List listP = c1.P(new File(this.f12595b));
        synchronized (this.f12596c) {
            try {
                this.f12594a.clear();
                if (listP != null) {
                    this.f12594a.addAll(listP);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean g(String str, boolean z10) {
        String strF = a2.f1958a.f(str);
        synchronized (this.f12596c) {
            try {
                if (z10 != this.f12594a.contains(strF)) {
                    return false;
                }
                if (z10) {
                    this.f12594a.remove(strF);
                } else {
                    this.f12594a.add(strF);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
