package q5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import w7.m;
import w7.p;
import w7.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f11742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet f11744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11745d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f11746a;

        public a(View view) {
            TextView textView = (TextView) view.findViewById(p.f13872g1);
            this.f11746a = textView;
            textView.setGravity(17);
        }
    }

    public b(List list, int[] iArr, boolean z10) {
        this.f11743b = -1;
        this.f11742a = list;
        this.f11745d = z10;
        if (!z10) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            this.f11743b = iArr[0];
            return;
        }
        this.f11744c = new HashSet();
        for (int i10 : iArr) {
            this.f11744c.add(Integer.valueOf(i10));
        }
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i10) {
        return (String) this.f11742a.get(i10);
    }

    public int[] b() {
        if (!this.f11745d) {
            return new int[]{this.f11743b};
        }
        int[] iArr = new int[this.f11744c.size()];
        Iterator it = this.f11744c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Integer) it.next()).intValue();
            i10++;
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public final void c(a aVar, int i10) {
        boolean zContains;
        if (aVar == null) {
            return;
        }
        aVar.f11746a.setEnabled(false);
        aVar.f11746a.setText((CharSequence) this.f11742a.get(i10));
        if (this.f11745d) {
            zContains = this.f11744c.contains(Integer.valueOf(i10));
        } else {
            zContains = i10 == this.f11743b;
        }
        TextView textView = aVar.f11746a;
        textView.setBackgroundColor(zContains ? textView.getResources().getColor(m.f13738b) : 0);
        aVar.f11746a.setFocusable(false);
        aVar.f11746a.setClickable(false);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11742a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(r.f13952u, viewGroup, false);
            v8.g.d((TextView) view);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        c(aVar, i10);
        return view;
    }
}
