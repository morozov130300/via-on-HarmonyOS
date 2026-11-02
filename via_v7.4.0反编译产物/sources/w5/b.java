package w5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import x7.m;
import x7.p;
import x7.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public List f13263a;

    /* renamed from: b, reason: collision with root package name */
    public int f13264b;

    /* renamed from: c, reason: collision with root package name */
    public HashSet f13265c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13266d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13267a;

        public a(View view) {
            TextView textView = (TextView) view.findViewById(p.f13806g1);
            this.f13267a = textView;
            textView.setGravity(17);
        }
    }

    public b(List list, int[] iArr, boolean z10) {
        this.f13264b = -1;
        this.f13263a = list;
        this.f13266d = z10;
        if (!z10) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            this.f13264b = iArr[0];
            return;
        }
        this.f13265c = new HashSet();
        for (int i10 : iArr) {
            this.f13265c.add(Integer.valueOf(i10));
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i10) {
        return (String) this.f13263a.get(i10);
    }

    public int[] b() {
        if (!this.f13266d) {
            return new int[]{this.f13264b};
        }
        int[] iArr = new int[this.f13265c.size()];
        Iterator it = this.f13265c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Integer) it.next()).intValue();
            i10++;
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public final void c(a aVar, int i10) {
        if (aVar == null) {
            return;
        }
        aVar.f13267a.setEnabled(false);
        aVar.f13267a.setText((CharSequence) this.f13263a.get(i10));
        boolean zContains = this.f13266d ? this.f13265c.contains(Integer.valueOf(i10)) : i10 == this.f13264b;
        TextView textView = aVar.f13267a;
        textView.setBackgroundColor(zContains ? textView.getResources().getColor(m.f13672b) : 0);
        aVar.f13267a.setFocusable(false);
        aVar.f13267a.setClickable(false);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13263a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.f13887v, viewGroup, false);
            x8.g.d((TextView) view);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        c(aVar, i10);
        return view;
    }
}
