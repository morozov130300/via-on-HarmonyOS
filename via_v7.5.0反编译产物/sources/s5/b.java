package s5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12211a;

    public b(String str) {
        this.f12211a = str;
    }

    @Override // e.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        return new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f12211a).putExtra("android.intent.extra.TITLE", str);
    }

    @Override // e.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final e.a.C0058a b(Context context, String str) {
        return null;
    }

    @Override // e.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i10, Intent intent) {
        if (intent == null || i10 != -1) {
            return null;
        }
        return intent.getData();
    }
}
