package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class CallableReference implements t7.b, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f7305c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient t7.b f7304c;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class NoReceiver implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final NoReceiver f7305c = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return f7305c;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // t7.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // t7.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public t7.b compute() {
        t7.b bVar = this.f7304c;
        if (bVar != null) {
            return bVar;
        }
        t7.b bVarComputeReflected = computeReflected();
        this.f7304c = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract t7.b computeReflected();

    @Override // t7.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public t7.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? j.c(cls) : j.b(cls);
    }

    @Override // t7.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public t7.b getReflected() {
        t7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // t7.b
    public t7.f getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // t7.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // t7.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // t7.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // t7.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // t7.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // t7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
