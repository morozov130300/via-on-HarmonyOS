package ib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6385a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(int i10);

        void b(int i10);
    }

    public n(a aVar) {
        this.f6385a = aVar;
    }

    public static /* synthetic */ void i(n nVar, int i10, View view) {
        a aVar = nVar.f6385a;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    public static /* synthetic */ boolean k(n nVar, int i10, View view) {
        a aVar = nVar.f6385a;
        if (aVar == null) {
            return true;
        }
        aVar.b(i10);
        return true;
    }

    public static /* synthetic */ void l(n nVar, float f10, boolean z10) {
        if (nVar.f6385a == null || !z10 || Math.abs(f10) < 1.0f) {
            return;
        }
        nVar.f6385a.a(f10 > 0.0f ? 5 : 6);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, String str) {
        int[] iArr = {mark.via.common.widget.g0.f9930r, mark.via.common.widget.g0.f9931s, mark.via.common.widget.g0.f9932t, mark.via.common.widget.g0.f9933u, mark.via.common.widget.g0.f9934v};
        int[] iArr2 = {0, 1, 2, 3, 4};
        for (int i10 = 0; i10 < 5; i10++) {
            View viewFindViewById = gVar.f1138a.findViewById(iArr[i10]);
            final int i11 = iArr2[i10];
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ib.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.i(this.f6381a, i11, view);
                }
            });
            viewFindViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: ib.m
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return n.k(this.f6383a, i11, view);
                }
            });
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        com.tuyafeng.support.widget.a aVar = new com.tuyafeng.support.widget.a(context);
        aVar.setInterceptTouchEvent(true);
        aVar.setDragListener(new com.tuyafeng.support.widget.a.b() { // from class: ib.j
            @Override // com.tuyafeng.support.widget.a.b
            public final void a(float f10, boolean z10) {
                n.l(this.f6371a, f10, z10);
            }
        });
        aVar.addView((mark.via.common.widget.g0) new b6.a(new mark.via.common.widget.g0(context), new FrameLayout.LayoutParams(-1, Math.round(com.tuyafeng.support.utils.f.d(context, w7.n.f13749b) * 0.96f))).l());
        aVar.setBackground(new com.tuyafeng.support.utils.g().c(v8.h.e(context)).l(com.tuyafeng.support.utils.x.h(context, 1.0f)).k(com.tuyafeng.support.utils.f.b(context, w7.m.f13739c)).a());
        v5.r rVar = new v5.r(context);
        rVar.setBackground(null);
        rVar.setPadding(rVar.getPaddingLeft(), rVar.getPaddingTop(), rVar.getPaddingRight(), com.tuyafeng.support.utils.x.h(context, 4.0f));
        TextView textView = (TextView) rVar.findViewById(v5.r.f13418c);
        textView.setText(w7.u.Sg);
        textView.setTextAlignment(5);
        TextView textView2 = (TextView) rVar.findViewById(v5.r.f13419e);
        textView2.setText(w7.u.Tg);
        textView2.setTextAlignment(5);
        textView2.setMaxLines(Integer.MAX_VALUE);
        textView2.setEllipsize(null);
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new ViewGroup.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: ib.k
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(rVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(rVar.getPaddingLeft(), 0, rVar.getPaddingRight(), rVar.getPaddingTop());
        linearLayout.addView(aVar, layoutParams);
        return new w5.g(linearLayout);
    }
}
