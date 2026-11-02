package d1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j {
    public static Executor a() {
        return new n(Executors.newSingleThreadExecutor());
    }
}
