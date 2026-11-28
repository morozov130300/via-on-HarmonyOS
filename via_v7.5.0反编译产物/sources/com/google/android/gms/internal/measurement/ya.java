package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ya extends za {
    public ya(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final double a(Object obj, long j10) {
        return Double.longBitsToDouble(this.f3213a.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final float b(Object obj, long j10) {
        return Float.intBitsToFloat(this.f3213a.getInt(obj, j10));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.ab.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.ab.o(java.lang.Object, long, boolean):void */
    /* JADX WARN: Method inline failed with exception
    java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 2
    	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:831)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1782)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1751)
    	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:139)
    	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:172)
    	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:137)
    	at jadx.core.dex.regions.conditions.IfCondition.replaceArg(IfCondition.java:270)
    	at jadx.core.dex.instructions.mods.TernaryInsn.replaceArg(TernaryInsn.java:67)
    	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:141)
    	at jadx.core.dex.visitors.InlineMethods.replaceRegs(InlineMethods.java:127)
    	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:86)
    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
     */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.measurement.ab.o(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.za
    public final void c(Object obj, long j10, boolean z10) {
        if (ab.f2695h) {
            ab.n(obj, j10, z10);
        } else {
            ab.o(obj, j10, z10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void d(Object obj, long j10, byte b10) {
        if (ab.f2695h) {
            ab.d(obj, j10, b10);
        } else {
            ab.e(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void e(Object obj, long j10, double d10) {
        this.f3213a.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void f(Object obj, long j10, float f10) {
        this.f3213a.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final boolean g(Object obj, long j10) {
        return ab.f2695h ? ab.y(obj, j10) : ab.z(obj, j10);
    }
}
