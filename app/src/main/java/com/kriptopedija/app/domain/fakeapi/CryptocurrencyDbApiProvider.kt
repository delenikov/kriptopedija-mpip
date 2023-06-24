package com.kriptopedija.app.domain.fakeapi

class CryptocurrencyDbApiProvider {
    companion object {
        @Volatile
        private var INSTANCE: CryptocurrencyDbApi? = null

        @JvmStatic
        fun getCryptocurrencyDbApi(): CryptocurrencyDbApi {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = createCryptocurrencyDbApi()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private fun createCryptocurrencyDbApi(): CryptocurrencyDbApi {
            var cryptocurrencyDbApi = CryptocurrencyDbApi()
            cryptocurrencyDbApi.addCurrency(
                "Bitcoin",
                "$30,600",
                "Up:0.40%",
                "Down:2.11%",
                "Up:15.88%",
                "bitcoin"

            )
            cryptocurrencyDbApi.addCurrency(
                "Ethereum",
                "$1,885",
                "Up:0.30%",
                "Down:1.84%",
                "Up:9.28%",
                "ethereum"

            )
            cryptocurrencyDbApi.addCurrency(
                "Tether",
                "$1",
                "Up:0.02%",
                "Up:0.01%",
                "Up:0.08%",
                "tether"
            )
            cryptocurrencyDbApi.addCurrency(
                "BNB",
                "$235",
                "Up:0.17%",
                "Down:4.60%",
                "Down:3.87%",
                "bnb"
            )
            cryptocurrencyDbApi.addCurrency(
                "USD Coin",
                "$1",
                "Up:0.02%",
                "Down:0.04%",
                "Down:0.01%",
                "usd"
            )
            cryptocurrencyDbApi.addCurrency(
                "XRP",
                "$0.48",
                "Up:0.15%",
                "Down:2.55%",
                "Up:1.60%",
                "xrp"
            )
            cryptocurrencyDbApi.addCurrency(
                "Cardano",
                "$0.29",
                "Up:0.68%",
                "Down:4.10%",
                "Up:7.80%",
                "cardano"
            )
            cryptocurrencyDbApi.addCurrency(
                "Dogecoin",
                "$0.06",
                "Up:0.22%",
                "Down:3.63%",
                "Up:7.04%",
                "dogecoin"
            )
            cryptocurrencyDbApi.addCurrency(
                "Solana",
                "$16",
                "Down:0.83%",
                "Down:2.41%",
                "Up:6.12%",
                "solana"
            )
            return cryptocurrencyDbApi
        }
    }
}