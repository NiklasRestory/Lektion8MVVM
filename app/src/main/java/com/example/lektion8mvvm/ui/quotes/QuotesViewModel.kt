package com.example.lektion8mvvm.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.lektion8mvvm.data.Quote
import com.example.lektion8mvvm.data.QuotesRepository

class QuotesViewModel(private val quotesRepository: QuotesRepository)
    : ViewModel() {

    fun getQuotes() = quotesRepository.getQuotes()

    fun addQuote(quote: Quote) = quotesRepository.addQuote(quote)
}