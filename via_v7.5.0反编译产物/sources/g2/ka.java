package g2;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ka implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pa f5040a;

    public ka(pa paVar) {
        this.f5040a = paVar;
    }

    @Override // g2.va
    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f5040a.f().z(new ja(this, str, "_err", bundle));
            return;
        }
        pa paVar = this.f5040a;
        if (paVar.f5214l != null) {
            paVar.f5214l.d().r().b("AppId not known when logging event", "_err");
        }
    }
}
