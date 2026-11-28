package io.reactivex.rxjava3.internal.util;

import java.io.Serializable;
import java.util.Objects;
import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public enum NotificationLite {
    COMPLETE;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final s6.b upstream;

        public DisposableNotification(s6.b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Throwable f6703e;

        public ErrorNotification(Throwable th) {
            this.f6703e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return Objects.equals(this.f6703e, ((ErrorNotification) obj).f6703e);
            }
            return false;
        }

        public int hashCode() {
            return this.f6703e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f6703e + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final sc.b upstream;

        public SubscriptionNotification(sc.b bVar) {
        }

        public String toString() {
            return "NotificationLite.Subscription[" + ((Object) null) + "]";
        }
    }

    public static <T> boolean accept(Object obj, sc.a aVar) {
        if (obj == COMPLETE) {
            aVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            aVar.onError(((ErrorNotification) obj).f6703e);
            return true;
        }
        aVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, sc.a aVar) {
        if (obj == COMPLETE) {
            aVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            aVar.onError(((ErrorNotification) obj).f6703e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            aVar.a(null);
            return false;
        }
        aVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(s6.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static s6.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f6703e;
    }

    public static sc.b getSubscription(Object obj) {
        ((SubscriptionNotification) obj).getClass();
        return null;
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

    public static Object subscription(sc.b bVar) {
        return new SubscriptionNotification(bVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, o oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            oVar.onError(((ErrorNotification) obj).f6703e);
            return true;
        }
        oVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, o oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            oVar.onError(((ErrorNotification) obj).f6703e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            oVar.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        oVar.onNext(obj);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t10) {
        return t10;
    }
}
