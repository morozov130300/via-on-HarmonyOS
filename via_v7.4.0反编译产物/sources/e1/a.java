package e1;

import e1.e;
import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable f4698a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4699b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        public Iterable f4700a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f4701b;

        @Override // e1.e.a
        public e a() {
            String str = "";
            if (this.f4700a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f4700a, this.f4701b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e1.e.a
        public e.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f4700a = iterable;
            return this;
        }

        @Override // e1.e.a
        public e.a c(byte[] bArr) {
            this.f4701b = bArr;
            return this;
        }
    }

    public a(Iterable iterable, byte[] bArr) {
        this.f4698a = iterable;
        this.f4699b = bArr;
    }

    @Override // e1.e
    public Iterable b() {
        return this.f4698a;
    }

    @Override // e1.e
    public byte[] c() {
        return this.f4699b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f4698a.equals(eVar.b())) {
                if (Arrays.equals(this.f4699b, eVar instanceof a ? ((a) eVar).f4699b : eVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4698a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4699b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f4698a + ", extras=" + Arrays.toString(this.f4699b) + "}";
    }
}
