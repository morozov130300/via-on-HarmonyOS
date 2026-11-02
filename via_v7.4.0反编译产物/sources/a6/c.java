package a6;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0004c f94c;

    /* renamed from: d, reason: collision with root package name */
    public d f95d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b6.g f96c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a6.a f97d;

        public a(b6.g gVar, a6.a aVar) {
            this.f96c = gVar;
            this.f97d = aVar;
        }

        @Override // v5.c
        public void a(View view) {
            if (c.this.f94c != null) {
                c.this.f94c.a(view, this.f96c.l(), this.f97d);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b6.g f99a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a6.a f100b;

        public b(b6.g gVar, a6.a aVar) {
            this.f99a = gVar;
            this.f100b = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return c.this.f95d != null && c.this.f95d.a(view, this.f99a.l(), this.f100b);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: a6.c$c, reason: collision with other inner class name */
    public interface InterfaceC0004c {
        void a(View view, int i10, a6.a aVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        boolean a(View view, int i10, a6.a aVar);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public long a(a6.a aVar) {
        return aVar.c();
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, a6.a aVar) {
        super.b(gVar, aVar);
        gVar.X(a6.b.f85e, aVar.a());
        int i10 = a6.b.f86j;
        gVar.X(i10, aVar.d());
        gVar.Y(i10, !TextUtils.isEmpty(aVar.d()));
        ImageView imageView = (ImageView) gVar.P(a6.b.f87k);
        imageView.setImageDrawable(aVar.j());
        imageView.setContentDescription(aVar.i());
        imageView.setEnabled(aVar.k());
        imageView.setAlpha((aVar.e() || aVar.k()) ? 1.0f : 0.5f);
        imageView.setOnClickListener(new a(gVar, aVar));
        imageView.setOnLongClickListener(new b(gVar, aVar));
        gVar.f1219a.setAlpha(aVar.e() ? 0.5f : 1.0f);
        gVar.f1219a.setEnabled(!aVar.e());
    }

    @Override // y5.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        a6.b bVar = new a6.b(context);
        bVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(bVar);
    }

    public void q(InterfaceC0004c interfaceC0004c) {
        this.f94c = interfaceC0004c;
    }

    public void r(d dVar) {
        this.f95d = dVar;
    }
}
