package kotlin.text;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public enum RegexOption implements e {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ j7.a f7327e = kotlin.enums.a.a(a());
    private final int mask;
    private final int value;

    RegexOption(int i10, int i11) {
        this.value = i10;
        this.mask = i11;
    }

    public static j7.a getEntries() {
        return f7327e;
    }

    @Override // kotlin.text.e
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.e
    public int getValue() {
        return this.value;
    }

    /* synthetic */ RegexOption(int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(i10, (i12 & 2) != 0 ? i10 : i11);
    }
}
