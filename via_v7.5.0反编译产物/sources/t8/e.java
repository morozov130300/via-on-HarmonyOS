package t8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f12571a;

    public e() {
        this("EEE, MMM dd, yyyy");
    }

    @Override // t8.b.a
    public String a(long j10, int i10, boolean z10) {
        return this.f12571a.format(new Date(j10));
    }

    public e(String str) {
        this.f12571a = new SimpleDateFormat(str, Locale.getDefault());
    }
}
