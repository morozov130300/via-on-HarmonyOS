package mark.via.settings.helper;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import t5.d;
import v5.r;
import w5.g;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class FabPreferenceViewDelegate extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10342b = x.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10343a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Item {
        INSTANCE
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(int i10);
    }

    public FabPreferenceViewDelegate(a aVar) {
        this.f10343a = aVar;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, Item item) {
        ((mark.via.settings.helper.a) gVar.P(f10342b)).c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public g d(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutDirection(3);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r rVar = new r(context);
        rVar.setBackground(null);
        linearLayout.setPadding(rVar.getPaddingLeft(), 0, rVar.getPaddingRight(), 0);
        rVar.setPadding(0, rVar.getPaddingTop(), 0, rVar.getPaddingBottom());
        TextView textView = (TextView) rVar.findViewById(r.f13418c);
        textView.setText(u.f14238t5);
        textView.setTextAlignment(5);
        TextView textView2 = (TextView) rVar.findViewById(r.f13419e);
        textView2.setText(u.f14224s5);
        textView2.setTextAlignment(5);
        textView2.setMaxLines(Integer.MAX_VALUE);
        textView2.setEllipsize(null);
        linearLayout.addView(rVar, new LinearLayout.LayoutParams(0, -2, 4.0f));
        int iH = x.h(context, 36.0f);
        int iH2 = x.h(context, 16.0f);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setMinimumHeight((iH2 * 2) + iH);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, -1, 1.0f));
        mark.via.settings.helper.a aVar = new mark.via.settings.helper.a(context, this.f10343a);
        aVar.setId(f10342b);
        frameLayout.addView(aVar, new FrameLayout.LayoutParams(iH, iH, 17));
        return new g(linearLayout);
    }
}
