package ec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f4393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ec.b f4394b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f4395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f4396b;

        public b a(String str) {
            this.f4396b.c(str);
            return this;
        }

        public c b() {
            this.f4396b.e();
            return this.f4396b;
        }

        public b() {
            d dVar = new d();
            this.f4395a = dVar;
            this.f4396b = new c(dVar);
        }
    }

    public static b d() {
        return new b();
    }

    public final void c(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        ec.b bVarC = this.f4394b;
        for (char c10 : str.toCharArray()) {
            Character chValueOf = Character.valueOf(c10);
            if (this.f4393a.b()) {
                chValueOf = Character.valueOf(Character.toLowerCase(c10));
            }
            bVarC = bVarC.c(chValueOf);
        }
        if (this.f4393a.b()) {
            str = str.toLowerCase();
        }
        bVarC.a(str);
    }

    public final void e() {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        for (ec.b bVar : this.f4394b.f()) {
            bVar.k(this.f4394b);
            linkedBlockingDeque.add(bVar);
        }
        while (!linkedBlockingDeque.isEmpty()) {
            ec.b bVar2 = (ec.b) linkedBlockingDeque.remove();
            for (Character ch : bVar2.g()) {
                ec.b bVarH = bVar2.h(ch);
                linkedBlockingDeque.add(bVarH);
                ec.b bVarE = bVar2.e();
                while (bVarE.h(ch) == null) {
                    bVarE = bVarE.e();
                }
                ec.b bVarH2 = bVarE.h(ch);
                bVarH.k(bVarH2);
                bVarH.b(bVarH2.d());
            }
        }
    }

    public final ec.b f(ec.b bVar, Character ch) {
        ec.b bVarH = bVar.h(ch);
        while (bVarH == null) {
            bVar = bVar.e();
            bVarH = bVar.h(ch);
        }
        return bVarH;
    }

    public final boolean g(CharSequence charSequence, ec.a aVar) {
        return (aVar.b() != 0 && Character.isAlphabetic(charSequence.charAt(aVar.b() - 1))) || (aVar.c() + 1 != charSequence.length() && Character.isAlphabetic(charSequence.charAt(aVar.c() + 1)));
    }

    public Collection h(CharSequence charSequence) {
        fc.a aVar = new fc.a();
        i(charSequence, aVar);
        List listB = aVar.b();
        if (this.f4393a.c()) {
            j(charSequence, listB);
        }
        if (this.f4393a.d()) {
            k(charSequence, listB);
        }
        if (!this.f4393a.a()) {
            new dc.b(listB).b(listB);
        }
        return listB;
    }

    public void i(CharSequence charSequence, fc.b bVar) {
        ec.b bVarF = this.f4394b;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            Character chValueOf = Character.valueOf(cCharAt);
            if (this.f4393a.b()) {
                chValueOf = Character.valueOf(Character.toLowerCase(cCharAt));
            }
            bVarF = f(bVarF, chValueOf);
            if (l(i10, bVarF, bVar) && this.f4393a.e()) {
                return;
            }
        }
    }

    public final void j(CharSequence charSequence, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ec.a aVar = (ec.a) it.next();
            if (g(charSequence, aVar)) {
                arrayList.add(aVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            list.remove((ec.a) it2.next());
        }
    }

    public final void k(CharSequence charSequence, List list) {
        long length = charSequence.length();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ec.a aVar = (ec.a) it.next();
            if ((aVar.b() != 0 && !Character.isWhitespace(charSequence.charAt(aVar.b() - 1))) || (aVar.c() + 1 != length && !Character.isWhitespace(charSequence.charAt(aVar.c() + 1)))) {
                arrayList.add(aVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            list.remove((ec.a) it2.next());
        }
    }

    public final boolean l(int i10, ec.b bVar, fc.b bVar2) {
        Collection<String> collectionD = bVar.d();
        boolean z10 = false;
        if (collectionD != null && !collectionD.isEmpty()) {
            for (String str : collectionD) {
                bVar2.a(new ec.a((i10 - str.length()) + 1, i10, str));
                z10 = true;
            }
        }
        return z10;
    }

    public c(d dVar) {
        this.f4393a = dVar;
        this.f4394b = new ec.b();
    }
}
