package k6;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements c {
    public static Uri b(String str) {
        Uri uri = Uri.parse(str);
        return TextUtils.isEmpty(uri.getScheme()) ? uri.buildUpon().scheme("https").build() : uri;
    }

    @Override // k6.c
    public void a(View view, String str) {
        Uri uriB = b(str);
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", uriB);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w("LinkResolverDef", "Actvity was not found for the link: '" + str + "'");
        }
    }
}
