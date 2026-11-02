package f2;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c7 implements va {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o7 f5071a;

    public c7(o7 o7Var) {
        this.f5071a = o7Var;
    }

    @Override // f2.va
    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f5071a.r("auto", "_err", bundle);
        } else {
            this.f5071a.t("auto", "_err", bundle, str);
        }
    }
}
