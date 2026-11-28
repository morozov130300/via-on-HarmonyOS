package com.launchdarkly.eventsource;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface ConnectionErrorHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConnectionErrorHandler f3490a = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Action {
        PROCEED,
        SHUTDOWN
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements ConnectionErrorHandler {
        @Override // com.launchdarkly.eventsource.ConnectionErrorHandler
        public Action a(Throwable th) {
            return Action.PROCEED;
        }
    }

    Action a(Throwable th);
}
