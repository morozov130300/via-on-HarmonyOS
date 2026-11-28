package e1;

import com.google.android.datatransport.Priority;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Priority f4123c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f4125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Priority f4126c;

        @Override // e1.p.a
        public p a() {
            String str = "";
            if (this.f4124a == null) {
                str = " backendName";
            }
            if (this.f4126c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f4124a, this.f4125b, this.f4126c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e1.p.a
        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f4124a = str;
            return this;
        }

        @Override // e1.p.a
        public p.a c(byte[] bArr) {
            this.f4125b = bArr;
            return this;
        }

        @Override // e1.p.a
        public p.a d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f4126c = priority;
            return this;
        }
    }

    @Override // e1.p
    public String b() {
        return this.f4121a;
    }

    @Override // e1.p
    public byte[] c() {
        return this.f4122b;
    }

    @Override // e1.p
    public Priority d() {
        return this.f4123c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f4121a.equals(pVar.b())) {
                if (Arrays.equals(this.f4122b, pVar instanceof d ? ((d) pVar).f4122b : pVar.c()) && this.f4123c.equals(pVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f4121a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4122b)) * 1000003) ^ this.f4123c.hashCode();
    }

    public d(String str, byte[] bArr, Priority priority) {
        this.f4121a = str;
        this.f4122b = bArr;
        this.f4123c = priority;
    }
}
