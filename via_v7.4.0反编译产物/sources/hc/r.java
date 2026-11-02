package hc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import kc.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r implements nc.a {

    /* renamed from: a, reason: collision with root package name */
    public final char f6961a;

    /* renamed from: b, reason: collision with root package name */
    public int f6962b = 0;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList f6963c = new LinkedList();

    public r(char c10) {
        this.f6961a = c10;
    }

    @Override // nc.a
    public void a(y yVar, y yVar2, int i10) {
        g(i10).a(yVar, yVar2, i10);
    }

    @Override // nc.a
    public int b(nc.b bVar, nc.b bVar2) {
        return g(bVar.length()).b(bVar, bVar2);
    }

    @Override // nc.a
    public char c() {
        return this.f6961a;
    }

    @Override // nc.a
    public int d() {
        return this.f6962b;
    }

    @Override // nc.a
    public char e() {
        return this.f6961a;
    }

    public void f(nc.a aVar) {
        int iD = aVar.d();
        ListIterator listIterator = this.f6963c.listIterator();
        while (listIterator.hasNext()) {
            int iD2 = ((nc.a) listIterator.next()).d();
            if (iD > iD2) {
                listIterator.previous();
                listIterator.add(aVar);
                return;
            } else if (iD == iD2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f6961a + "' and minimum length " + iD);
            }
        }
        this.f6963c.add(aVar);
        this.f6962b = iD;
    }

    public final nc.a g(int i10) {
        Iterator it = this.f6963c.iterator();
        while (it.hasNext()) {
            nc.a aVar = (nc.a) it.next();
            if (aVar.d() <= i10) {
                return aVar;
            }
        }
        return (nc.a) this.f6963c.getFirst();
    }
}
