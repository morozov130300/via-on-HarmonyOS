package io.reactivex.rxjava3.internal.util;

import java.io.Serializable;
import java.util.Objects;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public enum NotificationLite {
    COMPLETE;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final y6.b upstream;

        public DisposableNotification(y6.b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e, reason: collision with root package name */
        final Throwable f7468e;

        public ErrorNotification(Throwable th) {
            this.f7468e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return Objects.equals(this.f7468e, ((ErrorNotification) obj).f7468e);
            }
            return false;
        }

        public int hashCode() {
            return this.f7468e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f7468e + "]";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final oc.b upstream;

        public SubscriptionNotification(oc.b bVar) {
        }

        public String toString() {
            return "NotificationLite.Subscription[" + ((Object) null) + "]";
        }
    }

    public static <T> boolean accept(Object obj, oc.a aVar) {
        if (obj == COMPLETE) {
            aVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            aVar.onError(((ErrorNotification) obj).f7468e);
            return true;
        }
        aVar.onNext(obj);
        return false;
    }

    public static <T> boolean accept(Object obj, m mVar) {
        if (obj == COMPLETE) {
            mVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            mVar.onError(((ErrorNotification) obj).f7468e);
            return true;
        }
        mVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, oc.a aVar) {
        if (obj == COMPLETE) {
            aVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            aVar.onError(((ErrorNotification) obj).f7468e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            aVar.a(null);
            return false;
        }
        aVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, m mVar) {
        if (obj == COMPLETE) {
            mVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            mVar.onError(((ErrorNotification) obj).f7468e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            mVar.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        mVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(y6.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static y6.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f7468e;
    }

    public static oc.b getSubscription(Object obj) {
        ((SubscriptionNotification) obj).getClass();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t10) {
        return t10;
    }

    public static Object subscription(oc.b bVar) {
        return new SubscriptionNotification(bVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
