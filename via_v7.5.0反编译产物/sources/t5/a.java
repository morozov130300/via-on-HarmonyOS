package t5;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f12547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f12548b;

    /* JADX INFO: renamed from: t5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0126a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w5.g f12549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f12550d;

        public C0126a(w5.g gVar, Object obj) {
            this.f12549c = gVar;
            this.f12550d = obj;
        }

        @Override // p5.c
        public void a(View view) {
            g gVar;
            int iL = this.f12549c.l();
            if (iL == -1 || (gVar = a.this.f12547a) == null) {
                return;
            }
            gVar.a(view, iL, this.f12550d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w5.g f12552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f12553b;

        public b(w5.g gVar, Object obj) {
            this.f12552a = gVar;
            this.f12553b = obj;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            h hVar;
            int iL = this.f12552a.l();
            return (iL == -1 || (hVar = a.this.f12548b) == null || !hVar.a(view, iL, this.f12553b)) ? false : true;
        }
    }

    public a() {
        this(null);
    }

    public void i(w5.g gVar, Object obj) {
        gVar.f1138a.setOnClickListener(new C0126a(gVar, obj));
        gVar.f1138a.setOnLongClickListener(new b(gVar, obj));
    }

    public void j(g gVar) {
        this.f12547a = gVar;
    }

    public void k(h hVar) {
        this.f12548b = hVar;
    }

    public a(g gVar) {
        this.f12547a = gVar;
    }
}
