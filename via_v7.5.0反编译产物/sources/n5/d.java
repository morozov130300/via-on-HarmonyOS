package n5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.zxing.j f10587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f10588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10589c = 2;

    public d(com.google.zxing.j jVar, w wVar) {
        this.f10587a = jVar;
        this.f10588b = wVar;
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
        return this.f10587a.f();
    }

    public String toString() {
        return this.f10587a.f();
    }
}
