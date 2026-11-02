package c8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class qa extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public a f2789a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(String str, String str2, String str3);
    }

    public qa() {
        super(Looper.getMainLooper());
    }

    public void a(a aVar) {
        this.f2789a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2789a == null || message.getData().isEmpty()) {
            return;
        }
        this.f2789a.a(message.getData().getString("url"), message.getData().getString("src"), message.getData().getString("title"));
    }
}
