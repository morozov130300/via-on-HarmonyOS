package y5;

import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public g f14455a;

    /* renamed from: b, reason: collision with root package name */
    public h f14456b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: y5.a$a, reason: collision with other inner class name */
    public class C0156a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b6.g f14457c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f14458d;

        public C0156a(b6.g gVar, Object obj) {
            this.f14457c = gVar;
            this.f14458d = obj;
        }

        @Override // v5.c
        public void a(View view) {
            g gVar;
            int iL = this.f14457c.l();
            if (iL == -1 || (gVar = a.this.f14455a) == null) {
                return;
            }
            gVar.a(view, iL, this.f14458d);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b6.g f14460a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f14461b;

        public b(b6.g gVar, Object obj) {
            this.f14460a = gVar;
            this.f14461b = obj;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            h hVar;
            int iL = this.f14460a.l();
            return (iL == -1 || (hVar = a.this.f14456b) == null || !hVar.a(view, iL, this.f14461b)) ? false : true;
        }
    }

    public a() {
        this(null);
    }

    public a(g gVar) {
        this.f14455a = gVar;
    }

    public void i(b6.g gVar, Object obj) {
        gVar.f1219a.setOnClickListener(new C0156a(gVar, obj));
        gVar.f1219a.setOnLongClickListener(new b(gVar, obj));
    }

    public void j(g gVar) {
        this.f14455a = gVar;
    }

    public void k(h hVar) {
        this.f14456b = hVar;
    }
}
