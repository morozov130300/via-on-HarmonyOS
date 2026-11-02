package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l9 extends p9 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f3610c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public /* synthetic */ l9(k9 k9Var) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void a(Object obj, long j10) {
        Object objUnmodifiableList;
        List list = (List) ab.k(obj, j10);
        if (list instanceof j9) {
            objUnmodifiableList = ((j9) list).d();
        } else {
            if (f3610c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof ha) && (list instanceof g9)) {
                g9 g9Var = (g9) list;
                if (g9Var.b()) {
                    g9Var.a();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        ab.x(obj, j10, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.p9
    public final void b(Object obj, Object obj2, long j10) {
        i9 i9Var;
        List list = (List) ab.k(obj2, j10);
        int size = list.size();
        List listJ = (List) ab.k(obj, j10);
        if (listJ.isEmpty()) {
            listJ = listJ instanceof j9 ? new i9(size) : ((listJ instanceof ha) && (listJ instanceof g9)) ? ((g9) listJ).j(size) : new ArrayList(size);
            ab.x(obj, j10, listJ);
        } else {
            if (f3610c.isAssignableFrom(listJ.getClass())) {
                ArrayList arrayList = new ArrayList(listJ.size() + size);
                arrayList.addAll(listJ);
                ab.x(obj, j10, arrayList);
                i9Var = arrayList;
            } else if (listJ instanceof va) {
                i9 i9Var2 = new i9(listJ.size() + size);
                i9Var2.addAll(i9Var2.size(), (va) listJ);
                ab.x(obj, j10, i9Var2);
                i9Var = i9Var2;
            } else if ((listJ instanceof ha) && (listJ instanceof g9)) {
                g9 g9Var = (g9) listJ;
                if (!g9Var.b()) {
                    listJ = g9Var.j(listJ.size() + size);
                    ab.x(obj, j10, listJ);
                }
            }
            listJ = i9Var;
        }
        int size2 = listJ.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listJ.addAll(list);
        }
        if (size2 > 0) {
            list = listJ;
        }
        ab.x(obj, j10, list);
    }
}
