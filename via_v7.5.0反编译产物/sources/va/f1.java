package va;

import com.tuyafeng.wormhole.AndroidPasswordCsv;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {
    public static List a(BufferedReader bufferedReader) {
        List<c6.w0> listA = AndroidPasswordCsv.f3782a.a(bufferedReader);
        if (listA == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listA.size());
        for (c6.w0 w0Var : listA) {
            t9.f fVar = new t9.f(w0Var.e(), w0Var.c());
            fVar.j(UUID.randomUUID().toString());
            fVar.k(w0Var.a());
            fVar.o(w0Var.d());
            fVar.l(w0Var.b());
            fVar.i(System.currentTimeMillis());
            fVar.n(fVar.a());
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public static void b(BufferedWriter bufferedWriter, List list) throws IOException {
        bufferedWriter.append("name,url,username,password,note").append('\n');
        Iterator it = list.iterator();
        while (it.hasNext()) {
            t9.f fVar = (t9.f) it.next();
            String strB = c6.v0.f2112a.b(fVar.c(), fVar.g(), fVar.h(), fVar.e(), fVar.d());
            if (strB != null) {
                bufferedWriter.append((CharSequence) strB).append('\n');
            }
        }
    }
}
