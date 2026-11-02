package f3;

import c3.g;
import com.google.firebase.encoders.EncodingException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5892a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5893b = false;

    /* renamed from: c, reason: collision with root package name */
    public c3.c f5894c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.firebase.encoders.proto.b f5895d;

    public f(com.google.firebase.encoders.proto.b bVar) {
        this.f5895d = bVar;
    }

    public final void a() {
        if (this.f5892a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f5892a = true;
    }

    public void b(c3.c cVar, boolean z10) {
        this.f5892a = false;
        this.f5894c = cVar;
        this.f5893b = z10;
    }

    @Override // c3.g
    public g e(String str) {
        a();
        this.f5895d.h(this.f5894c, str, this.f5893b);
        return this;
    }

    @Override // c3.g
    public g f(boolean z10) {
        a();
        this.f5895d.n(this.f5894c, z10, this.f5893b);
        return this;
    }
}
