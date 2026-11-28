package kc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc.c;
import jc.d;
import org.commonmark.ext.gfm.tables.TableCell;
import qc.f;
import qc.g;
import qc.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jc.a f7269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f7272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7273e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends qc.b {
        @Override // qc.e
        public f a(h hVar, g gVar) {
            List listM;
            CharSequence line = hVar.getLine();
            CharSequence charSequenceB = gVar.b();
            if (charSequenceB != null && charSequenceB.toString().contains("|") && !charSequenceB.toString().contains("\n") && (listM = a.m(line.subSequence(hVar.getIndex(), line.length()))) != null && !listM.isEmpty()) {
                List listN = a.n(charSequenceB);
                if (listM.size() >= listN.size()) {
                    return f.d(new a(listM, listN)).b(hVar.getIndex()).e();
                }
            }
            return f.c();
        }
    }

    public static TableCell.Alignment k(boolean z10, boolean z11) {
        if (z10 && z11) {
            return TableCell.Alignment.CENTER;
        }
        if (z10) {
            return TableCell.Alignment.LEFT;
        }
        if (z11) {
            return TableCell.Alignment.RIGHT;
        }
        return null;
    }

    public static List m(CharSequence charSequence) {
        char cCharAt;
        boolean z10;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z12 = false;
        while (true) {
            int i11 = 0;
            while (true) {
                if (i10 >= charSequence.length()) {
                    if (z12) {
                        return arrayList;
                    }
                    return null;
                }
                cCharAt = charSequence.charAt(i10);
                if (cCharAt == '\t' || cCharAt == ' ') {
                    i10++;
                } else {
                    z10 = true;
                    if (cCharAt == '-' || cCharAt == ':') {
                        break;
                    }
                    if (cCharAt != '|') {
                        return null;
                    }
                    i10++;
                    i11++;
                    if (i11 > 1) {
                        return null;
                    }
                    z12 = true;
                }
            }
            if (i11 == 0 && !arrayList.isEmpty()) {
                return null;
            }
            if (cCharAt == ':') {
                i10++;
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z13 = false;
            while (i10 < charSequence.length() && charSequence.charAt(i10) == '-') {
                i10++;
                z13 = true;
            }
            if (!z13) {
                return null;
            }
            if (i10 >= charSequence.length() || charSequence.charAt(i10) != ':') {
                z10 = false;
            } else {
                i10++;
            }
            arrayList.add(k(z11, z10));
        }
    }

    public static List n(CharSequence charSequence) {
        String strTrim = charSequence.toString().trim();
        if (strTrim.startsWith("|")) {
            strTrim = strTrim.substring(1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (i10 < strTrim.length()) {
            char cCharAt = strTrim.charAt(i10);
            if (cCharAt == '\\') {
                int i11 = i10 + 1;
                if (i11 >= strTrim.length() || strTrim.charAt(i11) != '|') {
                    sb2.append('\\');
                } else {
                    sb2.append('|');
                    i10 = i11;
                }
            } else if (cCharAt != '|') {
                sb2.append(cCharAt);
            } else {
                arrayList.add(sb2.toString());
                sb2.setLength(0);
            }
            i10++;
        }
        if (sb2.length() > 0) {
            arrayList.add(sb2.toString());
        }
        return arrayList;
    }

    @Override // qc.a, qc.d
    public void d(pc.a aVar) {
        int size = this.f7272d.size();
        c cVar = new c();
        this.f7269a.b(cVar);
        d dVar = new d();
        cVar.b(dVar);
        for (int i10 = 0; i10 < size; i10++) {
            TableCell tableCellL = l((String) this.f7272d.get(i10), i10, aVar);
            tableCellL.p(true);
            dVar.b(tableCellL);
        }
        Iterator it = this.f7270b.iterator();
        jc.b bVar = null;
        while (it.hasNext()) {
            List listN = n((CharSequence) it.next());
            d dVar2 = new d();
            int i11 = 0;
            while (i11 < size) {
                dVar2.b(l(i11 < listN.size() ? (String) listN.get(i11) : "", i11, aVar));
                i11++;
            }
            if (bVar == null) {
                bVar = new jc.b();
                this.f7269a.b(bVar);
            }
            bVar.b(dVar2);
        }
    }

    @Override // qc.a, qc.d
    public boolean e() {
        return true;
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7269a;
    }

    @Override // qc.d
    public qc.c g(h hVar) {
        return hVar.getLine().toString().contains("|") ? qc.c.b(hVar.getIndex()) : qc.c.d();
    }

    @Override // qc.a, qc.d
    public void h(CharSequence charSequence) {
        if (this.f7273e) {
            this.f7273e = false;
        } else {
            this.f7270b.add(charSequence);
        }
    }

    public final TableCell l(String str, int i10, pc.a aVar) {
        TableCell tableCell = new TableCell();
        if (i10 < this.f7271c.size()) {
            tableCell.o((TableCell.Alignment) this.f7271c.get(i10));
        }
        aVar.a(str.trim(), tableCell);
        return tableCell;
    }

    public a(List list, List list2) {
        this.f7269a = new jc.a();
        this.f7270b = new ArrayList();
        this.f7273e = true;
        this.f7271c = list;
        this.f7272d = list2;
    }
}
