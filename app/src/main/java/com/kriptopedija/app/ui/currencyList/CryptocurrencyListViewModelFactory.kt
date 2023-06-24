package com.kriptopedija.app.ui.currencyList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kriptopedija.app.domain.fakeapi.CryptocurrencyDbApiProvider
import com.kriptopedija.app.domain.repository.CryptocurrencyRepository

class CryptocurrencyListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CryptocurrencyRepository::class.java)
            .newInstance(
                CryptocurrencyRepository(CryptocurrencyDbApiProvider.getCryptocurrencyDbApi())
            )
    }
}