package mark.via.download;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f9951a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f9952b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9953c;

    /* renamed from: d, reason: collision with root package name */
    public final Intent f9954d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9955e;

    public q1(CharSequence charSequence, Drawable drawable, int i10, Intent intent) {
        this.f9951a = charSequence;
        this.f9952b = drawable;
        this.f9953c = i10;
        this.f9954d = intent;
        this.f9955e = a(charSequence, i10, intent);
    }

    public q1(CharSequence charSequence, Drawable drawable, Intent intent) {
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
        return this.f9952b;
    }

    public Intent c() {
        return this.f9954d;
    }

    public long d() {
        return this.f9955e;
    }

    public CharSequence e() {
        return this.f9951a;
    }

    public int f() {
        return this.f9953c;
    }
}
