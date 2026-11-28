package androidx.recyclerview.widget;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public boolean I;
    public int J;
    public int[] K;
    public android.view.View[] L;
    public final android.util.SparseIntArray M;
    public final android.util.SparseIntArray N;
    public androidx.recyclerview.widget.GridLayoutManager.c O;
    public final android.graphics.Rect P;
    public boolean Q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends androidx.recyclerview.widget.GridLayoutManager.c {
        public a() {
                r0 = this;
                r0.<init>()
                return
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int r1, int r2) {
                r0 = this;
                int r1 = r1 % r2
                return r1
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int r1) {
                r0 = this;
                r1 = 1
                return r1
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends androidx.recyclerview.widget.RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1025f;

        public b(int r1, int r2) {
                r0 = this;
                r0.<init>(r1, r2)
                r1 = -1
                r0.f1024e = r1
                r1 = 0
                r0.f1025f = r1
                return
        }

        public b(android.content.Context r1, android.util.AttributeSet r2) {
                r0 = this;
                r0.<init>(r1, r2)
                r1 = -1
                r0.f1024e = r1
                r1 = 0
                r0.f1025f = r1
                return
        }

        public b(android.view.ViewGroup.LayoutParams r1) {
                r0 = this;
                r0.<init>(r1)
                r1 = -1
                r0.f1024e = r1
                r1 = 0
                r0.f1025f = r1
                return
        }

        public b(android.view.ViewGroup.MarginLayoutParams r1) {
                r0 = this;
                r0.<init>(r1)
                r1 = -1
                r0.f1024e = r1
                r1 = 0
                r0.f1025f = r1
                return
        }

        public int e() {
                r1 = this;
                int r0 = r1.f1024e
                return r0
        }

        public int f() {
                r1 = this;
                int r0 = r1.f1025f
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final android.util.SparseIntArray f1026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final android.util.SparseIntArray f1027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1029d;

        public c() {
                r1 = this;
                r1.<init>()
                android.util.SparseIntArray r0 = new android.util.SparseIntArray
                r0.<init>()
                r1.f1026a = r0
                android.util.SparseIntArray r0 = new android.util.SparseIntArray
                r0.<init>()
                r1.f1027b = r0
                r0 = 0
                r1.f1028c = r0
                r1.f1029d = r0
                return
        }

        public static int a(android.util.SparseIntArray r4, int r5) {
                int r0 = r4.size()
                int r0 = r0 + (-1)
                r1 = 0
            L7:
                if (r1 > r0) goto L1b
                int r2 = r1 + r0
                int r2 = r2 >>> 1
                int r3 = r4.keyAt(r2)
                if (r3 >= r5) goto L17
                int r2 = r2 + 1
                r1 = r2
                goto L7
            L17:
                int r2 = r2 + (-1)
                r0 = r2
                goto L7
            L1b:
                int r1 = r1 + (-1)
                if (r1 < 0) goto L2a
                int r5 = r4.size()
                if (r1 >= r5) goto L2a
                int r4 = r4.keyAt(r1)
                return r4
            L2a:
                r4 = -1
                return r4
        }

        public int b(int r3, int r4) {
                r2 = this;
                boolean r0 = r2.f1029d
                if (r0 != 0) goto L9
                int r3 = r2.d(r3, r4)
                return r3
            L9:
                android.util.SparseIntArray r0 = r2.f1027b
                r1 = -1
                int r0 = r0.get(r3, r1)
                if (r0 == r1) goto L13
                return r0
            L13:
                int r4 = r2.d(r3, r4)
                android.util.SparseIntArray r0 = r2.f1027b
                r0.put(r3, r4)
                return r4
        }

        public int c(int r3, int r4) {
                r2 = this;
                boolean r0 = r2.f1028c
                if (r0 != 0) goto L9
                int r3 = r2.e(r3, r4)
                return r3
            L9:
                android.util.SparseIntArray r0 = r2.f1026a
                r1 = -1
                int r0 = r0.get(r3, r1)
                if (r0 == r1) goto L13
                return r0
            L13:
                int r4 = r2.e(r3, r4)
                android.util.SparseIntArray r0 = r2.f1026a
                r0.put(r3, r4)
                return r4
        }

        public int d(int r7, int r8) {
                r6 = this;
                boolean r0 = r6.f1029d
                r1 = 0
                if (r0 == 0) goto L25
                android.util.SparseIntArray r0 = r6.f1027b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L25
                android.util.SparseIntArray r2 = r6.f1027b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L28
                int r2 = r2 + 1
            L23:
                r4 = 0
                goto L28
            L25:
                r2 = 0
                r3 = 0
                goto L23
            L28:
                int r0 = r6.f(r7)
            L2c:
                if (r3 >= r7) goto L41
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L39
                int r2 = r2 + 1
                r4 = 0
                goto L3e
            L39:
                if (r4 <= r8) goto L3e
                int r2 = r2 + 1
                r4 = r5
            L3e:
                int r3 = r3 + 1
                goto L2c
            L41:
                int r4 = r4 + r0
                if (r4 <= r8) goto L46
                int r2 = r2 + 1
            L46:
                return r2
        }

        public int e(int r6, int r7) {
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f1028c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f1026a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f1026a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = 0
                r3 = 0
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = 0
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
        }

        public abstract int f(int r1);

        public void g() {
                r1 = this;
                android.util.SparseIntArray r0 = r1.f1027b
                r0.clear()
                return
        }

        public void h() {
                r1 = this;
                android.util.SparseIntArray r0 = r1.f1026a
                r0.clear()
                return
        }
    }

    public GridLayoutManager(android.content.Context r1, int r2) {
            r0 = this;
            r0.<init>(r1)
            r1 = 0
            r0.I = r1
            r1 = -1
            r0.J = r1
            android.util.SparseIntArray r1 = new android.util.SparseIntArray
            r1.<init>()
            r0.M = r1
            android.util.SparseIntArray r1 = new android.util.SparseIntArray
            r1.<init>()
            r0.N = r1
            androidx.recyclerview.widget.GridLayoutManager$a r1 = new androidx.recyclerview.widget.GridLayoutManager$a
            r1.<init>()
            r0.O = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.P = r1
            r0.e3(r2)
            return
    }

    public GridLayoutManager(android.content.Context r1, int r2, int r3, boolean r4) {
            r0 = this;
            r0.<init>(r1, r3, r4)
            r1 = 0
            r0.I = r1
            r1 = -1
            r0.J = r1
            android.util.SparseIntArray r1 = new android.util.SparseIntArray
            r1.<init>()
            r0.M = r1
            android.util.SparseIntArray r1 = new android.util.SparseIntArray
            r1.<init>()
            r0.N = r1
            androidx.recyclerview.widget.GridLayoutManager$a r1 = new androidx.recyclerview.widget.GridLayoutManager$a
            r1.<init>()
            r0.O = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.P = r1
            r0.e3(r2)
            return
    }

    public GridLayoutManager(android.content.Context r2, android.util.AttributeSet r3, int r4, int r5) {
            r1 = this;
            r1.<init>(r2, r3, r4, r5)
            r0 = 0
            r1.I = r0
            r0 = -1
            r1.J = r0
            android.util.SparseIntArray r0 = new android.util.SparseIntArray
            r0.<init>()
            r1.M = r0
            android.util.SparseIntArray r0 = new android.util.SparseIntArray
            r0.<init>()
            r1.N = r0
            androidx.recyclerview.widget.GridLayoutManager$a r0 = new androidx.recyclerview.widget.GridLayoutManager$a
            r0.<init>()
            r1.O = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r1.P = r0
            androidx.recyclerview.widget.RecyclerView$o$d r2 = androidx.recyclerview.widget.RecyclerView.o.j0(r2, r3, r4, r5)
            int r2 = r2.f1192b
            r1.e3(r2)
            return
    }

    public static int[] Q2(int[] r5, int r6, int r7) {
            r0 = 1
            if (r5 == 0) goto Le
            int r1 = r5.length
            int r2 = r6 + 1
            if (r1 != r2) goto Le
            int r1 = r5.length
            int r1 = r1 - r0
            r1 = r5[r1]
            if (r1 == r7) goto L12
        Le:
            int r5 = r6 + 1
            int[] r5 = new int[r5]
        L12:
            r1 = 0
            r5[r1] = r1
            int r2 = r7 / r6
            int r7 = r7 % r6
            r3 = 0
        L19:
            if (r0 > r6) goto L2d
            int r1 = r1 + r7
            if (r1 <= 0) goto L26
            int r4 = r6 - r1
            if (r4 >= r7) goto L26
            int r4 = r2 + 1
            int r1 = r1 - r6
            goto L27
        L26:
            r4 = r2
        L27:
            int r3 = r3 + r4
            r5[r0] = r3
            int r0 = r0 + 1
            goto L19
        L2d:
            return r5
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(android.graphics.Rect r5, int r6, int r7) {
            r4 = this;
            int[] r0 = r4.K
            if (r0 != 0) goto L7
            super.D1(r5, r6, r7)
        L7:
            int r0 = r4.f0()
            int r1 = r4.g0()
            int r0 = r0 + r1
            int r1 = r4.h0()
            int r2 = r4.e0()
            int r1 = r1 + r2
            int r2 = r4.f1030s
            r3 = 1
            if (r2 != r3) goto L3b
            int r5 = r5.height()
            int r5 = r5 + r1
            int r1 = r4.c0()
            int r5 = androidx.recyclerview.widget.RecyclerView.o.o(r7, r5, r1)
            int[] r7 = r4.K
            int r1 = r7.length
            int r1 = r1 - r3
            r7 = r7[r1]
            int r7 = r7 + r0
            int r0 = r4.d0()
            int r6 = androidx.recyclerview.widget.RecyclerView.o.o(r6, r7, r0)
            goto L57
        L3b:
            int r5 = r5.width()
            int r5 = r5 + r0
            int r0 = r4.d0()
            int r6 = androidx.recyclerview.widget.RecyclerView.o.o(r6, r5, r0)
            int[] r5 = r4.K
            int r0 = r5.length
            int r0 = r0 - r3
            r5 = r5[r0]
            int r5 = r5 + r1
            int r0 = r4.c0()
            int r5 = androidx.recyclerview.widget.RecyclerView.o.o(r7, r5, r0)
        L57:
            r4.C1(r6, r5)
            return
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public androidx.recyclerview.widget.RecyclerView.p E() {
            r3 = this;
            int r0 = r3.f1030s
            r1 = -1
            r2 = -2
            if (r0 != 0) goto Lc
            androidx.recyclerview.widget.GridLayoutManager$b r0 = new androidx.recyclerview.widget.GridLayoutManager$b
            r0.<init>(r2, r1)
            return r0
        Lc:
            androidx.recyclerview.widget.GridLayoutManager$b r0 = new androidx.recyclerview.widget.GridLayoutManager$b
            r0.<init>(r1, r2)
            return r0
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void E2(boolean r2) {
            r1 = this;
            if (r2 != 0) goto L7
            r2 = 0
            super.E2(r2)
            return
        L7:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "GridLayoutManager does not support stack from end. Consider using reverse layout"
            r2.<init>(r0)
            throw r2
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public androidx.recyclerview.widget.RecyclerView.p F(android.content.Context r2, android.util.AttributeSet r3) {
            r1 = this;
            androidx.recyclerview.widget.GridLayoutManager$b r0 = new androidx.recyclerview.widget.GridLayoutManager$b
            r0.<init>(r2, r3)
            return r0
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public androidx.recyclerview.widget.RecyclerView.p G(android.view.ViewGroup.LayoutParams r2) {
            r1 = this;
            boolean r0 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto Lc
            androidx.recyclerview.widget.GridLayoutManager$b r0 = new androidx.recyclerview.widget.GridLayoutManager$b
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            r0.<init>(r2)
            return r0
        Lc:
            androidx.recyclerview.widget.GridLayoutManager$b r0 = new androidx.recyclerview.widget.GridLayoutManager$b
            r0.<init>(r2)
            return r0
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public android.view.View K0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.C(r24)
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.b) r5
            int r6 = r5.f1024e
            int r5 = r5.f1025f
            int r5 = r5 + r6
            android.view.View r7 = super.K0(r24, r25, r26, r27)
            if (r7 != 0) goto L20
            return r4
        L20:
            r7 = r25
            int r7 = r0.S1(r7)
            r9 = 1
            if (r7 != r9) goto L2b
            r7 = 1
            goto L2c
        L2b:
            r7 = 0
        L2c:
            boolean r10 = r0.f1035x
            r11 = -1
            if (r7 == r10) goto L39
            int r7 = r0.K()
            int r7 = r7 - r9
            r10 = -1
            r12 = -1
            goto L40
        L39:
            int r7 = r0.K()
            r10 = r7
            r7 = 0
            r12 = 1
        L40:
            int r13 = r0.f1030s
            if (r13 != r9) goto L4c
            boolean r13 = r0.p2()
            if (r13 == 0) goto L4c
            r13 = 1
            goto L4d
        L4c:
            r13 = 0
        L4d:
            int r14 = r0.Y2(r1, r2, r7)
            r11 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L59:
            if (r11 == r10) goto L65
            int r9 = r0.Y2(r1, r2, r11)
            android.view.View r1 = r0.J(r11)
            if (r1 != r3) goto L6b
        L65:
            r21 = r4
            r19 = r7
            goto L138
        L6b:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L84
            if (r9 == r14) goto L84
            if (r4 == 0) goto L76
            goto L65
        L76:
            r18 = r3
            r21 = r4
        L7a:
            r19 = r7
            r20 = r8
        L7e:
            r4 = r16
            r7 = r17
            goto L127
        L84:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r2 = r9.f1024e
            r18 = r3
            int r3 = r9.f1025f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L9c
            if (r2 != r6) goto L9c
            if (r3 != r5) goto L9c
            return r1
        L9c:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto La4
            if (r4 == 0) goto Lac
        La4:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto Lb7
            if (r7 != 0) goto Lb7
        Lac:
            r21 = r4
        Lae:
            r19 = r7
            r20 = r8
            r4 = r16
            r7 = r17
            goto Lf5
        Lb7:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r4
            int r4 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto Ld6
            if (r4 <= r8) goto Lcc
        Lcb:
            goto Lae
        Lcc:
            if (r4 != r8) goto L7a
            if (r2 <= r15) goto Ld2
            r4 = 1
            goto Ld3
        Ld2:
            r4 = 0
        Ld3:
            if (r13 != r4) goto L7a
            goto Lcb
        Ld6:
            if (r21 != 0) goto L7a
            r19 = r7
            r20 = r8
            r7 = 0
            r8 = 1
            boolean r22 = r0.z0(r1, r7, r8)
            if (r22 == 0) goto L7e
            r7 = r17
            if (r4 <= r7) goto Leb
            r4 = r16
            goto Lf5
        Leb:
            if (r4 != r7) goto L125
            r4 = r16
            if (r2 <= r4) goto Lf2
            goto Lf3
        Lf2:
            r8 = 0
        Lf3:
            if (r13 != r8) goto L127
        Lf5:
            boolean r8 = r1.hasFocusable()
            if (r8 == 0) goto L111
            int r8 = r9.f1024e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r16 = r4
            r17 = r7
            r15 = r8
            r7 = r19
            r4 = r1
            r8 = r2
            goto L12e
        L111:
            int r4 = r9.f1024e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r7 = r1
            r16 = r4
        L120:
            r8 = r20
            r4 = r21
            goto L12e
        L125:
            r4 = r16
        L127:
            r16 = r4
            r17 = r7
            r7 = r19
            goto L120
        L12e:
            int r11 = r11 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r9 = 1
            goto L59
        L138:
            if (r21 == 0) goto L13b
            return r21
        L13b:
            return r19
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
            r1 = this;
            androidx.recyclerview.widget.LinearLayoutManager$SavedState r0 = r1.D
            if (r0 != 0) goto La
            boolean r0 = r1.I
            if (r0 != 0) goto La
            r0 = 1
            return r0
        La:
            r0 = 0
            return r0
    }

    public final void N2(androidx.recyclerview.widget.RecyclerView.v r5, androidx.recyclerview.widget.RecyclerView.a0 r6, int r7, boolean r8) {
            r4 = this;
            r0 = 0
            if (r8 == 0) goto L8
            r8 = 1
            r8 = r7
            r7 = 0
            r1 = 1
            goto Lc
        L8:
            int r7 = r7 + (-1)
            r8 = -1
            r1 = -1
        Lc:
            if (r7 == r8) goto L27
            android.view.View[] r2 = r4.L
            r2 = r2[r7]
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r3 = (androidx.recyclerview.widget.GridLayoutManager.b) r3
            int r2 = r4.i0(r2)
            int r2 = r4.a3(r5, r6, r2)
            r3.f1025f = r2
            r3.f1024e = r0
            int r0 = r0 + r2
            int r7 = r7 + r1
            goto Lc
        L27:
            return
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int O(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.RecyclerView.a0 r4) {
            r2 = this;
            int r0 = r2.f1030s
            r1 = 1
            if (r0 != r1) goto L8
            int r3 = r2.J
            return r3
        L8:
            int r0 = r4.b()
            if (r0 >= r1) goto L10
            r3 = 0
            return r3
        L10:
            int r0 = r4.b()
            int r0 = r0 - r1
            int r3 = r2.Y2(r3, r4, r0)
            int r3 = r3 + r1
            return r3
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void O1(androidx.recyclerview.widget.RecyclerView.a0 r6, androidx.recyclerview.widget.LinearLayoutManager.c r7, androidx.recyclerview.widget.RecyclerView.o.c r8) {
            r5 = this;
            int r0 = r5.J
            r1 = 0
            r2 = 0
        L4:
            int r3 = r5.J
            if (r2 >= r3) goto L2c
            boolean r3 = r7.c(r6)
            if (r3 == 0) goto L2c
            if (r0 <= 0) goto L2c
            int r3 = r7.f1053d
            int r4 = r7.f1056g
            int r4 = java.lang.Math.max(r1, r4)
            r8.a(r3, r4)
            androidx.recyclerview.widget.GridLayoutManager$c r4 = r5.O
            int r3 = r4.f(r3)
            int r0 = r0 - r3
            int r3 = r7.f1053d
            int r4 = r7.f1054e
            int r3 = r3 + r4
            r7.f1053d = r3
            int r2 = r2 + 1
            goto L4
        L2c:
            return
    }

    public final void O2() {
            r6 = this;
            int r0 = r6.K()
            r1 = 0
        L5:
            if (r1 >= r0) goto L2a
            android.view.View r2 = r6.J(r1)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r2 = (androidx.recyclerview.widget.GridLayoutManager.b) r2
            int r3 = r2.a()
            android.util.SparseIntArray r4 = r6.M
            int r5 = r2.f()
            r4.put(r3, r5)
            android.util.SparseIntArray r4 = r6.N
            int r2 = r2.e()
            r4.put(r3, r2)
            int r1 = r1 + 1
            goto L5
        L2a:
            return
    }

    public final void P2(int r3) {
            r2 = this;
            int[] r0 = r2.K
            int r1 = r2.J
            int[] r3 = Q2(r0, r1, r3)
            r2.K = r3
            return
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(androidx.recyclerview.widget.RecyclerView.v r8, androidx.recyclerview.widget.RecyclerView.a0 r9, android.view.View r10, z.d0 r11) {
            r7 = this;
            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager.b
            if (r1 != 0) goto Lc
            super.P0(r10, r11)
            return
        Lc:
            androidx.recyclerview.widget.GridLayoutManager$b r0 = (androidx.recyclerview.widget.GridLayoutManager.b) r0
            int r10 = r0.a()
            int r1 = r7.Y2(r8, r9, r10)
            int r8 = r7.f1030s
            if (r8 != 0) goto L2e
            r3 = r1
            int r1 = r0.e()
            int r2 = r0.f()
            r5 = 0
            r6 = 0
            r4 = 1
            z.d0$c r8 = z.d0.c.a(r1, r2, r3, r4, r5, r6)
            r11.W(r8)
            return
        L2e:
            r3 = r1
            int r8 = r0.e()
            int r4 = r0.f()
            r5 = 0
            r6 = 0
            r2 = 1
            r3 = r8
            z.d0$c r8 = z.d0.c.a(r1, r2, r3, r4, r5, r6)
            r11.W(r8)
            return
    }

    public final void R2() {
            r1 = this;
            android.util.SparseIntArray r0 = r1.M
            r0.clear()
            android.util.SparseIntArray r0 = r1.N
            r0.clear()
            return
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(androidx.recyclerview.widget.RecyclerView r1, int r2, int r3) {
            r0 = this;
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.h()
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.g()
            return
    }

    public final int S2(androidx.recyclerview.widget.RecyclerView.a0 r10) {
            r9 = this;
            int r0 = r9.K()
            r1 = 0
            if (r0 == 0) goto Lae
            int r0 = r10.b()
            if (r0 != 0) goto Lf
            goto Lae
        Lf:
            r9.U1()
            boolean r0 = r9.q2()
            r2 = r0 ^ 1
            r3 = 1
            android.view.View r2 = r9.Z1(r2, r3)
            r4 = r0 ^ 1
            android.view.View r4 = r9.Y1(r4, r3)
            if (r2 == 0) goto Lae
            if (r4 != 0) goto L29
            goto Lae
        L29:
            androidx.recyclerview.widget.GridLayoutManager$c r5 = r9.O
            int r6 = r9.i0(r2)
            int r7 = r9.J
            int r5 = r5.b(r6, r7)
            androidx.recyclerview.widget.GridLayoutManager$c r6 = r9.O
            int r7 = r9.i0(r4)
            int r8 = r9.J
            int r6 = r6.b(r7, r8)
            int r7 = java.lang.Math.min(r5, r6)
            int r5 = java.lang.Math.max(r5, r6)
            androidx.recyclerview.widget.GridLayoutManager$c r6 = r9.O
            int r10 = r10.b()
            int r10 = r10 - r3
            int r8 = r9.J
            int r10 = r6.b(r10, r8)
            int r10 = r10 + r3
            boolean r6 = r9.f1035x
            if (r6 == 0) goto L62
            int r10 = r10 - r5
            int r10 = r10 - r3
            int r10 = java.lang.Math.max(r1, r10)
            goto L66
        L62:
            int r10 = java.lang.Math.max(r1, r7)
        L66:
            if (r0 != 0) goto L69
            return r10
        L69:
            androidx.recyclerview.widget.q r0 = r9.f1032u
            int r0 = r0.d(r4)
            androidx.recyclerview.widget.q r1 = r9.f1032u
            int r1 = r1.g(r2)
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r9.O
            int r5 = r9.i0(r2)
            int r6 = r9.J
            int r1 = r1.b(r5, r6)
            androidx.recyclerview.widget.GridLayoutManager$c r5 = r9.O
            int r4 = r9.i0(r4)
            int r6 = r9.J
            int r4 = r5.b(r4, r6)
            int r4 = r4 - r1
            int r4 = r4 + r3
            float r0 = (float) r0
            float r1 = (float) r4
            float r0 = r0 / r1
            float r10 = (float) r10
            float r10 = r10 * r0
            androidx.recyclerview.widget.q r0 = r9.f1032u
            int r0 = r0.m()
            androidx.recyclerview.widget.q r1 = r9.f1032u
            int r1 = r1.g(r2)
            int r0 = r0 - r1
            float r0 = (float) r0
            float r10 = r10 + r0
            int r10 = java.lang.Math.round(r10)
            return r10
        Lae:
            return r1
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(androidx.recyclerview.widget.RecyclerView r1) {
            r0 = this;
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.h()
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.g()
            return
    }

    public final int T2(androidx.recyclerview.widget.RecyclerView.a0 r7) {
            r6 = this;
            int r0 = r6.K()
            r1 = 0
            if (r0 == 0) goto L7b
            int r0 = r7.b()
            if (r0 != 0) goto Le
            goto L7b
        Le:
            r6.U1()
            boolean r0 = r6.q2()
            r2 = 1
            r0 = r0 ^ r2
            android.view.View r0 = r6.Z1(r0, r2)
            boolean r3 = r6.q2()
            r3 = r3 ^ r2
            android.view.View r3 = r6.Y1(r3, r2)
            if (r0 == 0) goto L7b
            if (r3 != 0) goto L29
            goto L7b
        L29:
            boolean r1 = r6.q2()
            if (r1 != 0) goto L3e
            androidx.recyclerview.widget.GridLayoutManager$c r0 = r6.O
            int r7 = r7.b()
            int r7 = r7 - r2
            int r1 = r6.J
            int r7 = r0.b(r7, r1)
            int r7 = r7 + r2
            return r7
        L3e:
            androidx.recyclerview.widget.q r1 = r6.f1032u
            int r1 = r1.d(r3)
            androidx.recyclerview.widget.q r4 = r6.f1032u
            int r4 = r4.g(r0)
            int r1 = r1 - r4
            androidx.recyclerview.widget.GridLayoutManager$c r4 = r6.O
            int r0 = r6.i0(r0)
            int r5 = r6.J
            int r0 = r4.b(r0, r5)
            androidx.recyclerview.widget.GridLayoutManager$c r4 = r6.O
            int r3 = r6.i0(r3)
            int r5 = r6.J
            int r3 = r4.b(r3, r5)
            androidx.recyclerview.widget.GridLayoutManager$c r4 = r6.O
            int r7 = r7.b()
            int r7 = r7 - r2
            int r5 = r6.J
            int r7 = r4.b(r7, r5)
            int r7 = r7 + r2
            int r3 = r3 - r0
            int r3 = r3 + r2
            float r0 = (float) r1
            float r1 = (float) r3
            float r0 = r0 / r1
            float r7 = (float) r7
            float r0 = r0 * r7
            int r7 = (int) r0
            return r7
        L7b:
            return r1
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(androidx.recyclerview.widget.RecyclerView r1, int r2, int r3, int r4) {
            r0 = this;
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.h()
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.g()
            return
    }

    public final void U2(androidx.recyclerview.widget.RecyclerView.v r5, androidx.recyclerview.widget.RecyclerView.a0 r6, androidx.recyclerview.widget.LinearLayoutManager.a r7, int r8) {
            r4 = this;
            r0 = 1
            if (r8 != r0) goto L5
            r8 = 1
            goto L6
        L5:
            r8 = 0
        L6:
            int r1 = r7.f1042b
            int r1 = r4.Z2(r5, r6, r1)
            if (r8 == 0) goto L1e
        Le:
            if (r1 <= 0) goto L1d
            int r8 = r7.f1042b
            if (r8 <= 0) goto L1d
            int r8 = r8 + (-1)
            r7.f1042b = r8
            int r1 = r4.Z2(r5, r6, r8)
            goto Le
        L1d:
            return
        L1e:
            int r8 = r6.b()
            int r8 = r8 - r0
            int r0 = r7.f1042b
        L25:
            if (r0 >= r8) goto L32
            int r2 = r0 + 1
            int r3 = r4.Z2(r5, r6, r2)
            if (r3 <= r1) goto L32
            r0 = r2
            r1 = r3
            goto L25
        L32:
            r7.f1042b = r0
            return
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(androidx.recyclerview.widget.RecyclerView r1, int r2, int r3) {
            r0 = this;
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.h()
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.g()
            return
    }

    public final void V2() {
            r2 = this;
            android.view.View[] r0 = r2.L
            if (r0 == 0) goto Lb
            int r0 = r0.length
            int r1 = r2.J
            if (r0 == r1) goto La
            goto Lb
        La:
            return
        Lb:
            int r0 = r2.J
            android.view.View[] r0 = new android.view.View[r0]
            r2.L = r0
            return
    }

    public int W2(int r4, int r5) {
            r3 = this;
            int r0 = r3.f1030s
            r1 = 1
            if (r0 != r1) goto L19
            boolean r0 = r3.p2()
            if (r0 == 0) goto L19
            int[] r0 = r3.K
            int r1 = r3.J
            int r2 = r1 - r4
            r2 = r0[r2]
            int r1 = r1 - r4
            int r1 = r1 - r5
            r4 = r0[r1]
            int r2 = r2 - r4
            return r2
        L19:
            int[] r0 = r3.K
            int r5 = r5 + r4
            r5 = r0[r5]
            r4 = r0[r4]
            int r5 = r5 - r4
            return r5
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(androidx.recyclerview.widget.RecyclerView r1, int r2, int r3, java.lang.Object r4) {
            r0 = this;
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.h()
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            r1.g()
            return
    }

    public int X2() {
            r1 = this;
            int r0 = r1.J
            return r0
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3) {
            r1 = this;
            boolean r0 = r3.e()
            if (r0 == 0) goto L9
            r1.O2()
        L9:
            super.Y0(r2, r3)
            r1.R2()
            return
    }

    public final int Y2(androidx.recyclerview.widget.RecyclerView.v r1, androidx.recyclerview.widget.RecyclerView.a0 r2, int r3) {
            r0 = this;
            boolean r2 = r2.e()
            if (r2 != 0) goto Lf
            androidx.recyclerview.widget.GridLayoutManager$c r1 = r0.O
            int r2 = r0.J
            int r1 = r1.b(r3, r2)
            return r1
        Lf:
            int r1 = r1.f(r3)
            r2 = -1
            if (r1 != r2) goto L2e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot find span size for pre layout position. "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "GridLayoutManager"
            android.util.Log.w(r2, r1)
            r1 = 0
            return r1
        L2e:
            androidx.recyclerview.widget.GridLayoutManager$c r2 = r0.O
            int r3 = r0.J
            int r1 = r2.b(r1, r3)
            return r1
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Z0(androidx.recyclerview.widget.RecyclerView.a0 r1) {
            r0 = this;
            super.Z0(r1)
            r1 = 0
            r0.I = r1
            return
    }

    public final int Z2(androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3, int r4) {
            r1 = this;
            boolean r3 = r3.e()
            if (r3 != 0) goto Lf
            androidx.recyclerview.widget.GridLayoutManager$c r2 = r1.O
            int r3 = r1.J
            int r2 = r2.c(r4, r3)
            return r2
        Lf:
            android.util.SparseIntArray r3 = r1.N
            r0 = -1
            int r3 = r3.get(r4, r0)
            if (r3 == r0) goto L19
            return r3
        L19:
            int r2 = r2.f(r4)
            if (r2 != r0) goto L37
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "GridLayoutManager"
            android.util.Log.w(r3, r2)
            r2 = 0
            return r2
        L37:
            androidx.recyclerview.widget.GridLayoutManager$c r3 = r1.O
            int r4 = r1.J
            int r2 = r3.c(r2, r4)
            return r2
    }

    public final int a3(androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3, int r4) {
            r1 = this;
            boolean r3 = r3.e()
            if (r3 != 0) goto Ld
            androidx.recyclerview.widget.GridLayoutManager$c r2 = r1.O
            int r2 = r2.f(r4)
            return r2
        Ld:
            android.util.SparseIntArray r3 = r1.M
            r0 = -1
            int r3 = r3.get(r4, r0)
            if (r3 == r0) goto L17
            return r3
        L17:
            int r2 = r2.f(r4)
            if (r2 != r0) goto L35
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "GridLayoutManager"
            android.util.Log.w(r3, r2)
            r2 = 1
            return r2
        L35:
            androidx.recyclerview.widget.GridLayoutManager$c r3 = r1.O
            int r2 = r3.f(r2)
            return r2
    }

    public final void b3(float r2, int r3) {
            r1 = this;
            int r0 = r1.J
            float r0 = (float) r0
            float r2 = r2 * r0
            int r2 = java.lang.Math.round(r2)
            int r2 = java.lang.Math.max(r2, r3)
            r1.P2(r2)
            return
    }

    public final void c3(android.view.View r9, int r10, boolean r11) {
            r8 = this;
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r0 = (androidx.recyclerview.widget.GridLayoutManager.b) r0
            android.graphics.Rect r1 = r0.f1196b
            int r2 = r1.top
            int r3 = r1.bottom
            int r2 = r2 + r3
            int r3 = r0.topMargin
            int r2 = r2 + r3
            int r3 = r0.bottomMargin
            int r2 = r2 + r3
            int r3 = r1.left
            int r1 = r1.right
            int r3 = r3 + r1
            int r1 = r0.leftMargin
            int r3 = r3 + r1
            int r1 = r0.rightMargin
            int r3 = r3 + r1
            int r1 = r0.f1024e
            int r4 = r0.f1025f
            int r1 = r8.W2(r1, r4)
            int r4 = r8.f1030s
            r5 = 0
            r6 = 1
            if (r4 != r6) goto L43
            int r4 = r0.width
            int r10 = androidx.recyclerview.widget.RecyclerView.o.L(r1, r10, r3, r4, r5)
            androidx.recyclerview.widget.q r1 = r8.f1032u
            int r1 = r1.n()
            int r3 = r8.Y()
            int r0 = r0.height
            int r0 = androidx.recyclerview.widget.RecyclerView.o.L(r1, r3, r2, r0, r6)
            goto L5c
        L43:
            int r4 = r0.height
            int r10 = androidx.recyclerview.widget.RecyclerView.o.L(r1, r10, r2, r4, r5)
            androidx.recyclerview.widget.q r1 = r8.f1032u
            int r1 = r1.n()
            int r2 = r8.q0()
            int r0 = r0.width
            int r0 = androidx.recyclerview.widget.RecyclerView.o.L(r1, r2, r3, r0, r6)
            r7 = r0
            r0 = r10
            r10 = r7
        L5c:
            r8.d3(r9, r10, r0, r11)
            return
    }

    public final void d3(android.view.View r2, int r3, int r4, boolean r5) {
            r1 = this;
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$p r0 = (androidx.recyclerview.widget.RecyclerView.p) r0
            if (r5 == 0) goto Ld
            boolean r5 = r1.I1(r2, r3, r4, r0)
            goto L11
        Ld:
            boolean r5 = r1.G1(r2, r3, r4, r0)
        L11:
            if (r5 == 0) goto L16
            r2.measure(r3, r4)
        L16:
            return
    }

    public void e3(int r4) {
            r3 = this;
            int r0 = r3.J
            if (r4 != r0) goto L5
            return
        L5:
            r0 = 1
            r3.I = r0
            if (r4 < r0) goto L15
            r3.J = r4
            androidx.recyclerview.widget.GridLayoutManager$c r4 = r3.O
            r4.h()
            r3.u1()
            return
        L15:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Span count should be at least 1. Provided "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
    }

    public void f3(androidx.recyclerview.widget.GridLayoutManager.c r1) {
            r0 = this;
            r0.O = r1
            return
    }

    public final void g3() {
            r2 = this;
            int r0 = r2.o2()
            r1 = 1
            if (r0 != r1) goto L16
            int r0 = r2.p0()
            int r1 = r2.g0()
            int r0 = r0 - r1
            int r1 = r2.f0()
        L14:
            int r0 = r0 - r1
            goto L24
        L16:
            int r0 = r2.X()
            int r1 = r2.e0()
            int r0 = r0 - r1
            int r1 = r2.h0()
            goto L14
        L24:
            r2.P2(r0)
            return
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public android.view.View i2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11, boolean r12) {
            r8 = this;
            int r11 = r8.K()
            r0 = 1
            if (r12 == 0) goto Lf
            int r11 = r8.K()
            int r11 = r11 - r0
            r12 = -1
            r0 = -1
            goto L12
        Lf:
            r12 = 0
            r12 = r11
            r11 = 0
        L12:
            int r1 = r10.b()
            r8.U1()
            androidx.recyclerview.widget.q r2 = r8.f1032u
            int r2 = r2.m()
            androidx.recyclerview.widget.q r3 = r8.f1032u
            int r3 = r3.i()
            r4 = 0
            r5 = r4
        L27:
            if (r11 == r12) goto L63
            android.view.View r6 = r8.J(r11)
            int r7 = r8.i0(r6)
            if (r7 < 0) goto L61
            if (r7 >= r1) goto L61
            int r7 = r8.Z2(r9, r10, r7)
            if (r7 == 0) goto L3c
            goto L61
        L3c:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$p r7 = (androidx.recyclerview.widget.RecyclerView.p) r7
            boolean r7 = r7.c()
            if (r7 == 0) goto L4c
            if (r5 != 0) goto L61
            r5 = r6
            goto L61
        L4c:
            androidx.recyclerview.widget.q r7 = r8.f1032u
            int r7 = r7.g(r6)
            if (r7 >= r3) goto L5e
            androidx.recyclerview.widget.q r7 = r8.f1032u
            int r7 = r7.d(r6)
            if (r7 >= r2) goto L5d
            goto L5e
        L5d:
            return r6
        L5e:
            if (r4 != 0) goto L61
            r4 = r6
        L61:
            int r11 = r11 + r0
            goto L27
        L63:
            if (r4 == 0) goto L66
            return r4
        L66:
            return r5
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l0(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.RecyclerView.a0 r4) {
            r2 = this;
            int r0 = r2.f1030s
            if (r0 != 0) goto L7
            int r3 = r2.J
            return r3
        L7:
            int r0 = r4.b()
            r1 = 1
            if (r0 >= r1) goto L10
            r3 = 0
            return r3
        L10:
            int r0 = r4.b()
            int r0 = r0 - r1
            int r3 = r2.Y2(r3, r4, r0)
            int r3 = r3 + r1
            return r3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n(androidx.recyclerview.widget.RecyclerView.p r1) {
            r0 = this;
            boolean r1 = r1 instanceof androidx.recyclerview.widget.GridLayoutManager.b
            return r1
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void r2(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.a0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r6 = r21
            androidx.recyclerview.widget.q r4 = r0.f1032u
            int r4 = r4.l()
            r7 = 1
            r5 = 0
            r8 = 1073741824(0x40000000, float:2.0)
            if (r4 == r8) goto L18
            r9 = 1
            goto L19
        L18:
            r9 = 0
        L19:
            int r10 = r0.K()
            if (r10 <= 0) goto L26
            int[] r10 = r0.K
            int r11 = r0.J
            r10 = r10[r11]
            goto L27
        L26:
            r10 = 0
        L27:
            if (r9 == 0) goto L2c
            r0.g3()
        L2c:
            int r11 = r3.f1054e
            if (r11 != r7) goto L32
            r11 = 1
            goto L33
        L32:
            r11 = 0
        L33:
            int r12 = r0.J
            if (r11 != 0) goto L44
            int r12 = r3.f1053d
            int r12 = r0.Z2(r1, r2, r12)
            int r13 = r3.f1053d
            int r13 = r0.a3(r1, r2, r13)
            int r12 = r12 + r13
        L44:
            r13 = 0
        L45:
            int r14 = r0.J
            if (r13 >= r14) goto L9d
            boolean r14 = r3.c(r2)
            if (r14 == 0) goto L9d
            if (r12 <= 0) goto L9d
            int r14 = r3.f1053d
            int r15 = r0.a3(r1, r2, r14)
            int r8 = r0.J
            if (r15 > r8) goto L6f
            int r12 = r12 - r15
            if (r12 >= 0) goto L5f
            goto L9d
        L5f:
            android.view.View r8 = r3.d(r1)
            if (r8 != 0) goto L66
            goto L9d
        L66:
            android.view.View[] r14 = r0.L
            r14[r13] = r8
            int r13 = r13 + 1
            r8 = 1073741824(0x40000000, float:2.0)
            goto L45
        L6f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Item at position "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = " requires "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r3 = " spans but GridLayoutManager has only "
            r2.append(r3)
            int r3 = r0.J
            r2.append(r3)
            java.lang.String r3 = " spans."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9d:
            if (r13 != 0) goto La2
            r6.f1047b = r7
            return
        La2:
            r0.N2(r1, r2, r13, r11)
            r1 = 0
            r2 = 0
            r8 = 0
        La8:
            if (r2 >= r13) goto Lf3
            android.view.View[] r12 = r0.L
            r12 = r12[r2]
            java.util.List r14 = r3.f1061l
            if (r14 != 0) goto Lbc
            if (r11 == 0) goto Lb8
            r0.e(r12)
            goto Lc5
        Lb8:
            r0.f(r12, r5)
            goto Lc5
        Lbc:
            if (r11 == 0) goto Lc2
            r0.c(r12)
            goto Lc5
        Lc2:
            r0.d(r12, r5)
        Lc5:
            android.graphics.Rect r14 = r0.P
            r0.k(r12, r14)
            r0.c3(r12, r4, r5)
            androidx.recyclerview.widget.q r14 = r0.f1032u
            int r14 = r14.e(r12)
            if (r14 <= r8) goto Ld6
            r8 = r14
        Ld6:
            android.view.ViewGroup$LayoutParams r14 = r12.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r14 = (androidx.recyclerview.widget.GridLayoutManager.b) r14
            androidx.recyclerview.widget.q r15 = r0.f1032u
            int r12 = r15.f(r12)
            float r12 = (float) r12
            r15 = 1065353216(0x3f800000, float:1.0)
            float r12 = r12 * r15
            int r14 = r14.f1025f
            float r14 = (float) r14
            float r12 = r12 / r14
            int r14 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r14 <= 0) goto Lf0
            r1 = r12
        Lf0:
            int r2 = r2 + 1
            goto La8
        Lf3:
            if (r9 == 0) goto L111
            r0.b3(r1, r10)
            r1 = 0
            r8 = 0
        Lfa:
            if (r1 >= r13) goto L111
            android.view.View[] r2 = r0.L
            r2 = r2[r1]
            r4 = 1073741824(0x40000000, float:2.0)
            r0.c3(r2, r4, r7)
            androidx.recyclerview.widget.q r4 = r0.f1032u
            int r2 = r4.e(r2)
            if (r2 <= r8) goto L10e
            r8 = r2
        L10e:
            int r1 = r1 + 1
            goto Lfa
        L111:
            r1 = 0
        L112:
            if (r1 >= r13) goto L171
            android.view.View[] r2 = r0.L
            r2 = r2[r1]
            androidx.recyclerview.widget.q r4 = r0.f1032u
            int r4 = r4.e(r2)
            if (r4 == r8) goto L16c
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r4 = (androidx.recyclerview.widget.GridLayoutManager.b) r4
            android.graphics.Rect r9 = r4.f1196b
            int r10 = r9.top
            int r11 = r9.bottom
            int r10 = r10 + r11
            int r11 = r4.topMargin
            int r10 = r10 + r11
            int r11 = r4.bottomMargin
            int r10 = r10 + r11
            int r11 = r9.left
            int r9 = r9.right
            int r11 = r11 + r9
            int r9 = r4.leftMargin
            int r11 = r11 + r9
            int r9 = r4.rightMargin
            int r11 = r11 + r9
            int r9 = r4.f1024e
            int r12 = r4.f1025f
            int r9 = r0.W2(r9, r12)
            int r12 = r0.f1030s
            if (r12 != r7) goto L159
            int r4 = r4.width
            r12 = 1073741824(0x40000000, float:2.0)
            int r4 = androidx.recyclerview.widget.RecyclerView.o.L(r9, r12, r11, r4, r5)
            int r9 = r8 - r10
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12)
            goto L168
        L159:
            r12 = 1073741824(0x40000000, float:2.0)
            int r11 = r8 - r11
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r12)
            int r4 = r4.height
            int r9 = androidx.recyclerview.widget.RecyclerView.o.L(r9, r12, r10, r4, r5)
            r4 = r11
        L168:
            r0.d3(r2, r4, r9, r7)
            goto L16e
        L16c:
            r12 = 1073741824(0x40000000, float:2.0)
        L16e:
            int r1 = r1 + 1
            goto L112
        L171:
            r6.f1046a = r8
            int r1 = r0.f1030s
            r2 = -1
            if (r1 != r7) goto L189
            int r1 = r3.f1055f
            if (r1 != r2) goto L184
            int r1 = r3.f1051b
            int r2 = r1 - r8
        L180:
            r4 = r2
            r2 = 0
            r3 = 0
            goto L19b
        L184:
            int r2 = r3.f1051b
            int r1 = r2 + r8
            goto L180
        L189:
            int r1 = r3.f1055f
            if (r1 != r2) goto L196
            int r1 = r3.f1051b
            int r2 = r1 - r8
        L191:
            r3 = r2
            r4 = 0
            r2 = r1
            r1 = 0
            goto L19b
        L196:
            int r2 = r3.f1051b
            int r1 = r2 + r8
            goto L191
        L19b:
            r8 = 0
        L19c:
            if (r8 >= r13) goto L223
            android.view.View[] r5 = r0.L
            r5 = r5[r8]
            android.view.ViewGroup$LayoutParams r9 = r5.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r10 = r0.f1030s
            if (r10 != r7) goto L1e7
            boolean r2 = r0.p2()
            if (r2 == 0) goto L1d4
            int r2 = r0.f0()
            int[] r3 = r0.K
            int r10 = r0.J
            int r11 = r9.f1024e
            int r10 = r10 - r11
            r3 = r3[r10]
            int r2 = r2 + r3
            androidx.recyclerview.widget.q r3 = r0.f1032u
            int r3 = r3.f(r5)
            int r3 = r2 - r3
        L1c8:
            r16 = r5
            r5 = r1
            r1 = r16
            r16 = r4
            r4 = r2
            r2 = r3
            r3 = r16
            goto L1fa
        L1d4:
            int r2 = r0.f0()
            int[] r3 = r0.K
            int r10 = r9.f1024e
            r3 = r3[r10]
            int r3 = r3 + r2
            androidx.recyclerview.widget.q r2 = r0.f1032u
            int r2 = r2.f(r5)
            int r2 = r2 + r3
            goto L1c8
        L1e7:
            int r1 = r0.h0()
            int[] r4 = r0.K
            int r10 = r9.f1024e
            r4 = r4[r10]
            int r4 = r4 + r1
            androidx.recyclerview.widget.q r1 = r0.f1032u
            int r1 = r1.f(r5)
            int r1 = r1 + r4
            goto L1c8
        L1fa:
            r0.A0(r1, r2, r3, r4, r5)
            r16 = r5
            r5 = r1
            r1 = r16
            r16 = r3
            r3 = r2
            r2 = r4
            r4 = r16
            boolean r10 = r9.c()
            if (r10 != 0) goto L214
            boolean r9 = r9.b()
            if (r9 == 0) goto L216
        L214:
            r6.f1048c = r7
        L216:
            boolean r9 = r6.f1049d
            boolean r5 = r5.hasFocusable()
            r5 = r5 | r9
            r6.f1049d = r5
            int r8 = r8 + 1
            goto L19c
        L223:
            android.view.View[] r1 = r0.L
            r2 = 0
            java.util.Arrays.fill(r1, r2)
            return
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(androidx.recyclerview.widget.RecyclerView.a0 r2) {
            r1 = this;
            boolean r0 = r1.Q
            if (r0 == 0) goto L9
            int r2 = r1.S2(r2)
            return r2
        L9:
            int r2 = super.s(r2)
            return r2
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int t(androidx.recyclerview.widget.RecyclerView.a0 r2) {
            r1 = this;
            boolean r0 = r1.Q
            if (r0 == 0) goto L9
            int r2 = r1.T2(r2)
            return r2
        L9:
            int r2 = super.t(r2)
            return r2
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void t2(androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3, androidx.recyclerview.widget.LinearLayoutManager.a r4, int r5) {
            r1 = this;
            super.t2(r2, r3, r4, r5)
            r1.g3()
            int r0 = r3.b()
            if (r0 <= 0) goto L15
            boolean r0 = r3.e()
            if (r0 != 0) goto L15
            r1.U2(r2, r3, r4, r5)
        L15:
            r1.V2()
            return
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(androidx.recyclerview.widget.RecyclerView.a0 r2) {
            r1 = this;
            boolean r0 = r1.Q
            if (r0 == 0) goto L9
            int r2 = r1.S2(r2)
            return r2
        L9:
            int r2 = super.v(r2)
            return r2
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w(androidx.recyclerview.widget.RecyclerView.a0 r2) {
            r1 = this;
            boolean r0 = r1.Q
            if (r0 == 0) goto L9
            int r2 = r1.T2(r2)
            return r2
        L9:
            int r2 = super.w(r2)
            return r2
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int x1(int r1, androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3) {
            r0 = this;
            r0.g3()
            r0.V2()
            int r1 = super.x1(r1, r2, r3)
            return r1
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int z1(int r1, androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3) {
            r0 = this;
            r0.g3()
            r0.V2()
            int r1 = super.z1(r1, r2, r3)
            return r1
    }
}
