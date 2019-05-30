package com.example.zuoye2.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.zuoye2.bean.Bean_Three;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BEAN__THREE".
*/
public class Bean_ThreeDao extends AbstractDao<Bean_Three, Long> {

    public static final String TABLENAME = "BEAN__THREE";

    /**
     * Properties of entity Bean_Three.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Category = new Property(1, String.class, "category", false, "CATEGORY");
        public final static Property Author_name = new Property(2, String.class, "author_name", false, "AUTHOR_NAME");
        public final static Property Thumbnail_pic_s02 = new Property(3, String.class, "thumbnail_pic_s02", false, "THUMBNAIL_PIC_S02");
    }


    public Bean_ThreeDao(DaoConfig config) {
        super(config);
    }
    
    public Bean_ThreeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BEAN__THREE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CATEGORY\" TEXT," + // 1: category
                "\"AUTHOR_NAME\" TEXT," + // 2: author_name
                "\"THUMBNAIL_PIC_S02\" TEXT);"); // 3: thumbnail_pic_s02
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BEAN__THREE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Bean_Three entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(2, category);
        }
 
        String author_name = entity.getAuthor_name();
        if (author_name != null) {
            stmt.bindString(3, author_name);
        }
 
        String thumbnail_pic_s02 = entity.getThumbnail_pic_s02();
        if (thumbnail_pic_s02 != null) {
            stmt.bindString(4, thumbnail_pic_s02);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Bean_Three entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(2, category);
        }
 
        String author_name = entity.getAuthor_name();
        if (author_name != null) {
            stmt.bindString(3, author_name);
        }
 
        String thumbnail_pic_s02 = entity.getThumbnail_pic_s02();
        if (thumbnail_pic_s02 != null) {
            stmt.bindString(4, thumbnail_pic_s02);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Bean_Three readEntity(Cursor cursor, int offset) {
        Bean_Three entity = new Bean_Three( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // category
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // author_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // thumbnail_pic_s02
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Bean_Three entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCategory(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAuthor_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setThumbnail_pic_s02(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Bean_Three entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Bean_Three entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Bean_Three entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
