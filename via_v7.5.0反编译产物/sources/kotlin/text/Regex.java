package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }

            public a() {
            }
        }

        public Serialized(String pattern, int i10) {
            kotlin.jvm.internal.h.f(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.h.e(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final int b(int i10) {
            return (i10 & 2) != 0 ? i10 | 64 : i10;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements p7.l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f7325c;

        public b(int i10) {
            this.f7325c = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p7.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Enum r10) {
            e eVar = (e) r10;
            return Boolean.valueOf((this.f7325c & eVar.getMask()) == eVar.getValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p7.l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, i.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // p7.l
        public final i invoke(i p10) {
            kotlin.jvm.internal.h.f(p10, "p0");
            return p10.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    @i7.c(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", l = {279, 287, 291}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements p7.p {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CharSequence charSequence, int i10, h7.a aVar) {
            super(2, aVar);
            this.$input = charSequence;
            this.$limit = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final h7.a create(Object obj, h7.a aVar) {
            AnonymousClass1 anonymousClass1 = Regex.this.new AnonymousClass1(this.$input, this.$limit, aVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0071 A[PHI: r1 r6 r10
  0x0071: PHI (r1v8 int) = (r1v7 int), (r1v12 int) binds: [B:19:0x006e, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
  0x0071: PHI (r6v2 u7.h) = (r6v1 u7.h), (r6v4 u7.h) binds: [B:19:0x006e, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
  0x0071: PHI (r10v7 java.util.regex.Matcher) = (r10v6 java.util.regex.Matcher), (r10v13 java.util.regex.Matcher) binds: [B:19:0x006e, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:23:0x007b  */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x009a, code lost:
        
            if (r6.a(r10, r9) == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
        
            if (r10.a(r1, r9) == r0) goto L32;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.b()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2d
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.b.b(r10)
                goto L9d
            L16:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1e:
                int r1 = r9.I$0
                java.lang.Object r5 = r9.L$1
                java.util.regex.Matcher r5 = (java.util.regex.Matcher) r5
                java.lang.Object r6 = r9.L$0
                u7.h r6 = (u7.h) r6
                kotlin.b.b(r10)
                r10 = r5
                goto L71
            L2d:
                kotlin.b.b(r10)
                goto Laf
            L32:
                kotlin.b.b(r10)
                java.lang.Object r10 = r9.L$0
                u7.h r10 = (u7.h) r10
                kotlin.text.Regex r1 = kotlin.text.Regex.this
                java.util.regex.Pattern r1 = kotlin.text.Regex.access$getNativePattern$p(r1)
                java.lang.CharSequence r5 = r9.$input
                java.util.regex.Matcher r1 = r1.matcher(r5)
                int r5 = r9.$limit
                if (r5 == r4) goto La0
                boolean r5 = r1.find()
                if (r5 != 0) goto L50
                goto La0
            L50:
                r5 = 0
                r6 = r10
                r10 = r1
                r1 = 0
            L54:
                java.lang.CharSequence r7 = r9.$input
                int r8 = r10.start()
                java.lang.CharSequence r5 = r7.subSequence(r5, r8)
                java.lang.String r5 = r5.toString()
                r9.L$0 = r6
                r9.L$1 = r10
                r9.I$0 = r1
                r9.label = r3
                java.lang.Object r5 = r6.a(r5, r9)
                if (r5 != r0) goto L71
                goto Lae
            L71:
                int r5 = r10.end()
                int r1 = r1 + r4
                int r7 = r9.$limit
                int r7 = r7 - r4
                if (r1 == r7) goto L81
                boolean r7 = r10.find()
                if (r7 != 0) goto L54
            L81:
                java.lang.CharSequence r10 = r9.$input
                int r1 = r10.length()
                java.lang.CharSequence r10 = r10.subSequence(r5, r1)
                java.lang.String r10 = r10.toString()
                r1 = 0
                r9.L$0 = r1
                r9.L$1 = r1
                r9.label = r2
                java.lang.Object r10 = r6.a(r10, r9)
                if (r10 != r0) goto L9d
                goto Lae
            L9d:
                d7.h r10 = d7.h.f3935a
                return r10
            La0:
                java.lang.CharSequence r1 = r9.$input
                java.lang.String r1 = r1.toString()
                r9.label = r4
                java.lang.Object r10 = r10.a(r1, r9)
                if (r10 != r0) goto Laf
            Lae:
                return r0
            Laf:
                d7.h r10 = d7.h.f3935a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // p7.p
        public final Object invoke(u7.h hVar, h7.a aVar) {
            return ((AnonymousClass1) create(hVar, aVar)).invokeSuspend(d7.h.f3935a);
        }
    }

    public Regex(Pattern nativePattern) {
        kotlin.jvm.internal.h.f(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static final i b(Regex regex, CharSequence charSequence, int i10) {
        return regex.find(charSequence, i10);
    }

    public static /* synthetic */ i find$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.find(charSequence, i10);
    }

    public static /* synthetic */ u7.f findAll$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.findAll(charSequence, i10);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.split(charSequence, i10);
    }

    public static /* synthetic */ u7.f splitToSequence$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.splitToSequence(charSequence, i10);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.h.e(strPattern, "pattern(...)");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        kotlin.jvm.internal.h.f(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final i find(CharSequence input, int i10) {
        kotlin.jvm.internal.h.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.h.e(matcher, "matcher(...)");
        return m.f(matcher, i10, input);
    }

    public final u7.f findAll(final CharSequence input, final int i10) {
        kotlin.jvm.internal.h.f(input, "input");
        if (i10 >= 0 && i10 <= input.length()) {
            return u7.k.f(new p7.a() { // from class: kotlin.text.l
                @Override // p7.a
                public final Object invoke() {
                    return Regex.b(this.f7360c, input, i10);
                }
            }, AnonymousClass2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i10 + ", input length: " + input.length());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(RegexOption.class);
        kotlin.jvm.internal.h.c(enumSetAllOf);
        e7.t.t(enumSetAllOf, new b(iFlags));
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        kotlin.jvm.internal.h.e(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.h.e(strPattern, "pattern(...)");
        return strPattern;
    }

    public final i matchAt(CharSequence input, int i10) {
        kotlin.jvm.internal.h.f(input, "input");
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        kotlin.jvm.internal.h.c(matcherRegion);
        return new j(matcherRegion, input);
    }

    public final i matchEntire(CharSequence input) {
        kotlin.jvm.internal.h.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.h.e(matcher, "matcher(...)");
        return m.g(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        kotlin.jvm.internal.h.f(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(CharSequence input, int i10) {
        kotlin.jvm.internal.h.f(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        kotlin.jvm.internal.h.f(input, "input");
        kotlin.jvm.internal.h.f(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.h.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        kotlin.jvm.internal.h.f(input, "input");
        kotlin.jvm.internal.h.f(replacement, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.h.e(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public final List<String> split(CharSequence input, int i10) {
        kotlin.jvm.internal.h.f(input, "input");
        z.k0(i10);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i10 == 1 || !matcher.find()) {
            return e7.n.e(input.toString());
        }
        ArrayList arrayList = new ArrayList(i10 > 0 ? s7.e.b(i10, 10) : 10);
        int i11 = i10 - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i11 >= 0 && arrayList.size() == i11) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public final u7.f splitToSequence(CharSequence input, int i10) {
        kotlin.jvm.internal.h.f(input, "input");
        z.k0(i10);
        return u7.i.b(new AnonymousClass1(input, i10, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public final String replace(CharSequence input, p7.l transform) {
        kotlin.jvm.internal.h.f(input, "input");
        kotlin.jvm.internal.h.f(transform, "transform");
        int iIntValue = 0;
        i iVarFind$default = find$default(this, input, 0, 2, null);
        if (iVarFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(input, iIntValue, iVarFind$default.b().o().intValue());
            sb2.append((CharSequence) transform.invoke(iVarFind$default));
            iIntValue = iVarFind$default.b().n().intValue() + 1;
            iVarFind$default = iVarFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (iVarFind$default != null);
        if (iIntValue < length) {
            sb2.append(input, iIntValue, length);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern) {
        kotlin.jvm.internal.h.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.h.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, RegexOption option) {
        kotlin.jvm.internal.h.f(pattern, "pattern");
        kotlin.jvm.internal.h.f(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, Companion.b(option.getValue()));
        kotlin.jvm.internal.h.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, Set<? extends RegexOption> options) {
        kotlin.jvm.internal.h.f(pattern, "pattern");
        kotlin.jvm.internal.h.f(options, "options");
        Pattern patternCompile = Pattern.compile(pattern, Companion.b(m.j(options)));
        kotlin.jvm.internal.h.e(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
