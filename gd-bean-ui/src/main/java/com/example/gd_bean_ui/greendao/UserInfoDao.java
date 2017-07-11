package com.example.gd_bean_ui.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.gd_bean_ui.vo.UserInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_INFO".
*/
public class UserInfoDao extends AbstractDao<UserInfo, Long> {

    public static final String TABLENAME = "USER_INFO";

    /**
     * Properties of entity UserInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Username = new Property(1, String.class, "username", false, "USERNAME");
        public final static Property Usercode = new Property(2, Integer.class, "usercode", false, "USERCODE");
        public final static Property Password = new Property(3, String.class, "password", false, "PASSWORD");
        public final static Property Desc = new Property(4, String.class, "desc", false, "DESC");
        public final static Property Picurl = new Property(5, String.class, "picurl", false, "PICURL");
        public final static Property Update = new Property(6, String.class, "update", false, "UPDATE");
        public final static Property Create = new Property(7, String.class, "create", false, "CREATE");
        public final static Property Level = new Property(8, Integer.class, "level", false, "LEVEL");
    };


    public UserInfoDao(DaoConfig config) {
        super(config);
    }
    
    public UserInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USERNAME\" TEXT," + // 1: username
                "\"USERCODE\" INTEGER," + // 2: usercode
                "\"PASSWORD\" TEXT," + // 3: password
                "\"DESC\" TEXT," + // 4: desc
                "\"PICURL\" TEXT," + // 5: picurl
                "\"UPDATE\" TEXT," + // 6: update
                "\"CREATE\" TEXT," + // 7: create
                "\"LEVEL\" INTEGER);"); // 8: level
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(2, username);
        }
 
        Integer usercode = entity.getUsercode();
        if (usercode != null) {
            stmt.bindLong(3, usercode);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(5, desc);
        }
 
        String picurl = entity.getPicurl();
        if (picurl != null) {
            stmt.bindString(6, picurl);
        }
 
        String update = entity.getUpdate();
        if (update != null) {
            stmt.bindString(7, update);
        }
 
        String create = entity.getCreate();
        if (create != null) {
            stmt.bindString(8, create);
        }
 
        Integer level = entity.getLevel();
        if (level != null) {
            stmt.bindLong(9, level);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(2, username);
        }
 
        Integer usercode = entity.getUsercode();
        if (usercode != null) {
            stmt.bindLong(3, usercode);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(5, desc);
        }
 
        String picurl = entity.getPicurl();
        if (picurl != null) {
            stmt.bindString(6, picurl);
        }
 
        String update = entity.getUpdate();
        if (update != null) {
            stmt.bindString(7, update);
        }
 
        String create = entity.getCreate();
        if (create != null) {
            stmt.bindString(8, create);
        }
 
        Integer level = entity.getLevel();
        if (level != null) {
            stmt.bindLong(9, level);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UserInfo readEntity(Cursor cursor, int offset) {
        UserInfo entity = new UserInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // username
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // usercode
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // password
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // desc
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // picurl
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // update
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // create
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8) // level
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUsername(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUsercode(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setPassword(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDesc(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPicurl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUpdate(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCreate(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLevel(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
