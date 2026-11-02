package n;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c1 {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(c1 c1Var) {
            throw null;
        }

        public static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    public static RemoteInput a(c1 c1Var) {
        return a.b(c1Var);
    }

    public static RemoteInput[] b(c1[] c1VarArr) {
        if (c1VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c1VarArr.length];
        for (int i10 = 0; i10 < c1VarArr.length; i10++) {
            c1 c1Var = c1VarArr[i10];
            remoteInputArr[i10] = a(null);
        }
        return remoteInputArr;
    }
}
