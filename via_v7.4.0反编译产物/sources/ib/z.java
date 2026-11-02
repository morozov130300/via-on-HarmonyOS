package ib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public b f7184c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f7185a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f7186b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f7187c;

        public a(x xVar, TextView textView, TextView textView2) {
            this.f7185a = xVar;
            this.f7186b = textView;
            this.f7187c = textView2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            int i11;
            int iK = this.f7185a.k() + (i10 * this.f7185a.o());
            if (this.f7185a.i() > 0) {
                double dZ = g6.y.Z(seekBar.getContext(), 14.0f);
                double d10 = iK;
                Double.isNaN(dZ);
                Double.isNaN(d10);
                double d11 = dZ * d10;
                double dI = this.f7185a.i();
                Double.isNaN(dI);
                i11 = (int) (d11 / dI);
            } else {
                i11 = iK;
            }
            this.f7186b.setTextSize(0, i11);
            this.f7187c.setText(String.format(Locale.ROOT, this.f7185a.j(), Integer.valueOf(iK)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (z.this.f7184c != null) {
                z.this.f7184c.a((seekBar.getProgress() * this.f7185a.o()) + this.f7185a.k());
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(int i10);
    }

    public static /* synthetic */ void l(z zVar, x xVar, View view, boolean z10) {
        if (z10) {
            zVar.getClass();
        } else if (zVar.f7184c != null) {
            zVar.f7184c.a((((SeekBar) view).getProgress() * xVar.o()) + xVar.k());
        }
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public long a(x xVar) {
        return xVar.c();
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, final x xVar) {
        super.b(gVar, xVar);
        int i10 = a0.f7113e;
        gVar.X(i10, xVar.a());
        int i11 = a0.f7115k;
        TextView textView = (TextView) gVar.P(i11);
        int i12 = a0.f7116l;
        TextView textView2 = (TextView) gVar.P(i12);
        textView2.setText(xVar.l());
        int i13 = a0.f7114j;
        SeekBar seekBar = (SeekBar) gVar.P(i13);
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(xVar.m());
        if (xVar.n() == 0) {
            seekBar.setProgress(1);
        }
        seekBar.setOnSeekBarChangeListener(new a(xVar, textView2, textView));
        seekBar.setOnFocusChangeListener(null);
        seekBar.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ib.y
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                z.l(this.f7182a, xVar, view, z10);
            }
        });
        seekBar.setProgress(xVar.n());
        gVar.P(i10).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.P(i13).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.P(i12).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.f1219a.setEnabled(!xVar.e());
    }

    @Override // y5.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        a0 a0Var = new a0(context);
        a0Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(a0Var);
    }

    public void q(b bVar) {
        this.f7184c = bVar;
    }
}
