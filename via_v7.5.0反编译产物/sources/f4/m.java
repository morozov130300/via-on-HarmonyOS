package f4;

import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URI f4476c;

    public m(String str, String str2, URI uri) {
        this.f4474a = str;
        this.f4475b = str2;
        this.f4476c = uri;
    }

    public String a() {
        return this.f4474a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            String str = this.f4474a;
            if (str == null ? mVar.f4474a != null : !str.equals(mVar.f4474a)) {
                return false;
            }
            String str2 = this.f4475b;
            if (str2 == null ? mVar.f4475b != null : !str2.equals(mVar.f4475b)) {
                return false;
            }
            URI uri = this.f4476c;
            URI uri2 = mVar.f4476c;
            if (uri == null ? uri2 == null : uri.equals(uri2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f4474a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4475b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        URI uri = this.f4476c;
        return iHashCode2 + (uri != null ? uri.hashCode() : 0);
    }
}
