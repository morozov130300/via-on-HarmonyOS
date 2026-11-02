package v9;

import i6.i0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13085b;

    /* renamed from: d, reason: collision with root package name */
    public y6.b f13087d;

    /* renamed from: e, reason: collision with root package name */
    public long f13088e;

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f13084a = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final Object f13086c = new Object();

    public j(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("filePath == null || filePath.isEmpty()");
        }
        this.f13085b = str;
    }

    public void b() {
        synchronized (this.f13086c) {
            try {
                y6.b bVar = this.f13087d;
                if (bVar != null) {
                    bVar.dispose();
                }
                final long j10 = this.f13088e + 1;
                this.f13088e = j10;
                this.f13087d = g7.a.c().e(new Runnable() { // from class: v9.i
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.f13082e.c(j10);
                    }
                }, 200L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(long j10) throws Throwable {
        synchronized (this.f13086c) {
            try {
                if (j10 != this.f13088e) {
                    return;
                }
                this.f13087d = null;
                ArrayList arrayList = new ArrayList(this.f13084a);
                File file = new File(this.f13085b);
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
        synchronized (this.f13086c) {
            arrayList = new ArrayList(this.f13084a);
        }
        return arrayList;
    }

    public boolean e(String str, boolean z10) {
        String strE = i0.f7006a.e(str);
        synchronized (this.f13086c) {
            try {
                if (this.f13084a.contains(strE)) {
                    return false;
                }
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() throws Throwable {
        String str = this.f13085b;
        if (str == null || str.isEmpty()) {
            return;
        }
        List listP = c1.P(new File(this.f13085b));
        synchronized (this.f13086c) {
            try {
                this.f13084a.clear();
                if (listP != null) {
                    this.f13084a.addAll(listP);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean g(String str, boolean z10) {
        String strE = i0.f7006a.e(str);
        synchronized (this.f13086c) {
            try {
                if (z10 != this.f13084a.contains(strE)) {
                    return false;
                }
                if (z10) {
                    this.f13084a.remove(strE);
                } else {
                    this.f13084a.add(strE);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
