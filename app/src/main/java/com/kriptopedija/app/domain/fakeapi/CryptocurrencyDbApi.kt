package com.kriptopedija.app.domain.fakeapi

import com.kriptopedija.app.domain.model.Cryptocurrency


class CryptocurrencyDbApi {
    private val currencies: MutableList<Cryptocurrency> = ArrayList()


    fun getAllCurrencies(): List<Cryptocurrency> {
        return currencies
    }

    fun addCurrency(
        name: String,
        price: String,
        hourDifference: String,
        dayDifference: String,
        weekDifference: String,
        photo: String
    ) {
        val newCurrency = Cryptocurrency(
            currencies.size,
            name,
            price,
            hourDifference,
            dayDifference,
            weekDifference,
            photo
        )
        currencies.add(newCurrency)
    }
}