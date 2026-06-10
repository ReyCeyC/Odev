import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "ogrenci.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(
            "CREATE TABLE notes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "ders TEXT," +
                    "vize INTEGER," +
                    "final INTEGER)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS notes")
        onCreate(db)
    }

    fun insertNote(ders: String, vize: Int, final: Int) {
        val db = writableDatabase

        val values = ContentValues()
        values.put("ders", ders)
        values.put("vize", vize)
        values.put("final", final)

        db.insert("notes", null, values)
    }
}
