package v5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0150c f13378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f13379d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w5.g f13380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v5.a f13381d;

        public a(w5.g gVar, v5.a aVar) {
            this.f13380c = gVar;
            this.f13381d = aVar;
        }

        @Override // p5.c
        public void a(View view) {
            if (c.this.f13378c != null) {
                c.this.f13378c.a(view, this.f13380c.l(), this.f13381d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w5.g f13383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v5.a f13384b;

        public b(w5.g gVar, v5.a aVar) {
            this.f13383a = gVar;
            this.f13384b = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return c.this.f13379d != null && c.this.f13379d.a(view, this.f13383a.l(), this.f13384b);
        }
    }

    /* JADX INFO: renamed from: v5.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0150c {
        void a(View view, int i10, v5.a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        boolean a(View view, int i10, v5.a aVar);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public long a(v5.a aVar) {
        return aVar.c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, v5.a aVar) {
        super.b(gVar, aVar);
        gVar.X(v5.b.f13369c, aVar.a());
        int i10 = v5.b.f13370e;
        gVar.X(i10, aVar.d());
        gVar.Y(i10, !TextUtils.isEmpty(aVar.d()));
        ImageView imageView = (ImageView) gVar.P(v5.b.f13371m);
        imageView.setImageDrawable(aVar.j());
        imageView.setContentDescription(aVar.i());
        imageView.setEnabled(aVar.k());
        imageView.setAlpha((aVar.e() || aVar.k()) ? 1.0f : 0.5f);
        imageView.setOnClickListener(new a(gVar, aVar));
        imageView.setOnLongClickListener(new b(gVar, aVar));
        gVar.f1138a.setAlpha(aVar.e() ? 0.5f : 1.0f);
        gVar.f1138a.setEnabled(!aVar.e());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        v5.b bVar = new v5.b(context);
        bVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(bVar);
    }

    public void q(InterfaceC0150c interfaceC0150c) {
        this.f13378c = interfaceC0150c;
    }

    public void r(d dVar) {
        this.f13379d = dVar;
    }
}
