package t5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public com.google.zxing.j f12156a;

    /* renamed from: b, reason: collision with root package name */
    public w f12157b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12158c = 2;

    public d(com.google.zxing.j jVar, w wVar) {
        this.f12156a = jVar;
        this.f12157b = wVar;
    }

    public static List b(List list, w wVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(wVar.d((com.google.zxing.k) it.next()));
        }
        return arrayList;
    }

    public String a() {
        return this.f12156a.f();
    }

    public String toString() {
        return this.f12156a.f();
    }
}
