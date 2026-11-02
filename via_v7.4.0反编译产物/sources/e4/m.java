package e4;

import java.net.URI;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f4758a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4759b;

    /* renamed from: c, reason: collision with root package name */
    public final URI f4760c;

    public m(String str, String str2, URI uri) {
        this.f4758a = str;
        this.f4759b = str2;
        this.f4760c = uri;
    }

    public String a() {
        return this.f4758a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            String str = this.f4758a;
            if (str == null ? mVar.f4758a != null : !str.equals(mVar.f4758a)) {
                return false;
            }
            String str2 = this.f4759b;
            if (str2 == null ? mVar.f4759b != null : !str2.equals(mVar.f4759b)) {
                return false;
            }
            URI uri = this.f4760c;
            URI uri2 = mVar.f4760c;
            if (uri == null ? uri2 == null : uri.equals(uri2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f4758a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4759b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        URI uri = this.f4760c;
        return iHashCode2 + (uri != null ? uri.hashCode() : 0);
    }
}
