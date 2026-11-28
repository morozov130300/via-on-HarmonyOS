package x8;

import android.content.Context;
import android.text.format.DateUtils;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class u3 {
    public static String a(Context context, long j10) {
        return ((int) (((System.currentTimeMillis() - j10) / 1000) / 60)) < 1 ? context.getString(w7.u.E7) : DateUtils.getRelativeTimeSpanString(j10, System.currentTimeMillis(), 60000L, 65552).toString();
    }
}
