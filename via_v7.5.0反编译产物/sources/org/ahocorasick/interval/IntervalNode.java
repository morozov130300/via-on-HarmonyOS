package org.ahocorasick.interval;

import dc.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class IntervalNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IntervalNode f11486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntervalNode f11487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f11489d = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Direction {
        LEFT,
        RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11491a;

        static {
            int[] iArr = new int[Direction.values().length];
            f11491a = iArr;
            try {
                iArr[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11491a[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IntervalNode(List list) {
        this.f11486a = null;
        this.f11487b = null;
        this.f11488c = e(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.c() < this.f11488c) {
                arrayList.add(cVar);
            } else if (cVar.b() > this.f11488c) {
                arrayList2.add(cVar);
            } else {
                this.f11489d.add(cVar);
            }
        }
        if (arrayList.size() > 0) {
            this.f11486a = new IntervalNode(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.f11487b = new IntervalNode(arrayList2);
        }
    }

    public void a(c cVar, List list, List list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            c cVar2 = (c) it.next();
            if (!cVar2.equals(cVar)) {
                list.add(cVar2);
            }
        }
    }

    public List b(c cVar, Direction direction) {
        ArrayList arrayList = new ArrayList();
        for (c cVar2 : this.f11489d) {
            int i10 = a.f11491a[direction.ordinal()];
            if (i10 != 1) {
                if (i10 == 2 && cVar2.c() >= cVar.b()) {
                    arrayList.add(cVar2);
                }
            } else if (cVar2.b() <= cVar.c()) {
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }

    public List c(c cVar) {
        return b(cVar, Direction.LEFT);
    }

    public List d(c cVar) {
        return b(cVar, Direction.RIGHT);
    }

    public int e(List list) {
        Iterator it = list.iterator();
        int i10 = -1;
        int i11 = -1;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int iB = cVar.b();
            int iC = cVar.c();
            if (i10 == -1 || iB < i10) {
                i10 = iB;
            }
            if (i11 == -1 || iC > i11) {
                i11 = iC;
            }
        }
        return (i10 + i11) / 2;
    }

    public List f(IntervalNode intervalNode, c cVar) {
        return intervalNode != null ? intervalNode.g(cVar) : Collections.EMPTY_LIST;
    }

    public List g(c cVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f11488c < cVar.b()) {
            a(cVar, arrayList, f(this.f11487b, cVar));
            a(cVar, arrayList, d(cVar));
            return arrayList;
        }
        if (this.f11488c > cVar.c()) {
            a(cVar, arrayList, f(this.f11486a, cVar));
            a(cVar, arrayList, c(cVar));
            return arrayList;
        }
        a(cVar, arrayList, this.f11489d);
        a(cVar, arrayList, f(this.f11486a, cVar));
        a(cVar, arrayList, f(this.f11487b, cVar));
        return arrayList;
    }
}
