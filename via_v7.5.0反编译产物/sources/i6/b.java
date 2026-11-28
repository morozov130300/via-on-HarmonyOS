package i6;

import e6.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oc.t;
import org.commonmark.ext.gfm.tables.TableCell;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0076b f6255b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6256a;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            f6256a = iArr;
            try {
                iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6256a[TableCell.Alignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: i6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0076b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i6.e f6257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f6258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6260d;

        /* JADX INFO: renamed from: i6.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements l.c {
            public a() {
            }

            @Override // e6.l.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, TableCell tableCell) {
                int length = lVar.length();
                lVar.B(tableCell);
                if (C0076b.this.f6258b == null) {
                    C0076b.this.f6258b = new ArrayList(2);
                }
                C0076b.this.f6258b.add(new i6.c.b(C0076b.i(tableCell.m()), lVar.builder().i(length)));
                C0076b.this.f6259c = tableCell.n();
            }
        }

        /* JADX INFO: renamed from: i6.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0077b implements l.c {
            public C0077b() {
            }

            @Override // e6.l.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, jc.c cVar) {
                C0076b.this.j(lVar, cVar);
            }
        }

        /* JADX INFO: renamed from: i6.b$b$c */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class c implements l.c {
            public c() {
            }

            @Override // e6.l.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, jc.d dVar) {
                C0076b.this.j(lVar, dVar);
            }
        }

        /* JADX INFO: renamed from: i6.b$b$d */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class d implements l.c {
            public d() {
            }

            @Override // e6.l.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, jc.b bVar) {
                lVar.B(bVar);
                C0076b.this.f6260d = 0;
            }
        }

        /* JADX INFO: renamed from: i6.b$b$e */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class e implements l.c {
            public e() {
            }

            @Override // e6.l.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, jc.a aVar) {
                lVar.C(aVar);
                int length = lVar.length();
                lVar.B(aVar);
                lVar.c(length, new i6.d());
                lVar.u(aVar);
            }
        }

        public C0076b(i6.e eVar) {
            this.f6257a = eVar;
        }

        public static int i(TableCell.Alignment alignment) {
            if (alignment == null) {
                return 0;
            }
            int i10 = a.f6256a[alignment.ordinal()];
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    return 0;
                }
            }
            return i11;
        }

        public void g() {
            this.f6258b = null;
            this.f6259c = false;
            this.f6260d = 0;
        }

        public void h(l.b bVar) {
            bVar.a(jc.a.class, new e()).a(jc.b.class, new d()).a(jc.d.class, new c()).a(jc.c.class, new C0077b()).a(TableCell.class, new a());
        }

        public final void j(l lVar, t tVar) {
            int length = lVar.length();
            lVar.B(tVar);
            if (this.f6258b != null) {
                e6.t tVarBuilder = lVar.builder();
                int length2 = tVarBuilder.length();
                boolean z10 = length2 > 0 && '\n' != tVarBuilder.charAt(length2 - 1);
                if (z10) {
                    lVar.n();
                }
                tVarBuilder.append((char) 160);
                i6.c cVar = new i6.c(this.f6257a, this.f6258b, this.f6259c, this.f6260d % 2 == 1);
                this.f6260d = this.f6259c ? 0 : this.f6260d + 1;
                if (z10) {
                    length++;
                }
                lVar.c(length, cVar);
                this.f6258b = null;
            }
        }
    }

    public b(e eVar) {
        this.f6254a = eVar;
        this.f6255b = new C0076b(eVar);
    }

    public static b j(e eVar) {
        return new b(eVar);
    }

    @Override // e6.a, e6.i
    public void a(t tVar) {
        this.f6255b.g();
    }

    @Override // e6.a, e6.i
    public void g(l.b bVar) {
        this.f6255b.h(bVar);
    }

    @Override // e6.a, e6.i
    public void i(pc.d.b bVar) {
        bVar.h(Collections.singleton(jc.e.b()));
    }
}
