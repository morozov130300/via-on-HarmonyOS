package ib;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tuyafeng.support.widget.a;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m extends y5.d {

    /* renamed from: b, reason: collision with root package name */
    public static final int f7151b = g6.y.l();

    /* renamed from: a, reason: collision with root package name */
    public final a f7152a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(int i10);

        void b(int i10);
    }

    public m(a aVar) {
        this.f7152a = aVar;
    }

    public static /* synthetic */ void i(m mVar, int i10, View view) {
        a aVar = mVar.f7152a;
        if (aVar != null) {
            aVar.b(i10);
        }
    }

    public static /* synthetic */ void j(TextView textView) {
        textView.setText(x7.u.Gg);
        x8.g.d(textView);
    }

    public static /* synthetic */ boolean l(m mVar, int i10, View view) {
        a aVar = mVar.f7152a;
        if (aVar == null) {
            return true;
        }
        aVar.a(i10);
        return true;
    }

    public static /* synthetic */ void m(m mVar, float f10, boolean z10) {
        if (mVar.f7152a == null || !z10 || Math.abs(f10) < 0.8d) {
            return;
        }
        mVar.f7152a.b(f10 > 0.0f ? 5 : 6);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, String str) {
        int[] iArr = {mark.via.common.widget.g0.f9639p, mark.via.common.widget.g0.f9640q, mark.via.common.widget.g0.f9641r, mark.via.common.widget.g0.f9642s, mark.via.common.widget.g0.f9643t};
        int[] iArr2 = {0, 1, 2, 3, 4};
        for (int i10 = 0; i10 < 5; i10++) {
            View viewFindViewById = gVar.f1219a.findViewById(iArr[i10]);
            final int i11 = iArr2[i10];
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ib.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.i(this.f7144a, i11, view);
                }
            });
            viewFindViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: ib.k
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return m.l(this.f7146a, i11, view);
                }
            });
        }
        com.tuyafeng.support.widget.a aVar = (com.tuyafeng.support.widget.a) gVar.f1219a.findViewById(f7151b);
        aVar.setInterceptTouchEvent(true);
        aVar.g(new a.b() { // from class: ib.l
            @Override // com.tuyafeng.support.widget.a.b
            public final void a(float f10, boolean z10) {
                m.m(this.f7149a, f10, z10);
            }
        });
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        com.tuyafeng.support.widget.a aVar = (com.tuyafeng.support.widget.a) new h6.a(new com.tuyafeng.support.widget.a(context), new FrameLayout.LayoutParams(-1, -2)).o(f7151b).l();
        aVar.addView((mark.via.common.widget.g0) new h6.a(new mark.via.common.widget.g0(context), new FrameLayout.LayoutParams(-1, g6.f.d(context, x7.n.f13683b))).l());
        TextView textView = (TextView) new h6.a(new TextView(new ContextThemeWrapper(context, x7.v.f14260g)), new FrameLayout.LayoutParams(-1, -2)).H(1, 16, 10, 16, 10).V(new a.InterfaceC0076a() { // from class: ib.h
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                m.j((TextView) obj);
            }
        }).l();
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(context), new ViewGroup.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: ib.i
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(aVar);
        return new b6.g(linearLayout);
    }
}
