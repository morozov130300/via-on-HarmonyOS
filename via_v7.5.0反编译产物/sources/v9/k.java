package v9;

import com.tuyafeng.wormhole.UserAgentPreset;
import x8.c4;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.m f13451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f13452b;

    public k(u9.m mVar, u9.l lVar) {
        this.f13451a = mVar;
        this.f13452b = lVar;
    }

    public static x.d c(int i10, String str) {
        UserAgentPreset userAgentPreset;
        if (i10 == 2) {
            userAgentPreset = UserAgentPreset.WINDOWS_CHROME;
        } else if (i10 == 3) {
            userAgentPreset = UserAgentPreset.WINDOWS_IE;
        } else if (i10 == 4) {
            userAgentPreset = UserAgentPreset.IPHONE;
        } else if (i10 == 5) {
            userAgentPreset = UserAgentPreset.SYMBIAN;
        } else {
            if (i10 == 6) {
                return new x.d(-999, str);
            }
            userAgentPreset = UserAgentPreset.DEFAULT;
        }
        return new x.d(Integer.valueOf(userAgentPreset.getPresetId()), userAgentPreset.getUserAgent());
    }

    @Override // v9.g
    public void a() {
        x.d dVarC = c(this.f13451a.getInt("agentchoose", 0), this.f13451a.getString("userAgentString", ""));
        this.f13452b.J(((Integer) dVarC.f14455a).intValue());
        if (c4.g(((Integer) dVarC.f14455a).intValue())) {
            this.f13452b.g2((String) dVarC.f14456b);
        }
    }

    @Override // v9.g
    public int b() {
        return 6;
    }
}
