package d1;

import com.google.android.datatransport.Priority;
import d1.p;
import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends p {

    /* renamed from: a, reason: collision with root package name */
    public final String f4489a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4490b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f4491c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends p.a {

        /* renamed from: a, reason: collision with root package name */
        public String f4492a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f4493b;

        /* renamed from: c, reason: collision with root package name */
        public Priority f4494c;

        @Override // d1.p.a
        public p a() {
            String str = "";
            if (this.f4492a == null) {
                str = " backendName";
            }
            if (this.f4494c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f4492a, this.f4493b, this.f4494c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d1.p.a
        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f4492a = str;
            return this;
        }

        @Override // d1.p.a
        public p.a c(byte[] bArr) {
            this.f4493b = bArr;
            return this;
        }

        @Override // d1.p.a
        public p.a d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f4494c = priority;
            return this;
        }
    }

    public d(String str, byte[] bArr, Priority priority) {
        this.f4489a = str;
        this.f4490b = bArr;
        this.f4491c = priority;
    }

    @Override // d1.p
    public String b() {
        return this.f4489a;
    }

    @Override // d1.p
    public byte[] c() {
        return this.f4490b;
    }

    @Override // d1.p
    public Priority d() {
        return this.f4491c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f4489a.equals(pVar.b())) {
                if (Arrays.equals(this.f4490b, pVar instanceof d ? ((d) pVar).f4490b : pVar.c()) && this.f4491c.equals(pVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f4489a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4490b)) * 1000003) ^ this.f4491c.hashCode();
    }
}
