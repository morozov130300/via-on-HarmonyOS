package t8;

import android.content.Context;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateFormat f12563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DateFormat f12564c;

    public a(Context context) {
        this.f12562a = context;
        this.f12563b = new SimpleDateFormat(context.getString(u.Gb), Locale.getDefault());
        this.f12564c = new SimpleDateFormat(context.getString(u.f14082i3), Locale.getDefault());
    }

    @Override // t8.b.a
    public String a(long j10, int i10, boolean z10) {
        if (i10 == 0) {
            return this.f12562a.getString(u.Qg);
        }
        if (i10 == -1) {
            return this.f12562a.getString(u.Ci);
        }
        return z10 ? this.f12563b.format(new Date(j10)) : this.f12564c.format(new Date(j10));
    }
}
