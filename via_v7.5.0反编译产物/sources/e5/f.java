package e5;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface f extends Executor {
    Future submit(Callable callable);
}
