package com.google.firebase.encoders.proto;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Protobuf.IntEncoding f3328b = Protobuf.IntEncoding.DEFAULT;

    /* JADX INFO: renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0042a implements Protobuf {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Protobuf.IntEncoding f3330b;

        public C0042a(int i10, Protobuf.IntEncoding intEncoding) {
            this.f3329a = i10;
            this.f3330b = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.f3329a == protobuf.tag() && this.f3330b.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f3329a) + (this.f3330b.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f3330b;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f3329a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f3329a + "intEncoding=" + this.f3330b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public Protobuf a() {
        return new C0042a(this.f3327a, this.f3328b);
    }

    public a c(int i10) {
        this.f3327a = i10;
        return this;
    }
}
