package io.reactivex.rxjava3.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public ExceptionOverview(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a {
        public abstract a a(Object obj);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        public final PrintStream f7204a;

        public b(PrintStream printStream) {
            this.f7204a = printStream;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Object obj) {
            this.f7204a.print(obj);
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public final PrintWriter f7205a;

        public c(PrintWriter printWriter) {
            this.f7205a = printWriter;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(Object obj) {
            this.f7205a.print(obj);
            return this;
        }
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
        this.exceptions = listUnmodifiableList;
        this.message = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public final void a(a aVar, Throwable th, String str) {
        aVar.a(str).a(th).a('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            aVar.a("\t\tat ").a(stackTraceElement).a('\n');
        }
        if (th.getCause() != null) {
            aVar.a("\tCaused by: ");
            a(aVar, th.getCause(), "");
        }
    }

    public final void b(a aVar) {
        aVar.a(this).a("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            aVar.a("\tat ").a(stackTraceElement).a("\n");
        }
        int i10 = 1;
        for (Throwable th : this.exceptions) {
            aVar.a("  ComposedException ").a(Integer.valueOf(i10)).a(" :\n");
            a(aVar, th, "\t");
            i10++;
        }
        aVar.a("\n");
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i10;
        try {
            if (this.cause == null) {
                String property = System.getProperty("line.separator");
                if (this.exceptions.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Multiple exceptions (");
                    sb2.append(this.exceptions.size());
                    sb2.append(")");
                    sb2.append(property);
                    for (Throwable cause : this.exceptions) {
                        int i11 = 0;
                        while (true) {
                            if (cause != null) {
                                for (int i12 = 0; i12 < i11; i12++) {
                                    sb2.append("  ");
                                }
                                sb2.append("|-- ");
                                sb2.append(cause.getClass().getCanonicalName());
                                sb2.append(": ");
                                String message = cause.getMessage();
                                if (message == null || !message.contains(property)) {
                                    sb2.append(message);
                                    sb2.append(property);
                                } else {
                                    sb2.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i13 = 0; i13 < i11 + 2; i13++) {
                                            sb2.append("  ");
                                        }
                                        sb2.append(str);
                                        sb2.append(property);
                                    }
                                }
                                int i14 = 0;
                                while (true) {
                                    i10 = i11 + 2;
                                    if (i14 >= i10) {
                                        break;
                                    }
                                    sb2.append("  ");
                                    i14++;
                                }
                                StackTraceElement[] stackTrace = cause.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb2.append("at ");
                                    sb2.append(stackTrace[0]);
                                    sb2.append(property);
                                }
                                if (identityHashMap.containsKey(cause)) {
                                    Throwable cause2 = cause.getCause();
                                    if (cause2 != null) {
                                        for (int i15 = 0; i15 < i10; i15++) {
                                            sb2.append("  ");
                                        }
                                        sb2.append("|-- ");
                                        sb2.append("(cause not expanded again) ");
                                        sb2.append(cause2.getClass().getCanonicalName());
                                        sb2.append(": ");
                                        sb2.append(cause2.getMessage());
                                        sb2.append(property);
                                    }
                                } else {
                                    identityHashMap.put(cause, Boolean.TRUE);
                                    cause = cause.getCause();
                                    i11++;
                                }
                            }
                        }
                    }
                    this.cause = new ExceptionOverview(sb2.toString().trim());
                } else {
                    this.cause = this.exceptions.get(0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        b(new b(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        b(new c(printWriter));
    }

    public int size() {
        return this.exceptions.size();
    }
}
