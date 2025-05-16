package com.example.sqlite1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardim(context: Context) : SQLiteOpenHelper(context, "rehber.sqlite", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL("CREATE TABLE kisiler(kisi_id INTEGER PRIMARY KEY AUTOINCREMENT," +
               "kisi_ad TEXT, kisi_tel TEXT)")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS kisiler")
        onCreate(db)
    }
}

// hazır bir veri tabanıyla çalışma

/*

class VeriTabaniYardimcisi(context: Context) :
    SQLiteOpenHelper(context, "filmler.sqlite", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
            CREATE TABLE IF NOT EXISTS kategoriler (
                kategori_id INTEGER PRIMARY KEY AUTOINCREMENT,
                kategori_ad TEXT
            );
        """.trimIndent())

        db?.execSQL("""
            CREATE TABLE IF NOT EXISTS yonetmenler (
                yonetmen_id INTEGER PRIMARY KEY AUTOINCREMENT,
                yonetmen_ad TEXT
            );
        """.trimIndent())

        db?.execSQL("""
            CREATE TABLE IF NOT EXISTS Filimler (
                film_id INTEGER PRIMARY KEY AUTOINCREMENT,
                film_ad TEXT,
                film_imdb TEXT,
                film_yonetmen INTEGER,
                film_kategori INTEGER,
                film_resim BLOB,
                FOREIGN KEY(film_kategori) REFERENCES kategoriler(kategori_id),
                FOREIGN KEY(film_yonetmen) REFERENCES yonetmenler(yonetmen_id)
            );
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Filimler")
        db?.execSQL("DROP TABLE IF EXISTS kategoriler")
        db?.execSQL("DROP TABLE IF EXISTS yonetmenler")
        onCreate(db)
    }
}
*/
