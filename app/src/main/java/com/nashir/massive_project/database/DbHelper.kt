import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.nashir.massive_project.NonEmergency.Pelatihan.model.UserModel


class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "RegistrasiDB"
        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAMA = "nama"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_NO_TELEPON = "no_telepon"
        private const val COLUMN_ALAMAT = "alamat"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_JENIS_KELAMIN = "jenis_kelamin"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USERS_TABLE = ("CREATE TABLE $TABLE_USERS ("
                + "$COLUMN_ID INTEGER PRIMARY KEY,"
                + "$COLUMN_NAMA TEXT,"
                + "$COLUMN_EMAIL TEXT,"
                + "$COLUMN_NO_TELEPON TEXT,"
                + "$COLUMN_ALAMAT TEXT,"
                + "$COLUMN_PASSWORD TEXT,"
                + "$COLUMN_JENIS_KELAMIN TEXT)"
                )
        db?.execSQL(CREATE_USERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun addUser(user: UserModel): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAMA, user.nama)
        values.put(COLUMN_EMAIL, user.email)
        values.put(COLUMN_NO_TELEPON, user.noTelepon)
        values.put(COLUMN_ALAMAT, user.alamat)
        values.put(COLUMN_PASSWORD, user.password)
        values.put(COLUMN_JENIS_KELAMIN, user.jenisKelamin)

        val id = db.insert(TABLE_USERS, null, values)
        db.close()

        if (id > 0) {
            Log.d("DbHelper", "Data pengguna berhasil dimasukkan dengan ID: $id")
        } else {
            Log.d("DbHelper", "Gagal memasukkan data pengguna")
        }

        return id
    }

    fun userLogin(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))

        val count = cursor.count
        cursor.close()
        db.close()

        if (count > 0) {
            Log.d("DbHelper", "Permintaan login berhasil")
        } else {
            Log.d("DbHelper", "Permintaan login gagal")
        }

        return count > 0
    }
}
