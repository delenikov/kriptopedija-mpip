package com.kriptopedija.app.ui.currencyList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kriptopedija.app.domain.model.Cryptocurrency
import com.kriptopedija.app.domain.repository.CryptocurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptocurrencyListViewModel (private val cryptocurrencyRepository: CryptocurrencyRepository): ViewModel() {

    private val currenciesLiveData = MutableLiveData<List<Cryptocurrency>>()

    fun getCurrenciesLiveData(): LiveData<List<Cryptocurrency>> = currenciesLiveData

    fun listAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val currencies = cryptocurrencyRepository.listCurrencies()
            currenciesLiveData.postValue(currencies)
        }
    }

}