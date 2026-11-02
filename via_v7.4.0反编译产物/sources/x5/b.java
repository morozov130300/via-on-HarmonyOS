package x5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import e.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends e.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13612a;

    public b(String str) {
        this.f13612a = str;
    }

    @Override // e.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        return new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f13612a).putExtra("android.intent.extra.TITLE", str);
    }

    @Override // e.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a.C0063a b(Context context, String str) {
        return null;
    }

    @Override // e.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i10, Intent intent) {
        if (intent == null || i10 != -1) {
            return null;
        }
        return intent.getData();
    }
}
