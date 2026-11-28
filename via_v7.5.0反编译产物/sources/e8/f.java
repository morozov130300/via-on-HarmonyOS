package e8;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import w7.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends t5.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4288b = x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4289c = x.l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4290d = x.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4291a = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(int i10);
    }

    public static /* synthetic */ void i(Context context, TextView textView) {
        textView.setText("A+");
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(v8.h.o(context));
        v8.g.d(textView);
    }

    public static /* synthetic */ void j(f fVar, SeekBar seekBar, View view) {
        fVar.getClass();
        seekBar.setProgress(seekBar.getProgress() + (f4288b == view.getId() ? 1 : -1));
        b bVar = fVar.f4291a;
        if (bVar != null) {
            bVar.a(seekBar.getProgress() + 10);
        }
    }

    public static /* synthetic */ void k(Context context, TextView textView) {
        textView.setText("A-");
        textView.setGravity(17);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(v8.h.o(context));
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, e8.a aVar) {
        final SeekBar seekBar = (SeekBar) gVar.P(f4290d);
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(20);
        seekBar.setProgress(Math.min(20, Math.max(0, aVar.a() - 10)));
        seekBar.setOnSeekBarChangeListener(new a());
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: e8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.j(this.f4284a, seekBar, view);
            }
        };
        gVar.P(f4288b).setOnClickListener(onClickListener);
        gVar.P(f4289c).setOnClickListener(onClickListener);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, x.h(context, 48.0f))).N(1, 8).T(1, 4).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).o(f4289c).d(w7.o.f13783d).N(1, 8).V(new b6.a.InterfaceC0033a() { // from class: e8.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.k(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).o(f4288b).d(w7.o.f13783d).N(1, 8).V(new b6.a.InterfaceC0033a() { // from class: e8.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.i(context, (TextView) obj);
            }
        }).l();
        SeekBar seekBar = (SeekBar) new b6.a(new SeekBar(new ContextThemeWrapper(context, v.f14329f)), new LinearLayout.LayoutParams(-1, -2)).o(f4290d).p(16).W(1.0f).V(new e()).l();
        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        linearLayout.addView(textView2);
        return new w5.g(linearLayout);
    }

    public void o(b bVar) {
        this.f4291a = bVar;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (f.this.f4291a != null) {
                f.this.f4291a.a(seekBar.getProgress() + 10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }
    }
}
