package xb;

import java.net.Proxy;
import okhttp3.r;
import okhttp3.w;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {
    public static String a(w wVar, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(wVar.f());
        sb2.append(' ');
        if (b(wVar, type)) {
            sb2.append(wVar.h());
        } else {
            sb2.append(c(wVar.h()));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    public static boolean b(w wVar, Proxy.Type type) {
        return !wVar.e() && type == Proxy.Type.HTTP;
    }

    public static String c(r rVar) {
        String strG = rVar.g();
        String strI = rVar.i();
        if (strI == null) {
            return strG;
        }
        return strG + '?' + strI;
    }
}
