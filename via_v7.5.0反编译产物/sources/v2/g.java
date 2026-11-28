package v2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g extends b0.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13169b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f13171b;

        @Override // v2.b0.d.b.a
        public b0.d.b a() {
            String str = "";
            if (this.f13170a == null) {
                str = " filename";
            }
            if (this.f13171b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new g(this.f13170a, this.f13171b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.d.b.a
        public b0.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f13171b = bArr;
            return this;
        }

        @Override // v2.b0.d.b.a
        public b0.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f13170a = str;
            return this;
        }
    }

    @Override // v2.b0.d.b
    public byte[] b() {
        return this.f13169b;
    }

    @Override // v2.b0.d.b
    public String c() {
        return this.f13168a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.d.b) {
            b0.d.b bVar = (b0.d.b) obj;
            if (this.f13168a.equals(bVar.c())) {
                if (Arrays.equals(this.f13169b, bVar instanceof g ? ((g) bVar).f13169b : bVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f13168a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13169b);
    }

    public String toString() {
        return "File{filename=" + this.f13168a + ", contents=" + Arrays.toString(this.f13169b) + "}";
    }

    public g(String str, byte[] bArr) {
        this.f13168a = str;
        this.f13169b = bArr;
    }
}
