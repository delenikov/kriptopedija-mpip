package com.kriptopedija.app.ui.currencyDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.kriptopedija.app.R
import com.kriptopedija.app.databinding.FragmentCurrencyDetailsBinding

class CryptocurrencyDetailsFragment : Fragment(R.layout.fragment_currency_details) {

    private var _binding: FragmentCurrencyDetailsBinding? = null

    private val binding get() = _binding!!

    private val currencyDetailsViewModel:CryptocurrencyDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCurrencyDetailsBinding.bind(view)

        currencyDetailsViewModel.getDetailsForCurrencyLiveData().observe(viewLifecycleOwner) {
            binding.currencyName.text = it.name
            binding.currencyPrice.text = it.price
            binding.currencyHourDiff.text="1h% : "+it.hourDifference
            binding.currencyDayDiff.text="24h% : "+it.dayDifference
            binding.currencyWeekDiff.text="7d% : "+it.weekDifference
            when (it.photo) {
                "bitcoin" -> binding.currencyPhoto.setImageResource(R.drawable.bitcoin)
                "ethereum" -> binding.currencyPhoto.setImageResource(R.drawable.ethereum)
                "tether" -> binding.currencyPhoto.setImageResource(R.drawable.tether)
                "bnb" -> binding.currencyPhoto.setImageResource(R.drawable.bnb)
                "usd" -> binding.currencyPhoto.setImageResource(R.drawable.usd)
                "xrp" -> binding.currencyPhoto.setImageResource(R.drawable.xrp)
                "cardano" -> binding.currencyPhoto.setImageResource(R.drawable.cardano)
                "dogecoin" -> binding.currencyPhoto.setImageResource(R.drawable.dogecoin)
                "solana" -> binding.currencyPhoto.setImageResource(R.drawable.solana)
                else -> {
                    // Handle any other cases
                }
            }
        }
    }
}