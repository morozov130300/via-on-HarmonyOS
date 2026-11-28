package s5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.e f12212a;

    public e() {
        this.f12212a = Build.VERSION.SDK_INT >= 36 ? new e.e() : null;
    }

    @Override // e.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Void r10) {
        if (Build.VERSION.SDK_INT < 36 || this.f12212a == null) {
            return new Intent("android.intent.action.PICK").setType("image/*");
        }
        return this.f12212a.a(context, new androidx.activity.result.d.a().b(e.e.c.f4058a).a());
    }

    @Override // e.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Uri c(int i10, Intent intent) {
        e.e eVar;
        if (Build.VERSION.SDK_INT >= 36 && (eVar = this.f12212a) != null) {
            return eVar.c(i10, intent);
        }
        if (intent == null || i10 != -1) {
            return null;
        }
        return intent.getData();
    }
}
