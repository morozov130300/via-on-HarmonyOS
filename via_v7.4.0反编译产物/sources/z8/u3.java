package z8;

import android.content.Context;
import android.text.format.DateUtils;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u3 {
    public static String a(Context context, long j10) {
        return ((int) (((System.currentTimeMillis() - j10) / 1000) / 60)) < 1 ? context.getString(x7.u.f14158s7) : DateUtils.getRelativeTimeSpanString(j10, System.currentTimeMillis(), 60000L, 65552).toString();
    }
}
