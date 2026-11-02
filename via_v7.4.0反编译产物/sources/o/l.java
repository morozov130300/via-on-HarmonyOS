package o;

import android.content.LocusId;
import android.os.Build;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f10318a;

    /* renamed from: b, reason: collision with root package name */
    public final LocusId f10319b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static LocusId a(String str) {
            return new LocusId(str);
        }
    }

    public l(String str) {
        this.f10318a = (String) w.g.d(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f10319b = a.a(str);
        } else {
            this.f10319b = null;
        }
    }

    public String a() {
        return this.f10318a;
    }

    public final String b() {
        return this.f10318a.length() + "_chars";
    }

    public LocusId c() {
        return this.f10319b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        String str = this.f10318a;
        return str == null ? lVar.f10318a == null : str.equals(lVar.f10318a);
    }

    public int hashCode() {
        String str = this.f10318a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
