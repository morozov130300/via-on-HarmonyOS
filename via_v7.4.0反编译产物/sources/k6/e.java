package k6;

import android.content.Context;
import android.text.Spanned;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        a a(i iVar);

        e build();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
    }

    public static a a(Context context) {
        return new f(context).a(io.noties.markwon.core.a.p());
    }

    public abstract Spanned b(String str);
}
