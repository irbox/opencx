package com.google.api.client.googleapis;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GoogleUtils
{
    public static final String a;
    public static final Integer b;
    public static final Integer c;
    public static final Integer d;
    static final Pattern e;
    
    static {
        final Matcher matcher = (e = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)(-SNAPSHOT)?")).matcher((CharSequence)(a = a()));
        matcher.find();
        b = Integer.parseInt(matcher.group(1));
        c = Integer.parseInt(matcher.group(2));
        d = Integer.parseInt(matcher.group(3));
    }
    
    private GoogleUtils() {
    }
    
    private static String a() {
        final String s = null;
        String s3;
        final String s2 = s3 = null;
        Label_0084: {
            InputStream resourceAsStream;
            try {
                resourceAsStream = GoogleUtils.class.getResourceAsStream("google-api-client.properties");
                if (resourceAsStream != null) {
                    try {
                        final Properties properties = new Properties();
                        properties.load(resourceAsStream);
                        properties.getProperty("google-api-client.version");
                    }
                    finally {
                        try {}
                        finally {
                            try {
                                resourceAsStream.close();
                            }
                            finally {
                                s3 = s2;
                                ((Throwable)s).addSuppressed((Throwable)resourceAsStream);
                            }
                            s3 = s2;
                        }
                    }
                }
            }
            catch (final IOException ex) {
                break Label_0084;
            }
            s3 = s;
            if (resourceAsStream != null) {
                resourceAsStream.close();
                s3 = s;
            }
        }
        String s4;
        if ((s4 = s3) == null) {
            s4 = "unknown-version";
        }
        return s4;
    }
}
