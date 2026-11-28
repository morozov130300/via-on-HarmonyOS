package u2;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements u2.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f12839d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f12840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f12842c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements e.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f12843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12844b;

        public a(byte[] bArr, int[] iArr) {
            this.f12843a = bArr;
            this.f12844b = iArr;
        }

        @Override // u2.e.d
        public void a(InputStream inputStream, int i10) throws IOException {
            try {
                inputStream.read(this.f12843a, this.f12844b[0], i10);
                int[] iArr = this.f12844b;
                iArr[0] = iArr[0] + i10;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f12846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12847b;

        public b(byte[] bArr, int i10) {
            this.f12846a = bArr;
            this.f12847b = i10;
        }
    }

    public f(File file, int i10) {
        this.f12840a = file;
        this.f12841b = i10;
    }

    @Override // u2.a
    public void a() {
        CommonUtils.e(this.f12842c, "There was a problem closing the Crashlytics log file.");
        this.f12842c = null;
    }

    @Override // u2.a
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f12839d);
        }
        return null;
    }

    @Override // u2.a
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i10 = bVarG.f12847b;
        byte[] bArr = new byte[i10];
        System.arraycopy(bVarG.f12846a, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // u2.a
    public void d() {
        a();
        this.f12840a.delete();
    }

    @Override // u2.a
    public void e(long j10, String str) {
        h();
        f(j10, str);
    }

    public final void f(long j10, String str) {
        if (this.f12842c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i10 = this.f12841b / 4;
            if (str.length() > i10) {
                str = "..." + str.substring(str.length() - i10);
            }
            this.f12842c.f(String.format(Locale.US, "%d %s%n", Long.valueOf(j10), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f12839d));
            while (!this.f12842c.m() && this.f12842c.x() > this.f12841b) {
                this.f12842c.t();
            }
        } catch (IOException e10) {
            q2.f.f().e("There was a problem writing to the Crashlytics log.", e10);
        }
    }

    public final b g() {
        if (!this.f12840a.exists()) {
            return null;
        }
        h();
        e eVar = this.f12842c;
        if (eVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[eVar.x()];
        try {
            this.f12842c.k(new a(bArr, iArr));
        } catch (IOException e10) {
            q2.f.f().e("A problem occurred while reading the Crashlytics log file.", e10);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.f12842c == null) {
            try {
                this.f12842c = new e(this.f12840a);
            } catch (IOException e10) {
                q2.f.f().e("Could not open log file: " + this.f12840a, e10);
            }
        }
    }
}
