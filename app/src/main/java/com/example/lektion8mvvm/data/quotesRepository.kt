package com.example.lektion8mvvm.data

class QuotesRepository private constructor(private val quoteData: DataClass) {

    fun addQuote(quote: Quote) {
        quoteData.addQuote(quote)
    }

    fun getQuotes() = quoteData.getQuotes()

    //Singleton.
    companion object {
        @Volatile private var instance: QuotesRepository? = null
        fun getInstance(quoteData: DataClass) =
            instance ?: synchronized(this) {
                instance ?: QuotesRepository(quoteData).also { instance = it }
            }
        //instance ?: <-- Ifall instance finns, ge tillbaka instance. Annars:
        //synchronized -> Gör detta för alla trådar.
        // (lock: this) -> Lås denna klass för ändring av andra trådar. this = denna companion object.
        // synchronized(this) { <vad vi exekverar ifall vi inte har en instans.> }
        // instance ?: <-- Vi kollar igen om vi verkligen inte har en instans.
        // Database() -> Då skapar vi en databas.
        // .also { <vi gör också detta> }
        // instance = it -> Detta sätter vår instance, den ovan satt till null, till "it"
        // där "it" är ett nyckelord för den databas vi just startade.
    }
}