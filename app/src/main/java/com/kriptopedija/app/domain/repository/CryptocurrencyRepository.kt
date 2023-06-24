package com.kriptopedija.app.domain.repository

import com.kriptopedija.app.domain.fakeapi.CryptocurrencyDbApi
import com.kriptopedija.app.domain.model.Cryptocurrency

class CryptocurrencyRepository(
    private val cryptocurrencyDbApi: CryptocurrencyDbApi
) {
    fun listCurrencies(): List<Cryptocurrency> {
        return cryptocurrencyDbApi.getAllCurrencies()
    }

    fun getCurrency(currencyId: String): Cryptocurrency {
        val currencies = cryptocurrencyDbApi.getAllCurrencies()
        val currency = currencies.find { it.id.toString() == currencyId }
        return currency!!
    }

    fun addCurrency(name: String, price: String, hourDifference: String, dayDifference: String, weekDifference: String, photo: String):List<Cryptocurrency> {
        cryptocurrencyDbApi.addCurrency(name, price, hourDifference, dayDifference, weekDifference, photo)
        return cryptocurrencyDbApi.getAllCurrencies()
    }
}