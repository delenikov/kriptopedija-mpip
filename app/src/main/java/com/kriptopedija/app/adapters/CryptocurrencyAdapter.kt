package com.kriptopedija.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kriptopedija.app.R
import com.kriptopedija.app.domain.model.Cryptocurrency

class CryptocurrencyAdapter(
    private val currencies: ArrayList<Cryptocurrency> = ArrayList(),
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<CryptocurrencyAdapter.CryptocurrenciesViewHolder>() {

    interface OnClickListener {
        fun onClickItem(currencyId: String)
    }

    class CryptocurrenciesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var currencyName: TextView = view.findViewById(R.id.currency_name)
        private var currencyPhoto: ImageView = view.findViewById(R.id.currency_photo)
        private var currencyPrice: TextView = view.findViewById(R.id.currency_price)

        fun bind(
            currency: Cryptocurrency,
            onClickListener: OnClickListener
        ) {
            currencyName.text = currency.name
            currencyPrice.text = currency.price
            when (currency.photo) {
                "bitcoin" -> currencyPhoto.setImageResource(R.drawable.bitcoin)
                "ethereum" -> currencyPhoto.setImageResource(R.drawable.ethereum)
                "tether" -> currencyPhoto.setImageResource(R.drawable.tether)
                "bnb" -> currencyPhoto.setImageResource(R.drawable.bnb)
                "usd" -> currencyPhoto.setImageResource(R.drawable.usd)
                "xrp" -> currencyPhoto.setImageResource(R.drawable.xrp)
                "cardano" -> currencyPhoto.setImageResource(R.drawable.cardano)
                "dogecoin" -> currencyPhoto.setImageResource(R.drawable.dogecoin)
                "solana" -> currencyPhoto.setImageResource(R.drawable.solana)
                else -> {
                    // Handle any other cases
                }
            }

            itemView.setOnClickListener {
                onClickListener.onClickItem(currency.id.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptocurrenciesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_layout, parent, false)
        return CryptocurrenciesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptocurrenciesViewHolder, position: Int) {
        holder.bind(currencies[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    fun updateCurrencies(currencies: List<Cryptocurrency>) {
        this.currencies.clear()
        this.currencies.addAll(currencies)
        notifyDataSetChanged()
    }
}