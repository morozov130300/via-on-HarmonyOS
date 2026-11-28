package v;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f12978a;

    public s(Object obj) {
        this.f12978a = r.a(obj);
    }

    @Override // v.m
    public Object a() {
        return this.f12978a;
    }

    public boolean equals(Object obj) {
        return this.f12978a.equals(((m) obj).a());
    }

    @Override // v.m
    public Locale get(int i10) {
        return this.f12978a.get(i10);
    }

    public int hashCode() {
        return this.f12978a.hashCode();
    }

    public String toString() {
        return this.f12978a.toString();
    }
}
