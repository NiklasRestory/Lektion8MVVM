package com.example.lektion8mvvm.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lektion8mvvm.R
import com.example.lektion8mvvm.data.Quote
import com.example.lektion8mvvm.utilities.InjectionUtils
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectionUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { liveQuotes ->
            val stringBuilder = StringBuilder()
            liveQuotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            val tv_quotes : TextView = findViewById(R.id.tv_quote)
            tv_quotes.text = stringBuilder.toString()
        })

        val btn_add = findViewById<Button>(R.id.btn_add)
        val et_quote = findViewById<EditText>(R.id.et_quote)
        val et_author = findViewById<EditText>(R.id.et_author)

        btn_add.setOnClickListener {
            val quote = Quote(et_quote.text.toString(), et_author.text.toString())
            viewModel.addQuote(quote)
        }



    }
}