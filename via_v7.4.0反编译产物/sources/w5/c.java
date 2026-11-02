package w5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import w5.k;
import x7.p;
import x7.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13268a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13269b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13270a;

        public b() {
        }
    }

    public c(Context context, List list) {
        super(context, 0, list);
        this.f13268a = false;
        this.f13269b = false;
    }

    public void a(boolean z10) {
        this.f13269b = z10;
    }

    public void b(List list) {
        clear();
        addAll(list);
        notifyDataSetChanged();
    }

    public void c(boolean z10) {
        this.f13268a = z10;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i10) {
        if (((k.l) getItem(i10)) != null) {
            return r3.a();
        }
        return -1L;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        k.l lVar = (k.l) getItem(i10);
        if (view == null) {
            bVar = new b();
            viewInflate = LayoutInflater.from(getContext()).inflate(r.f13887v, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(p.f13806g1);
            bVar.f13270a = textView;
            textView.setTextColor(this.f13268a ? x8.h.j(getContext()) : x8.h.p(getContext()));
            if (this.f13269b) {
                bVar.f13270a.setGravity(17);
            }
            viewInflate.setTag(bVar);
            x8.g.d(bVar.f13270a);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.f13270a.setText(lVar.b());
        return viewInflate;
    }
}
