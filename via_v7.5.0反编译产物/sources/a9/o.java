package a9;

import android.R;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f262c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f264b;

        public a(int i10, String str) {
            this.f263a = i10;
            this.f264b = str;
        }

        public int a() {
            return this.f263a;
        }

        public String b() {
            return this.f264b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(a aVar, CharSequence charSequence);
    }

    public o(TextView textView) {
        this.f260a = new WeakReference(textView);
    }

    public void a(List list) {
        this.f261b = list;
    }

    public void b(b bVar) {
        this.f262c = bVar;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        List list = this.f261b;
        if (list != null && !list.isEmpty() && this.f262c != null) {
            int itemId = menuItem.getItemId();
            for (a aVar : this.f261b) {
                if (itemId == aVar.a()) {
                    WeakReference weakReference = this.f260a;
                    TextView textView = weakReference == null ? null : (TextView) weakReference.get();
                    if (textView == null) {
                        return true;
                    }
                    this.f262c.a(aVar, textView.getText().subSequence(Math.max(0, textView.getSelectionStart()), Math.max(0, textView.getSelectionEnd())));
                    actionMode.finish();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        List list = this.f261b;
        if (list != null && !list.isEmpty()) {
            int size = menu.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                if (menu.getItem(i11).getItemId() == 16908321) {
                    i10 = i11;
                }
            }
            for (a aVar : this.f261b) {
                menu.add(0, aVar.a(), i10, aVar.b());
            }
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        List list = this.f261b;
        if (list != null && !list.isEmpty()) {
            menu.removeItem(R.id.selectAll);
            menu.removeItem(R.id.cut);
            if (Build.VERSION.SDK_INT >= 23) {
                menu.removeItem(R.id.shareText);
            }
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
    }
}
