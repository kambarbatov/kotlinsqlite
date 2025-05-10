package com.example.sqlite1

import android.content.ContentValues

class Kisilerdeo {

    fun kisi_ekle(vt: VeritabaniYardim, ad: String, tel: String) {
        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("kisi_ad", ad)
        values.put("kisi_tel", tel)
        db.insertOrThrow("kisiler", null, values)
        db.close()
    }

    fun tumKisiler(vt: VeritabaniYardim): ArrayList<Kisiler>{

        val kisilerarrayList = ArrayList<Kisiler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kisiler",null)
        while (cursor.moveToNext()){
            val kisi = Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_id"))
                ,cursor.getString(cursor.getColumnIndex("kisi_ad"))
                ,cursor.getString(cursor.getColumnIndex("kisi_tel")))
            kisilerarrayList.add(kisi)
        }
        return kisilerarrayList
    }

    fun gunceleme(vt: VeritabaniYardim,ad:String,tel:String,kisi_id:Int){
        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("kisi_ad",ad)
        values.put("kisi_tel",tel)

        db.update("kisiler",values,"kisi_id=?", arrayOf(kisi_id.toString()))
        db.close()
    }

    fun kisi_sil(vt: VeritabaniYardim,kisi_id:Int){
        val db = vt.writableDatabase
        db.delete("kisiler","kisi_id=?", arrayOf(kisi_id.toString()))
        db.close()
    }

    fun ara (vt: VeritabaniYardim,aramaKelimesi:String): ArrayList<Kisiler>{
        val db = vt.writableDatabase
        val kisilerarrayList = ArrayList<Kisiler>()
        val cursor = db.rawQuery("SELECT * FROM kisiler WHERE kisi_ad like '%$aramaKelimesi%'",null)
        while (cursor.moveToNext()){
            val kisi = Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_id"))
                ,cursor.getString(cursor.getColumnIndex("kisi_ad"))
                ,cursor.getString(cursor.getColumnIndex("kisi_tel")))

            kisilerarrayList.add(kisi)
        }
        return kisilerarrayList
    }

    fun kayıtKontrol (vt: VeritabaniYardim, kisi_ad: String) : Int{
        var sonuc = 0
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT count(*) AS sonuc FROM kisiler WHERE kisi_ad = '$kisi_ad'",null)
        while (cursor.moveToNext()){
            sonuc = cursor.getInt(cursor.getColumnIndex("sonuc"))
        }
        return sonuc
    }

    fun kisi_getir(vt: VeritabaniYardim,kisi_id:Int): Kisiler?{
        var gelenkisi: Kisiler? = null
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kisiler WHERE kisi_id = '$kisi_id'",null)
        while (cursor.moveToNext()){
            gelenkisi= Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_id"))
            ,cursor.getString(cursor.getColumnIndex("kisi_ad"))
            ,cursor.getString(cursor.getColumnIndex("kisi_tel")))
        }
        return gelenkisi
    }


}