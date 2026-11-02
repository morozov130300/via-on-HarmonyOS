package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class Persister implements Serializer {
    private final Format format;
    private final SessionManager manager;
    private final Strategy strategy;
    private final Support support;

    public Persister() {
        this(new HashMap());
    }

    public Persister(Map map) {
        this(new PlatformFilter(map));
    }

    public Persister(Map map, Format format) {
        this(new PlatformFilter(map));
    }

    public Persister(Filter filter) {
        this(new TreeStrategy(), filter);
    }

    public Persister(Filter filter, Format format) {
        this(new TreeStrategy(), filter, format);
    }

    public Persister(Filter filter, Matcher matcher) {
        this(new TreeStrategy(), filter, matcher);
    }

    public Persister(Filter filter, Matcher matcher, Format format) {
        this(new TreeStrategy(), filter, matcher, format);
    }

    public Persister(Strategy strategy) {
        this(strategy, new HashMap());
    }

    public Persister(Strategy strategy, Map map) {
        this(strategy, new PlatformFilter(map));
    }

    public Persister(Strategy strategy, Map map, Format format) {
        this(strategy, new PlatformFilter(map), format);
    }

    public Persister(Strategy strategy, Filter filter) {
        this(strategy, filter, new Format());
    }

    public Persister(Strategy strategy, Filter filter, Format format) {
        this(strategy, filter, new EmptyMatcher(), format);
    }

    public Persister(Strategy strategy, Filter filter, Matcher matcher) {
        this(strategy, filter, matcher, new Format());
    }

    public Persister(Strategy strategy, Filter filter, Matcher matcher, Format format) {
        this.support = new Support(filter, matcher, format);
        this.manager = new SessionManager();
        this.strategy = strategy;
        this.format = format;
    }

    public Persister(Strategy strategy, Format format) {
        this(strategy, new HashMap(), format);
    }

    public Persister(Strategy strategy, Matcher matcher) {
        this(strategy, new PlatformFilter(), matcher);
    }

    public Persister(Strategy strategy, Matcher matcher, Format format) {
        this(strategy, new PlatformFilter(), matcher, format);
    }

    public Persister(Format format) {
        this(new TreeStrategy(), format);
    }

    public Persister(Matcher matcher) {
        this(new TreeStrategy(), matcher);
    }

    public Persister(Matcher matcher, Format format) {
        this(new TreeStrategy(), matcher, format);
    }

    private <T> T read(Class<? extends T> cls, InputNode inputNode, Context context) {
        return (T) new Traverser(context).read(inputNode, (Class) cls);
    }

    private <T> T read(Class<? extends T> cls, InputNode inputNode, Session session) {
        return (T) read((Class) cls, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private <T> T read(T t10, InputNode inputNode, Context context) {
        return (T) new Traverser(context).read(inputNode, t10);
    }

    private <T> T read(T t10, InputNode inputNode, Session session) {
        return (T) read((Persister) t10, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private boolean validate(Class cls, InputNode inputNode, Context context) {
        return new Traverser(context).validate(inputNode, cls);
    }

    private boolean validate(Class cls, InputNode inputNode, Session session) {
        return validate(cls, inputNode, new Source(this.strategy, this.support, session));
    }

    private void write(Object obj, OutputNode outputNode, Context context) {
        new Traverser(context).write(outputNode, obj);
    }

    private void write(Object obj, OutputNode outputNode, Session session) {
        write(obj, outputNode, new Source(this.strategy, this.support, session));
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, File file) {
        return (T) read((Class) cls, file, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, File file, boolean z10) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return (T) read((Class) cls, (InputStream) fileInputStream, z10);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputStream inputStream) {
        return (T) read((Class) cls, inputStream, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputStream inputStream, boolean z10) {
        return (T) read((Class) cls, NodeBuilder.read(inputStream), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, Reader reader) {
        return (T) read((Class) cls, reader, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, Reader reader, boolean z10) {
        return (T) read((Class) cls, NodeBuilder.read(reader), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, String str) {
        return (T) read((Class) cls, str, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, String str, boolean z10) {
        return (T) read((Class) cls, (Reader) new StringReader(str), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputNode inputNode) {
        return (T) read((Class) cls, inputNode, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputNode inputNode, boolean z10) throws PersistenceException {
        try {
            return (T) read((Class) cls, inputNode, this.manager.open(z10));
        } finally {
            this.manager.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, File file) {
        return (T) read((Persister) t10, file, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, File file, boolean z10) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return (T) read((Persister) t10, (InputStream) fileInputStream, z10);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, InputStream inputStream) {
        return (T) read((Persister) t10, inputStream, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, InputStream inputStream, boolean z10) {
        return (T) read((Persister) t10, NodeBuilder.read(inputStream), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, Reader reader) {
        return (T) read((Persister) t10, reader, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, Reader reader, boolean z10) {
        return (T) read((Persister) t10, NodeBuilder.read(reader), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, String str) {
        return (T) read((Persister) t10, str, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, String str, boolean z10) {
        return (T) read((Persister) t10, (Reader) new StringReader(str), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, InputNode inputNode) {
        return (T) read((Persister) t10, inputNode, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t10, InputNode inputNode, boolean z10) throws PersistenceException {
        try {
            return (T) read((Persister) t10, inputNode, this.manager.open(z10));
        } finally {
            this.manager.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, File file) {
        return validate(cls, file, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, File file, boolean z10) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return validate(cls, fileInputStream, z10);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputStream inputStream) {
        return validate(cls, inputStream, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputStream inputStream, boolean z10) {
        return validate(cls, NodeBuilder.read(inputStream), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, Reader reader) {
        return validate(cls, reader, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, Reader reader, boolean z10) {
        return validate(cls, NodeBuilder.read(reader), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, String str) {
        return validate(cls, str, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, String str, boolean z10) {
        return validate(cls, new StringReader(str), z10);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputNode inputNode) {
        return validate(cls, inputNode, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputNode inputNode, boolean z10) throws PersistenceException {
        try {
            return validate(cls, inputNode, this.manager.open(z10));
        } finally {
            this.manager.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(obj, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, OutputStream outputStream) throws PersistenceException {
        write(obj, outputStream, "utf-8");
    }

    public void write(Object obj, OutputStream outputStream, String str) throws PersistenceException {
        write(obj, new OutputStreamWriter(outputStream, str));
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, Writer writer) throws PersistenceException {
        write(obj, NodeBuilder.write(writer, this.format));
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, OutputNode outputNode) throws PersistenceException {
        try {
            write(obj, outputNode, this.manager.open());
        } finally {
            this.manager.close();
        }
    }
}
