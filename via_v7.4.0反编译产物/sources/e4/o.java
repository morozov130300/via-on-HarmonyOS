package e4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o implements l {

    /* renamed from: a, reason: collision with root package name */
    public final Logger f4762a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4763b;

    public o(String str) {
        this.f4762a = LoggerFactory.getLogger(str);
        this.f4763b = str;
    }

    @Override // e4.l
    public void a(String str, Object obj, Object obj2) {
        this.f4762a.debug(str, obj, obj2);
    }

    @Override // e4.l
    public void b(String str, Object obj) {
        this.f4762a.debug(str, obj);
    }

    @Override // e4.l
    public void c(String str) {
        this.f4762a.info(str);
    }

    @Override // e4.l
    public void d(String str) {
        this.f4762a.warn(str);
    }
}
