package g2;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c7 implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o7 f4687a;

    public c7(o7 o7Var) {
        this.f4687a = o7Var;
    }

    @Override // g2.va
    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f4687a.r("auto", "_err", bundle);
        } else {
            this.f4687a.t("auto", "_err", bundle, str);
        }
    }
}
