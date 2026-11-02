package s2;

import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends p {

    /* renamed from: a, reason: collision with root package name */
    public final u2.b0 f11665a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11666b;

    /* renamed from: c, reason: collision with root package name */
    public final File f11667c;

    public b(u2.b0 b0Var, String str, File file) {
        if (b0Var == null) {
            throw new NullPointerException("Null report");
        }
        this.f11665a = b0Var;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f11666b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f11667c = file;
    }

    @Override // s2.p
    public u2.b0 b() {
        return this.f11665a;
    }

    @Override // s2.p
    public File c() {
        return this.f11667c;
    }

    @Override // s2.p
    public String d() {
        return this.f11666b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f11665a.equals(pVar.b()) && this.f11666b.equals(pVar.d()) && this.f11667c.equals(pVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f11665a.hashCode() ^ 1000003) * 1000003) ^ this.f11666b.hashCode()) * 1000003) ^ this.f11667c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f11665a + ", sessionId=" + this.f11666b + ", reportFile=" + this.f11667c + "}";
    }
}
