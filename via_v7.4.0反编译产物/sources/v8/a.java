package v8;

import android.content.Context;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import v8.b;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13051a;

    /* renamed from: b, reason: collision with root package name */
    public final DateFormat f13052b;

    /* renamed from: c, reason: collision with root package name */
    public final DateFormat f13053c;

    public a(Context context) {
        this.f13051a = context;
        this.f13052b = new SimpleDateFormat(context.getString(u.f14175tb), Locale.getDefault());
        this.f13053c = new SimpleDateFormat(context.getString(u.W2), Locale.getDefault());
    }

    @Override // v8.b.a
    public String a(long j10, int i10, boolean z10) {
        return i10 == 0 ? this.f13051a.getString(u.Ag) : i10 == -1 ? this.f13051a.getString(u.Xh) : z10 ? this.f13052b.format(new Date(j10)) : this.f13053c.format(new Date(j10));
    }
}
