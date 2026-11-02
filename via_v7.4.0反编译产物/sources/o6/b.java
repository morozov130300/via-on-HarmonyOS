package o6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k6.l;
import kc.t;
import lc.d;
import o6.c;
import org.commonmark.ext.gfm.tables.TableCell;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends k6.a {

    /* renamed from: a, reason: collision with root package name */
    public final e f10413a;

    /* renamed from: b, reason: collision with root package name */
    public final C0104b f10414b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10415a;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            f10415a = iArr;
            try {
                iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10415a[TableCell.Alignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: o6.b$b, reason: collision with other inner class name */
    public static class C0104b {

        /* renamed from: a, reason: collision with root package name */
        public final o6.e f10416a;

        /* renamed from: b, reason: collision with root package name */
        public List f10417b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10418c;

        /* renamed from: d, reason: collision with root package name */
        public int f10419d;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: o6.b$b$a */
        public class a implements l.c {
            public a() {
            }

            @Override // k6.l.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, TableCell tableCell) {
                int length = lVar.length();
                lVar.e(tableCell);
                if (C0104b.this.f10417b == null) {
                    C0104b.this.f10417b = new ArrayList(2);
                }
                C0104b.this.f10417b.add(new c.b(C0104b.i(tableCell.m()), lVar.builder().i(length)));
                C0104b.this.f10418c = tableCell.n();
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: o6.b$b$b, reason: collision with other inner class name */
        public class C0105b implements l.c {
            public C0105b() {
            }

            @Override // k6.l.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, fc.c cVar) {
                C0104b.this.j(lVar, cVar);
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: o6.b$b$c */
        public class c implements l.c {
            public c() {
            }

            @Override // k6.l.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, fc.d dVar) {
                C0104b.this.j(lVar, dVar);
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: o6.b$b$d */
        public class d implements l.c {
            public d() {
            }

            @Override // k6.l.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, fc.b bVar) {
                lVar.e(bVar);
                C0104b.this.f10419d = 0;
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: o6.b$b$e */
        public class e implements l.c {
            public e() {
            }

            @Override // k6.l.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(l lVar, fc.a aVar) {
                lVar.r(aVar);
                int length = lVar.length();
                lVar.e(aVar);
                lVar.f(length, new o6.d());
                lVar.j(aVar);
            }
        }

        public C0104b(o6.e eVar) {
            this.f10416a = eVar;
        }

        public static int i(TableCell.Alignment alignment) {
            if (alignment == null) {
                return 0;
            }
            int i10 = a.f10415a[alignment.ordinal()];
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
            this.f10417b = null;
            this.f10418c = false;
            this.f10419d = 0;
        }

        public void h(l.b bVar) {
            bVar.b(fc.a.class, new e()).b(fc.b.class, new d()).b(fc.d.class, new c()).b(fc.c.class, new C0105b()).b(TableCell.class, new a());
        }

        public final void j(l lVar, t tVar) {
            int length = lVar.length();
            lVar.e(tVar);
            if (this.f10417b != null) {
                k6.t tVarBuilder = lVar.builder();
                int length2 = tVarBuilder.length();
                boolean z10 = length2 > 0 && '\n' != tVarBuilder.charAt(length2 - 1);
                if (z10) {
                    lVar.q();
                }
                tVarBuilder.append('\u00a0');
                o6.c cVar = new o6.c(this.f10416a, this.f10417b, this.f10418c, this.f10419d % 2 == 1);
                this.f10419d = this.f10418c ? 0 : this.f10419d + 1;
                if (z10) {
                    length++;
                }
                lVar.f(length, cVar);
                this.f10417b = null;
            }
        }
    }

    public b(e eVar) {
        this.f10413a = eVar;
        this.f10414b = new C0104b(eVar);
    }

    public static b j(e eVar) {
        return new b(eVar);
    }

    @Override // k6.a, k6.i
    public void b(l.b bVar) {
        this.f10414b.h(bVar);
    }

    @Override // k6.a, k6.i
    public void e(t tVar) {
        this.f10414b.g();
    }

    @Override // k6.a, k6.i
    public void i(d.b bVar) {
        bVar.h(Collections.singleton(fc.e.b()));
    }
}
