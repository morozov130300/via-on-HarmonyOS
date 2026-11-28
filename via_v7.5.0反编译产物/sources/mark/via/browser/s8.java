package mark.via.browser;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s8 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f9643a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(String str, String str2, String str3);
    }

    public s8() {
        super(Looper.getMainLooper());
    }

    public void a(a aVar) {
        this.f9643a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9643a == null || message.getData().isEmpty()) {
            return;
        }
        this.f9643a.a(message.getData().getString("url"), message.getData().getString("src"), message.getData().getString("title"));
    }
}
