package com.example.lektion8mvvm.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lektion8mvvm.data.QuotesRepository

class QuotesViewModelFactory(private val quotesRepository: QuotesRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}