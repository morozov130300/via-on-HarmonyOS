package t2;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v2.b0 f12333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f12335c;

    public b(v2.b0 b0Var, String str, File file) {
        if (b0Var == null) {
            throw new NullPointerException("Null report");
        }
        this.f12333a = b0Var;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f12334b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f12335c = file;
    }

    @Override // t2.p
    public v2.b0 b() {
        return this.f12333a;
    }

    @Override // t2.p
    public File c() {
        return this.f12335c;
    }

    @Override // t2.p
    public String d() {
        return this.f12334b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f12333a.equals(pVar.b()) && this.f12334b.equals(pVar.d()) && this.f12335c.equals(pVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12333a.hashCode() ^ 1000003) * 1000003) ^ this.f12334b.hashCode()) * 1000003) ^ this.f12335c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f12333a + ", sessionId=" + this.f12334b + ", reportFile=" + this.f12335c + "}";
    }
}
