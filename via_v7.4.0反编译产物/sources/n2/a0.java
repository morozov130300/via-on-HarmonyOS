package n2;

import com.google.firebase.concurrent.SequentialExecutor;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a0 {
    public static Executor a(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
