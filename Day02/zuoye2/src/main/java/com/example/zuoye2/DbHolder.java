package com.example.zuoye2;

import android.database.sqlite.SQLiteDatabase;
import android.widget.HorizontalScrollView;

import com.example.zuoye2.bean.Bean_Three;
import com.example.zuoye2.dao.Bean_ThreeDao;
import com.example.zuoye2.dao.DaoMaster;
import com.example.zuoye2.dao.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class DbHolder {
    private static DbHolder dbHolder;
    private final Bean_ThreeDao threeDao;

    DbHolder(){
         DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "s.db");
         DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
         DaoSession daoSession = daoMaster.newSession();
        threeDao = daoSession.getBean_ThreeDao();
    }

    public static DbHolder getDbHolder() {
        if (dbHolder==null){
            synchronized (DbHolder.class){
                if (dbHolder==null){
                  dbHolder=new DbHolder();
                }
            }
        }
        return dbHolder;
    }
    public void insert(Bean_Three beanThree){
        if (has(beanThree)){
          return;
        }else {
            threeDao.insertOrReplaceInTx(beanThree);
        }
    }

    public List<Bean_Three> query(){
         List<Bean_Three> list = threeDao.queryBuilder().list();
        return list;
    }

    public boolean has(Bean_Three beanThree){
         List<Bean_Three> list = threeDao.queryBuilder().where(Bean_ThreeDao.Properties.Author_name.eq(beanThree.getAuthor_name())).list();
        if (list!=null&&list.size()>0){
            return true;
        }else {
            return false;
        }
    }
}
