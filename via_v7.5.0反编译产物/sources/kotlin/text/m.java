package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final i f(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    public static final i g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    public static final s7.c h(MatchResult matchResult) {
        return s7.e.e(matchResult.start(), matchResult.end());
    }

    public static final s7.c i(MatchResult matchResult, int i10) {
        return s7.e.e(matchResult.start(i10), matchResult.end(i10));
    }

    public static final int j(Iterable iterable) {
        Iterator it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= ((e) it.next()).getValue();
        }
        return value;
    }
}
