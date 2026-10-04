package com.box.androidsdk.content.models;

import ax.O4.g;
import ax.O4.d;
import java.util.HashMap;

public class BoxEntity extends BoxJsonObject
{
    private static HashMap<String, n> q;
    private static final long serialVersionUID = 1626798809346520004L;
    
    static {
        BoxEntity.q = (HashMap<String, n>)new HashMap();
        C("collection", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxCollection();
            }
        });
        C("comment", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxComment();
            }
        });
        C("collaboration", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxCollaboration();
            }
        });
        C("enterprise", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxEnterprise();
            }
        });
        C("file_version", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxFileVersion();
            }
        });
        C("event", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxEvent();
            }
        });
        C("file", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxFile();
            }
        });
        C("folder", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxFolder();
            }
        });
        C("web_link", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxBookmark();
            }
        });
        C("user", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxUser();
            }
        });
        C("group", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxGroup();
            }
        });
        C("realtime_server", (n)new n() {
            @Override
            public BoxEntity a() {
                return new BoxRealTimeServer();
            }
        });
    }
    
    public BoxEntity() {
    }
    
    public BoxEntity(final d d) {
        super(d);
    }
    
    public static void C(final String s, final n n) {
        BoxEntity.q.put((Object)s, (Object)n);
    }
    
    public static BoxEntity D(final d d) {
        final g d2 = d.D("type");
        if (!d2.r()) {
            return null;
        }
        final n n = (n)BoxEntity.q.get((Object)d2.k());
        BoxEntity a;
        if (n == null) {
            a = new BoxEntity();
        }
        else {
            a = n.a();
        }
        a.i(d);
        return a;
    }
    
    public static b<BoxEntity> E() {
        return new b<BoxEntity>() {
            public BoxEntity b(final d d) {
                return BoxEntity.D(d);
            }
        };
    }
    
    public String G() {
        String s;
        if ((s = this.u("id")) == null) {
            s = this.u("item_id");
        }
        return s;
    }
    
    public interface n
    {
        BoxEntity a();
    }
}
