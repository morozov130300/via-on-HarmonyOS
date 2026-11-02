package v8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import v8.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final DateFormat f13060a;

    public e() {
        this("EEE, MMM dd, yyyy");
    }

    public e(String str) {
        this.f13060a = new SimpleDateFormat(str, Locale.getDefault());
    }

    @Override // v8.b.a
    public String a(long j10, int i10, boolean z10) {
        return this.f13060a.format(new Date(j10));
    }
}
