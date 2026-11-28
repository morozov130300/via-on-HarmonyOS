package q5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import w7.p;
import w7.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends ArrayAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11748b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f11749a;

        public b() {
        }
    }

    public c(Context context, List list) {
        super(context, 0, list);
        this.f11747a = false;
        this.f11748b = false;
    }

    public void a(boolean z10) {
        this.f11748b = z10;
    }

    public void b(List list) {
        clear();
        addAll(list);
        notifyDataSetChanged();
    }

    public void c(boolean z10) {
        this.f11747a = z10;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i10) {
        k.l lVar = (k.l) getItem(i10);
        if (lVar != null) {
            return lVar.a();
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
            viewInflate = LayoutInflater.from(getContext()).inflate(r.f13952u, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(p.f13872g1);
            bVar.f11749a = textView;
            textView.setTextColor(this.f11747a ? v8.h.j(getContext()) : v8.h.o(getContext()));
            if (this.f11748b) {
                bVar.f11749a.setGravity(17);
            }
            viewInflate.setTag(bVar);
            v8.g.d(bVar.f11749a);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.f11749a.setText(lVar.b());
        return viewInflate;
    }
}
