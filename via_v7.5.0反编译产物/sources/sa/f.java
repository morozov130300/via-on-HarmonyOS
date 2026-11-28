package sa;

import android.os.FileObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends FileObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f12240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r6.l f12241b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, int i10, Set set, r6.l lVar) {
            super(str, i10);
            this.f12240a = set;
            this.f12241b = lVar;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if (str == null || !this.f12240a.contains(str)) {
                return;
            }
            this.f12241b.onNext(Boolean.TRUE);
        }
    }

    public static /* synthetic */ void a(List list, r6.l lVar) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        File file = null;
        while (it.hasNext()) {
            String strA = ((sa.a) it.next()).a();
            if (strA != null && !strA.isEmpty()) {
                File file2 = new File(strA);
                File parentFile = file2.getParentFile();
                hashSet.add(file2.getName());
                file = parentFile;
            }
        }
        if (file == null) {
            lVar.onComplete();
            return;
        }
        if (!file.isDirectory() && !file.mkdirs() && !file.isDirectory()) {
            lVar.onError(new IOException("Cannot watch script dependency directory"));
            return;
        }
        r6.l lVarSerialize = lVar.serialize();
        final a aVar = new a(file.getAbsolutePath(), 704, hashSet, lVarSerialize);
        lVar.setCancellable(new u6.e() { // from class: sa.e
            @Override // u6.e
            public final void cancel() {
                aVar.stopWatching();
            }
        });
        aVar.startWatching();
        if (lVar.isDisposed()) {
            aVar.stopWatching();
        } else {
            lVarSerialize.onNext(Boolean.TRUE);
        }
    }

    public static r6.j c(final List list) {
        return r6.j.f(new r6.m() { // from class: sa.c
            @Override // r6.m
            public final void a(r6.l lVar) {
                f.a(list, lVar);
            }
        }).G(a7.a.c()).C(a7.a.c()).A(new u6.g() { // from class: sa.d
            @Override // u6.g
            public final Object apply(Object obj) {
                return f.d(list);
            }
        }).i();
    }

    public static List d(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sa.a aVar = (sa.a) it.next();
            String strA = aVar.a();
            arrayList.add(new sa.a(aVar.b(), strA, strA == null || strA.isEmpty() || new File(strA).isFile()));
        }
        return arrayList;
    }
}
