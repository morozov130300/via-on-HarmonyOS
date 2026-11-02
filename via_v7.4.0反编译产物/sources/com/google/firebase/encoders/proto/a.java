package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f4030a;

    /* renamed from: b, reason: collision with root package name */
    public Protobuf.IntEncoding f4031b = Protobuf.IntEncoding.DEFAULT;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    public static final class C0048a implements Protobuf {

        /* renamed from: a, reason: collision with root package name */
        public final int f4032a;

        /* renamed from: b, reason: collision with root package name */
        public final Protobuf.IntEncoding f4033b;

        public C0048a(int i10, Protobuf.IntEncoding intEncoding) {
            this.f4032a = i10;
            this.f4033b = intEncoding;
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
            return this.f4032a == protobuf.tag() && this.f4033b.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f4032a) + (this.f4033b.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f4033b;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f4032a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f4032a + "intEncoding=" + this.f4033b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public Protobuf a() {
        return new C0048a(this.f4030a, this.f4031b);
    }

    public a c(int i10) {
        this.f4030a = i10;
        return this;
    }
}
