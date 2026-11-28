package q5;

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
import w7.p;
import w7.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f11750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet f11752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11753d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsListView f11754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f11755b;

        public a(AbsListView absListView, AdapterView.OnItemClickListener onItemClickListener) {
            this.f11754a = absListView;
            this.f11755b = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            d.this.h(this.f11754a, i10);
            AdapterView.OnItemClickListener onItemClickListener = this.f11755b;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemLongClickListener f11757a;

        public b(AdapterView.OnItemLongClickListener onItemLongClickListener) {
            this.f11757a = onItemLongClickListener;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemLongClickListener onItemLongClickListener = this.f11757a;
            return onItemLongClickListener != null && onItemLongClickListener.onItemLongClick(adapterView, view, i10, j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CheckBox f11759a;

        public c(View view) {
            this.f11759a = (CheckBox) view.findViewById(p.f13873h);
        }
    }

    public d(List list, int[] iArr, boolean z10) {
        this.f11751b = -1;
        this.f11750a = list;
        this.f11753d = z10;
        if (!z10) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            this.f11751b = iArr[0];
            return;
        }
        this.f11752c = new HashSet();
        for (int i10 : iArr) {
            this.f11752c.add(Integer.valueOf(i10));
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
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getItem(int i10) {
        return (String) this.f11750a.get(i10);
    }

    public int[] d() {
        if (!this.f11753d) {
            return new int[]{this.f11751b};
        }
        int[] iArr = new int[this.f11752c.size()];
        Iterator it = this.f11752c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Integer) it.next()).intValue();
            i10++;
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public boolean f() {
        return this.f11753d;
    }

    public void g(AbsListView absListView, int i10) {
        c cVarE = e(absListView, i10);
        if (cVarE != null) {
            i(cVarE, i10);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11750a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.f13951t, viewGroup, false);
            v8.g.d((TextView) view.findViewById(p.f13873h));
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        i(cVar, i10);
        return view;
    }

    public final void h(AbsListView absListView, int i10) {
        if (this.f11753d) {
            if (this.f11752c.contains(Integer.valueOf(i10))) {
                this.f11752c.remove(Integer.valueOf(i10));
            } else {
                this.f11752c.add(Integer.valueOf(i10));
            }
            g(absListView, i10);
            return;
        }
        int i11 = this.f11751b;
        if (i10 != i11) {
            this.f11751b = i10;
            g(absListView, i11);
            g(absListView, i10);
        }
    }

    public final void i(c cVar, int i10) {
        if (cVar == null) {
            return;
        }
        cVar.f11759a.setEnabled(false);
        cVar.f11759a.setText((CharSequence) this.f11750a.get(i10));
        if (this.f11753d) {
            cVar.f11759a.setChecked(this.f11752c.contains(Integer.valueOf(i10)));
        } else {
            cVar.f11759a.setChecked(i10 == this.f11751b);
        }
        cVar.f11759a.setFocusable(false);
        cVar.f11759a.setClickable(false);
    }
}
