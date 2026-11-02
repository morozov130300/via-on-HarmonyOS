package x5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.d;
import e.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends e.a {

    /* renamed from: a, reason: collision with root package name */
    public final e.e f13613a;

    public e() {
        this.f13613a = Build.VERSION.SDK_INT >= 36 ? new e.e() : null;
    }

    @Override // e.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Void r32) {
        if (Build.VERSION.SDK_INT < 36 || this.f13613a == null) {
            return new Intent("android.intent.action.PICK").setType("image/*");
        }
        return this.f13613a.a(context, new d.a().b(e.c.f4693a).a());
    }

    @Override // e.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Uri c(int i10, Intent intent) {
        e.e eVar;
        if (Build.VERSION.SDK_INT >= 36 && (eVar = this.f13613a) != null) {
            return eVar.c(i10, intent);
        }
        if (intent == null || i10 != -1) {
            return null;
        }
        return intent.getData();
    }
}
