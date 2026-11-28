package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends Writer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f873c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StringBuilder f874e = new StringBuilder(128);

    public v0(String str) {
        this.f873c = str;
    }

    public final void a() {
        if (this.f874e.length() > 0) {
            Log.d(this.f873c, this.f874e.toString());
            StringBuilder sb2 = this.f874e;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                a();
            } else {
                this.f874e.append(c10);
            }
        }
    }
}
