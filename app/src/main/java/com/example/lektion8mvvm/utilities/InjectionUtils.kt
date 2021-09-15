package com.example.lektion8mvvm.utilities

import com.example.lektion8mvvm.data.Database
import com.example.lektion8mvvm.data.QuotesRepository
import com.example.lektion8mvvm.ui.quotes.QuotesViewModelFactory

object InjectionUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quotesRepository = QuotesRepository.getInstance(Database.getInstance().quote)
        return QuotesViewModelFactory(quotesRepository)
    }
}