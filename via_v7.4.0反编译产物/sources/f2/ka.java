package f2;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ka implements va {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pa f5424a;

    public ka(pa paVar) {
        this.f5424a = paVar;
    }

    @Override // f2.va
    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f5424a.f().z(new ja(this, str, "_err", bundle));
            return;
        }
        pa paVar = this.f5424a;
        if (paVar.f5598l != null) {
            paVar.f5598l.d().r().b("AppId not known when logging event", "_err");
        }
    }
}
