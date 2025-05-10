package com.example.sqlite1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val vt = VeritabaniYardim(this)
       // Kisilerdeo().kisi_ekle(vt,"Ahmewqfwft","123")
        //Kisilerdeo().gunceleme(vt,"Mehmet yenimehmet","456",1)
        //Kisilerdeo().kisi_sil(vt,1)
        //val kisiliste = Kisilerdeo().tumKisiler(vt)
        //val kisiliste = Kisilerdeo().ara(vt,"A")
      //  val kisiliste = Kisilerdeo().kayıtKontrol(vt,"Ahmet")
        //val gelenkisi = Kisilerdeo().kisi_getir(vt,2)




/*
        for (k in kisiliste){
            Log.e("Kisi id ", k.kisi_id.toString())
            Log.e("Kisi ad ", k.kisi_ad)
            Log.e("Kisi tel ", k.kisi_tel)
        }*/

    }
}