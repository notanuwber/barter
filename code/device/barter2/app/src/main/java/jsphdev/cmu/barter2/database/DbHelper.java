package jsphdev.cmu.barter2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import jsphdev.cmu.barter2.adapter.itemProxy.ItemListProxy;
import jsphdev.cmu.barter2.entities.Item;
import jsphdev.cmu.barter2.entities.ItemList;

public class DbHelper extends SQLiteOpenHelper {

    // Database creation sql statement
    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS item(ID INTEGER PRIMARY KEY, DESC TEXT, " +
            "BLOB IMAGE, CATEGORYID TEXT, PRICE INTEGER, SELLER TEXT, PHONE TEXT);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion) {
        Log.w(DbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS item");
        onCreate(database);
    }

    public ItemList getAllItems() {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT  * FROM " + TABLE_ITEM;
        Cursor cursor = db.rawQuery(query, null);

        if (!cursor.moveToFirst()) {
            return null;
        }

        ItemList list = new ItemListProxy().build();
        do {
            Item item = new Item().setId(Integer.parseInt(cursor.getString(0)))
                    .setDescription(cursor.getString(1))
                    .setImage(cursor.getBlob(2))
                    .setCategory(cursor.getString(3))
                    .setPrice(cursor.getInt(4))
                    .setSeller(cursor.getString(5))
                    .setPhone(cursor.getString(6));

            list.add(item);
        } while (cursor.moveToNext());

        return list;
    }

    public void insert(Item item) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID", item.getId());
        values.put("DESC", item.getDescription());
        values.put("IMAGE", item.getImage());
        values.put("CATEGORY", item.getCategory());
        values.put("PRICE", item.getPrice());
        values.put("SELLER", item.getSeller());
        values.put("PHONE", item.getPhone());

        db.insert(TABLE_ITEM, null, values);
        db.close();
    }

    private static final String DATABASE_NAME = "barter";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ITEM = "item";
}
