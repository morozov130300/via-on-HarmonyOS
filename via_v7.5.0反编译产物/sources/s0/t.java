package s0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebSettingsBoundaryInterface f12150a;

    public t(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.f12150a = webSettingsBoundaryInterface;
    }

    public r0.g a() {
        return p.d(this.f12150a.getUserAgentMetadataMap());
    }

    public void b(boolean z10) {
        this.f12150a.setAlgorithmicDarkeningAllowed(z10);
    }

    public void c(int i10) {
        this.f12150a.setForceDark(i10);
    }

    public void d(r0.g gVar) {
        this.f12150a.setUserAgentMetadataFromMap(p.a(gVar));
    }

    public void e(int i10) {
        this.f12150a.setWebauthnSupport(i10);
    }
}
