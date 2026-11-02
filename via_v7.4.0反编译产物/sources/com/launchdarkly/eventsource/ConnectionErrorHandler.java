package com.launchdarkly.eventsource;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface ConnectionErrorHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final ConnectionErrorHandler f4193a = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum Action {
        PROCEED,
        SHUTDOWN
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements ConnectionErrorHandler {
        @Override // com.launchdarkly.eventsource.ConnectionErrorHandler
        public Action a(Throwable th) {
            return Action.PROCEED;
        }
    }

    Action a(Throwable th);
}
