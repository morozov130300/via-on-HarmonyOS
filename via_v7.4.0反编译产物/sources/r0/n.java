package r0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final WebSettingsBoundaryInterface f11479a;

    public n(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.f11479a = webSettingsBoundaryInterface;
    }

    public q0.d a() {
        return m.c(this.f11479a.getUserAgentMetadataMap());
    }

    public void b(boolean z10) {
        this.f11479a.setAlgorithmicDarkeningAllowed(z10);
    }

    public void c(int i10) {
        this.f11479a.setForceDark(i10);
    }

    public void d(q0.d dVar) {
        this.f11479a.setUserAgentMetadataFromMap(m.a(dVar));
    }

    public void e(int i10) {
        this.f11479a.setWebauthnSupport(i10);
    }
}
