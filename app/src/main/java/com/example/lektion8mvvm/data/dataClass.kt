package com.example.lektion8mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataClass {
    private val quoteList = mutableListOf<Quote>()
    private val liveQuotes = MutableLiveData<List<Quote>>()

    init {
        liveQuotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        liveQuotes.value = quoteList
    }

    fun getQuotes() = liveQuotes as LiveData<List<Quote>>
    // Live-data kan kopplas till en Observe, och då kommer
    // värdet kopplad med Observe att automatiskt uppdateras
    // när som helst live-variablen ändras.
}