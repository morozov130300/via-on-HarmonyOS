package e8;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4840a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4841b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void V();

        void z(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback);
    }

    public l(Context context, a aVar) {
        this.f4840a = context;
        this.f4841b = aVar;
    }

    @Override // p4.a
    public View a() {
        return LayoutInflater.from(this.f4840a).inflate(x7.r.f13866a, (ViewGroup) ((Activity) this.f4840a).findViewById(R.id.content), false);
    }

    @Override // p4.a
    public boolean i() {
        this.f4841b.V();
        return true;
    }

    @Override // p4.a
    public boolean y(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f4841b.z(view, 0, customViewCallback);
        return true;
    }
}
