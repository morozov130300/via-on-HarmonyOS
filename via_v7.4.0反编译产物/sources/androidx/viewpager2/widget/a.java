package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f1702b;

    /* renamed from: a, reason: collision with root package name */
    public LinearLayoutManager f1703a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    public class C0025a implements Comparator {
        public C0025a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f1702b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public a(LinearLayoutManager linearLayoutManager) {
        this.f1703a = linearLayoutManager;
    }

    public static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        int top;
        int i10;
        int bottom;
        int i11;
        int iK = this.f1703a.K();
        if (iK == 0) {
            return true;
        }
        boolean z10 = this.f1703a.o2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iK, 2);
        for (int i12 = 0; i12 < iK; i12++) {
            View viewJ = this.f1703a.J(i12);
            if (viewJ == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewJ.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f1702b;
            int[] iArr2 = iArr[i12];
            if (z10) {
                top = viewJ.getLeft();
                i10 = marginLayoutParams.leftMargin;
            } else {
                top = viewJ.getTop();
                i10 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i10;
            int[] iArr3 = iArr[i12];
            if (z10) {
                bottom = viewJ.getRight();
                i11 = marginLayoutParams.rightMargin;
            } else {
                bottom = viewJ.getBottom();
                i11 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i11;
        }
        Arrays.sort(iArr, new C0025a());
        for (int i13 = 1; i13 < iK; i13++) {
            if (iArr[i13 - 1][1] != iArr[i13][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i14 = iArr4[1];
        int i15 = iArr4[0];
        return i15 <= 0 && iArr[iK - 1][1] >= i14 - i15;
    }

    public final boolean b() {
        int iK = this.f1703a.K();
        for (int i10 = 0; i10 < iK; i10++) {
            if (c(this.f1703a.J(i10))) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return (!a() || this.f1703a.K() <= 1) && b();
    }
}
