package w5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import x7.p;
import x7.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public List f13271a;

    /* renamed from: b, reason: collision with root package name */
    public int f13272b;

    /* renamed from: c, reason: collision with root package name */
    public HashSet f13273c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13274d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsListView f13275a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f13276b;

        public a(AbsListView absListView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f13275a = absListView;
            this.f13276b = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            d.this.h(this.f13275a, i10);
            AdapterView.OnItemClickListener onItemClickListener = this.f13276b;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements AdapterView.OnItemLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemLongClickListener f13278a;

        public b(AdapterView.OnItemLongClickListener onItemLongClickListener) {
            this.f13278a = onItemLongClickListener;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemLongClickListener onItemLongClickListener = this.f13278a;
            return onItemLongClickListener != null && onItemLongClickListener.onItemLongClick(adapterView, view, i10, j10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public CheckBox f13280a;

        public c(View view) {
            this.f13280a = (CheckBox) view.findViewById(p.f13807h);
        }
    }

    public d(List list, int[] iArr, boolean z10) {
        this.f13272b = -1;
        this.f13271a = list;
        this.f13274d = z10;
        if (!z10) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            this.f13272b = iArr[0];
            return;
        }
        this.f13273c = new HashSet();
        for (int i10 : iArr) {
            this.f13273c.add(Integer.valueOf(i10));
        }
    }

    public static c e(AbsListView absListView, int i10) {
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return null;
        }
        return (c) absListView.getChildAt(i10 - firstVisiblePosition).getTag();
    }

    public void b(AbsListView absListView, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        absListView.setAdapter((ListAdapter) this);
        absListView.setOnItemClickListener(new a(absListView, onItemClickListener));
        absListView.setOnItemLongClickListener(new b(onItemLongClickListener));
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getItem(int i10) {
        return (String) this.f13271a.get(i10);
    }

    public int[] d() {
        if (!this.f13274d) {
            return new int[]{this.f13272b};
        }
        int[] iArr = new int[this.f13273c.size()];
        Iterator it = this.f13273c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Integer) it.next()).intValue();
            i10++;
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public boolean f() {
        return this.f13274d;
    }

    public void g(AbsListView absListView, int i10) {
        c cVarE = e(absListView, i10);
        if (cVarE != null) {
            i(cVarE, i10);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13271a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.f13886u, viewGroup, false);
            x8.g.d((TextView) view.findViewById(p.f13807h));
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        i(cVar, i10);
        return view;
    }

    public final void h(AbsListView absListView, int i10) {
        if (this.f13274d) {
            if (this.f13273c.contains(Integer.valueOf(i10))) {
                this.f13273c.remove(Integer.valueOf(i10));
            } else {
                this.f13273c.add(Integer.valueOf(i10));
            }
            g(absListView, i10);
            return;
        }
        int i11 = this.f13272b;
        if (i10 != i11) {
            this.f13272b = i10;
            g(absListView, i11);
            g(absListView, i10);
        }
    }

    public final void i(c cVar, int i10) {
        if (cVar == null) {
            return;
        }
        cVar.f13280a.setEnabled(false);
        cVar.f13280a.setText((CharSequence) this.f13271a.get(i10));
        if (this.f13274d) {
            cVar.f13280a.setChecked(this.f13273c.contains(Integer.valueOf(i10)));
        } else {
            cVar.f13280a.setChecked(i10 == this.f13272b);
        }
        cVar.f13280a.setFocusable(false);
        cVar.f13280a.setClickable(false);
    }
}
