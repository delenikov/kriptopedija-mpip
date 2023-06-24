package com.kriptopedija.app.ui.currencyDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kriptopedija.app.domain.model.Cryptocurrency
import com.kriptopedija.app.domain.repository.CryptocurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptocurrencyDetailsViewModel(private val cryptocurrencyRepository: CryptocurrencyRepository) : ViewModel() {

    private val detailsForCurrencyLiveData = MutableLiveData<Cryptocurrency>()

    fun getDetailsForCurrencyLiveData(): LiveData<Cryptocurrency> = detailsForCurrencyLiveData

    fun listAllDetails(currencyId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val currency = cryptocurrencyRepository.getCurrency(currencyId)
            detailsForCurrencyLiveData.postValue(currency)
        }
    }
}