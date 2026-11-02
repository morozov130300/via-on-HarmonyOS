package c9;

import android.R;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o implements ActionMode.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f3031a;

    /* renamed from: b, reason: collision with root package name */
    public List f3032b;

    /* renamed from: c, reason: collision with root package name */
    public b f3033c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3034a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3035b;

        public a(int i10, String str) {
            this.f3034a = i10;
            this.f3035b = str;
        }

        public int a() {
            return this.f3034a;
        }

        public String b() {
            return this.f3035b;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(a aVar, CharSequence charSequence);
    }

    public o(TextView textView) {
        this.f3031a = new WeakReference(textView);
    }

    public void a(List list) {
        this.f3032b = list;
    }

    public void b(b bVar) {
        this.f3033c = bVar;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        List list = this.f3032b;
        if (list != null && !list.isEmpty() && this.f3033c != null) {
            int itemId = menuItem.getItemId();
            for (a aVar : this.f3032b) {
                if (itemId == aVar.a()) {
                    WeakReference weakReference = this.f3031a;
                    TextView textView = weakReference == null ? null : (TextView) weakReference.get();
                    if (textView == null) {
                        return true;
                    }
                    this.f3033c.a(aVar, textView.getText().subSequence(Math.max(0, textView.getSelectionStart()), Math.max(0, textView.getSelectionEnd())));
                    actionMode.finish();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        List list = this.f3032b;
        if (list != null && !list.isEmpty()) {
            int size = menu.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                if (menu.getItem(i11).getItemId() == 16908321) {
                    i10 = i11;
                }
            }
            for (a aVar : this.f3032b) {
                menu.add(0, aVar.a(), i10, aVar.b());
            }
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        List list = this.f3032b;
        if (list != null && !list.isEmpty()) {
            menu.removeItem(R.id.selectAll);
            menu.removeItem(R.id.cut);
            if (Build.VERSION.SDK_INT >= 23) {
                menu.removeItem(R.id.shareText);
            }
        }
        return true;
    }
}
