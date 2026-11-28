package ib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f6416c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(int i10);
    }

    public static /* synthetic */ void l(z zVar, x xVar, View view, boolean z10) {
        if (z10) {
            zVar.getClass();
        } else if (zVar.f6416c != null) {
            zVar.f6416c.a((((SeekBar) view).getProgress() * xVar.o()) + xVar.k());
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public long a(x xVar) {
        return xVar.c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, final x xVar) {
        super.b(gVar, xVar);
        int i10 = a0.f6340c;
        gVar.X(i10, xVar.a());
        int i11 = a0.f6342m;
        TextView textView = (TextView) gVar.P(i11);
        int i12 = a0.f6343n;
        TextView textView2 = (TextView) gVar.P(i12);
        textView2.setText(xVar.l());
        int i13 = a0.f6341e;
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
                z.l(this.f6414a, xVar, view, z10);
            }
        });
        seekBar.setProgress(xVar.n());
        gVar.P(i10).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.P(i13).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.P(i12).setAlpha(xVar.e() ? 0.5f : 1.0f);
        gVar.f1138a.setEnabled(!xVar.e());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        a0 a0Var = new a0(context);
        a0Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(a0Var);
    }

    public void q(b bVar) {
        this.f6416c = bVar;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f6417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f6418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f6419c;

        public a(x xVar, TextView textView, TextView textView2) {
            this.f6417a = xVar;
            this.f6418b = textView;
            this.f6419c = textView2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            int i11;
            int iK = this.f6417a.k() + (i10 * this.f6417a.o());
            if (this.f6417a.i() > 0) {
                double dZ = com.tuyafeng.support.utils.x.Z(seekBar.getContext(), 14.0f);
                double d10 = iK;
                Double.isNaN(dZ);
                Double.isNaN(d10);
                double d11 = dZ * d10;
                double dI = this.f6417a.i();
                Double.isNaN(dI);
                i11 = (int) (d11 / dI);
            } else {
                i11 = iK;
            }
            this.f6418b.setTextSize(0, i11);
            this.f6419c.setText(String.format(Locale.ROOT, this.f6417a.j(), Integer.valueOf(iK)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (z.this.f6416c != null) {
                z.this.f6416c.a((seekBar.getProgress() * this.f6417a.o()) + this.f6417a.k());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }
}
