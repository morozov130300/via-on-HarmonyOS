package n;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c1 {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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
