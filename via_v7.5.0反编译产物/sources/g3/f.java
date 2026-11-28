package g3;

import com.google.firebase.encoders.EncodingException;
import d3.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5508a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5509b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d3.c f5510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.firebase.encoders.proto.b f5511d;

    public f(com.google.firebase.encoders.proto.b bVar) {
        this.f5511d = bVar;
    }

    public final void a() {
        if (this.f5508a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f5508a = true;
    }

    public void b(d3.c cVar, boolean z10) {
        this.f5508a = false;
        this.f5510c = cVar;
        this.f5509b = z10;
    }

    @Override // d3.g
    public g e(String str) {
        a();
        this.f5511d.n(this.f5510c, str, this.f5509b);
        return this;
    }

    @Override // d3.g
    public g f(boolean z10) {
        a();
        this.f5511d.k(this.f5510c, z10, this.f5509b);
        return this;
    }
}
