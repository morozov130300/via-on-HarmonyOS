package f1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f4414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4415b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable f4416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f4417b;

        @Override // f1.e.a
        public e a() {
            String str = "";
            if (this.f4416a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f4416a, this.f4417b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // f1.e.a
        public e.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f4416a = iterable;
            return this;
        }

        @Override // f1.e.a
        public e.a c(byte[] bArr) {
            this.f4417b = bArr;
            return this;
        }
    }

    @Override // f1.e
    public Iterable b() {
        return this.f4414a;
    }

    @Override // f1.e
    public byte[] c() {
        return this.f4415b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f4414a.equals(eVar.b())) {
                if (Arrays.equals(this.f4415b, eVar instanceof a ? ((a) eVar).f4415b : eVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4414a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4415b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f4414a + ", extras=" + Arrays.toString(this.f4415b) + "}";
    }

    public a(Iterable iterable, byte[] bArr) {
        this.f4414a = iterable;
        this.f4415b = bArr;
    }
}
