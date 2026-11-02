package k6;

import k6.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class m {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l.b f8163a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f8164b;

        public a(l.b bVar, g gVar) {
            this.f8163a = bVar;
            this.f8164b = gVar;
        }

        @Override // k6.m
        public l a() {
            return this.f8163a.a(this.f8164b, new r());
        }
    }

    public static m b(l.b bVar, g gVar) {
        return new a(bVar, gVar);
    }

    public abstract l a();
}
