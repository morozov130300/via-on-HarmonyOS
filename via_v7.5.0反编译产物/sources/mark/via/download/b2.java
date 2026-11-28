package mark.via.download;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f10160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f10161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Intent f10163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10164e;

    public b2(CharSequence charSequence, Drawable drawable, Intent intent) {
        this(charSequence, drawable, 1, intent);
    }

    public static long a(CharSequence charSequence, int i10, Intent intent) {
        int iHashCode = 0;
        int iHashCode2 = (((charSequence == null ? 0 : charSequence.hashCode()) * 31) + i10) * 31;
        if (intent != null && intent.getComponent() != null) {
            iHashCode = intent.getComponent().flattenToShortString().hashCode();
        }
        return iHashCode2 + iHashCode;
    }

    public Drawable b() {
        return this.f10161b;
    }

    public Intent c() {
        return this.f10163d;
    }

    public long d() {
        return this.f10164e;
    }

    public CharSequence e() {
        return this.f10160a;
    }

    public int f() {
        return this.f10162c;
    }

    public b2(CharSequence charSequence, Drawable drawable, int i10, Intent intent) {
        this.f10160a = charSequence;
        this.f10161b = drawable;
        this.f10162c = i10;
        this.f10163d = intent;
        this.f10164e = a(charSequence, i10, intent);
    }
}
