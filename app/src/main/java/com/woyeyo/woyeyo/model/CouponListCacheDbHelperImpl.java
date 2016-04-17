package com.woyeyo.woyeyo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.woyeyo.woyeyo.bean.Coupon;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengdazhi on 4/7/16.
 */
public class CouponListCacheDbHelperImpl extends SQLiteOpenHelper implements CouponListCacheDb{
    private OkHttpClient mOkHttpClient;
    /*
    private long couponId;
    private String couponImagePath;
    private String couponDesc;
    private String merchantName;
    private String merchantLogoUrl;
    private String merchantJumpUrl;
    private String couponJumpUrl;
    private String couponDetail;
    private String bargainRule;
    private String category;
     */
    private Context context;

    private static final String COUPON_TABLE_NAME = "CouponCache";

    private static final String CREATE_COUPON_TABLE = "create table " + COUPON_TABLE_NAME + " (" +
            "couponId integer primary key, " +
            "couponDesc text)";

    private static final String CLEAR_COUPON_TABLE = "delete from " + COUPON_TABLE_NAME + ";";

    public CouponListCacheDbHelperImpl(Context context, String name,
                                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        this.context = context.getApplicationContext();
        initOkHttpClient();
    }

    private void initOkHttpClient() {
        mOkHttpClient = new OkHttpClient();
        //cookie enabled
        mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COUPON_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    private boolean cacheCoupon(Coupon coupon) {
        Log.d("DbHelper", "cacheCoupon start");
        ContentValues values = new ContentValues();
        values.put("couponId", coupon.getCouponId());
        values.put("couponDesc", coupon.getCouponDesc());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(COUPON_TABLE_NAME, null, values);
        db.close();
        return true;
    }

    @Override
    public boolean cacheCouponList(List<Coupon> couponList) {
        Log.d("DbHelper", "cacheCouponList start");
        clearCache();
        boolean flag = true;
        for(Coupon coupon : couponList) {
            boolean cacheFlag = cacheCoupon(coupon);
            if(!cacheFlag) {
                Log.d("DbHelper", "cacheFlag = false!");
                flag = false;
            }
        }
        Log.d("DbHelper", "cacheCouponList end");
        return flag;
    }

    @Override
    public List<Coupon> getCouponList() {
        List<Coupon> couponList = new ArrayList<Coupon>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(COUPON_TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst()) {
            do {
                long couponId = cursor.getLong(cursor.getColumnIndex("couponId"));
                String couponDesc = cursor.getString(cursor.getColumnIndex("couponDesc"));
                Coupon coupon = new Coupon();
                coupon.setCouponId(couponId);
                coupon.setCouponDesc(couponDesc);
            } while (cursor.moveToNext());
        } else {
            Log.w("ToDo", "no result in event table under the current filter");
        }
        cursor.close();
        db.close();
        return couponList;
    }

    //清空缓存
    private void clearCache() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(CLEAR_COUPON_TABLE);
        db.close();
    }

    /*
    private void cacheToSd(final String url, final String filePath) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = mOkHttpClient.newCall(request).execute();
            InputStream is = response.body().byteStream();
            byte[] buf = new byte[2048];
            int len = 0;
            FileOutputStream fos = null;
            try {
                File file = new File(context.getExternalFilesDir("coupon"), filePath);
                fos = new FileOutputStream(file);
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                fos.flush();
                Log.d("DbHelper", "image flushed");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fos != null) fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("DbHelper", "cacheToSd end");
    }

    private String composeFilePath(long couponId) {
        Log.d("DbHelper", context.getExternalFilesDir("coupon").getAbsolutePath()
                + couponId + ".jpg");
        String filePath = couponId + ".jpg";
        return filePath;
    }
*/
}
