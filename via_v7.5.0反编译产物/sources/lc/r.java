package lc;

import java.util.LinkedList;
import java.util.ListIterator;
import oc.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r implements rc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f7739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7740b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList f7741c = new LinkedList();

    public r(char c10) {
        this.f7739a = c10;
    }

    @Override // rc.a
    public void a(y yVar, y yVar2, int i10) {
        g(i10).a(yVar, yVar2, i10);
    }

    @Override // rc.a
    public char b() {
        return this.f7739a;
    }

    @Override // rc.a
    public int c(rc.b bVar, rc.b bVar2) {
        return g(bVar.length()).c(bVar, bVar2);
    }

    @Override // rc.a
    public int d() {
        return this.f7740b;
    }

    @Override // rc.a
    public char e() {
        return this.f7739a;
    }

    public void f(rc.a aVar) {
        int iD = aVar.d();
        ListIterator listIterator = this.f7741c.listIterator();
        while (listIterator.hasNext()) {
            int iD2 = ((rc.a) listIterator.next()).d();
            if (iD > iD2) {
                listIterator.previous();
                listIterator.add(aVar);
                return;
            } else if (iD == iD2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f7739a + "' and minimum length " + iD);
            }
        }
        this.f7741c.add(aVar);
        this.f7740b = iD;
    }

    public final rc.a g(int i10) {
        for (rc.a aVar : this.f7741c) {
            if (aVar.d() <= i10) {
                return aVar;
            }
        }
        return (rc.a) this.f7741c.getFirst();
    }
}
