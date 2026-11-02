package t2;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import t2.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements t2.a {

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f12106d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final File f12107a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12108b;

    /* renamed from: c, reason: collision with root package name */
    public e f12109c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements e.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f12110a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12111b;

        public a(byte[] bArr, int[] iArr) {
            this.f12110a = bArr;
            this.f12111b = iArr;
        }

        @Override // t2.e.d
        public void a(InputStream inputStream, int i10) throws IOException {
            try {
                inputStream.read(this.f12110a, this.f12111b[0], i10);
                int[] iArr = this.f12111b;
                iArr[0] = iArr[0] + i10;
            } finally {
                inputStream.close();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f12113a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12114b;

        public b(byte[] bArr, int i10) {
            this.f12113a = bArr;
            this.f12114b = i10;
        }
    }

    public f(File file, int i10) {
        this.f12107a = file;
        this.f12108b = i10;
    }

    @Override // t2.a
    public void a() throws IOException {
        CommonUtils.e(this.f12109c, "There was a problem closing the Crashlytics log file.");
        this.f12109c = null;
    }

    @Override // t2.a
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f12106d);
        }
        return null;
    }

    @Override // t2.a
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i10 = bVarG.f12114b;
        byte[] bArr = new byte[i10];
        System.arraycopy(bVarG.f12113a, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // t2.a
    public void d() throws IOException {
        a();
        this.f12107a.delete();
    }

    @Override // t2.a
    public void e(long j10, String str) {
        h();
        f(j10, str);
    }

    public final void f(long j10, String str) {
        if (this.f12109c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i10 = this.f12108b / 4;
            if (str.length() > i10) {
                str = "..." + str.substring(str.length() - i10);
            }
            this.f12109c.g(String.format(Locale.US, "%d %s%n", Long.valueOf(j10), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f12106d));
            while (!this.f12109c.m() && this.f12109c.x() > this.f12108b) {
                this.f12109c.t();
            }
        } catch (IOException e10) {
            p2.f.f().e("There was a problem writing to the Crashlytics log.", e10);
        }
    }

    public final b g() {
        if (!this.f12107a.exists()) {
            return null;
        }
        h();
        e eVar = this.f12109c;
        if (eVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[eVar.x()];
        try {
            this.f12109c.k(new a(bArr, iArr));
        } catch (IOException e10) {
            p2.f.f().e("A problem occurred while reading the Crashlytics log file.", e10);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.f12109c == null) {
            try {
                this.f12109c = new e(this.f12107a);
            } catch (IOException e10) {
                p2.f.f().e("Could not open log file: " + this.f12107a, e10);
            }
        }
    }
}
