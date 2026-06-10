package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var btnAdd: Button
    lateinit var textQuote: TextView
    lateinit var textAverage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listViewNotes)
        btnAdd = findViewById(R.id.buttonAddNote)
        textQuote = findViewById(R.id.textViewQuote)
        textAverage = findViewById(R.id.textViewAverage)

        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }

        loadData()
        loadQuote()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {

        val db = DatabaseHelper(this)
        val notes = db.getNotes()

        val list = ArrayList<String>()
        var total = 0.0

        for (n in notes) {
            val ort = (n.vize * 0.4) + (n.final * 0.6)
            total += ort
            list.add("${n.ders} - Ortalama: $ort")
        }

        val avg = if (notes.isNotEmpty()) total / notes.size else 0.0
        textAverage.text = "Genel Ortalama: %.2f".format(avg)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
    }

    private fun loadQuote() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.quotable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.getQuote().enqueue(object : Callback<QuoteResponse> {

            override fun onResponse(
                call: Call<QuoteResponse>,
                response: Response<QuoteResponse>
            ) {
                textQuote.text = response.body()?.content ?: "Söz yok"
            }

            override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                textQuote.text = "Günün sözü yüklenemedi"
            }
        })
    }
}