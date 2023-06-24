package com.kriptopedija.app.ui.currencyList

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.kriptopedija.app.R
import com.kriptopedija.app.adapters.CryptocurrencyAdapter
import com.kriptopedija.app.databinding.FragmentCurrenciesBinding
import com.kriptopedija.app.domain.model.Cryptocurrency
import com.kriptopedija.app.ui.currencyDetails.CryptocurrencyDetailsFragment
import com.kriptopedija.app.ui.currencyDetails.CryptocurrencyDetailsViewModel

class CryptocurrencyListFragment : Fragment(R.layout.fragment_currencies){

    private var _binding: FragmentCurrenciesBinding? = null

    private val binding get() = _binding!!

    private lateinit var currencyListViewModel: CryptocurrencyListViewModel

    private val currencyDetailsViewModel: CryptocurrencyDetailsViewModel by activityViewModels{CryptocurrencyListViewModelFactory(requireContext())}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCurrenciesBinding.bind(view)

        val viewModelFactory = CryptocurrencyListViewModelFactory(requireContext())
        currencyListViewModel = ViewModelProvider(this, viewModelFactory)[CryptocurrencyListViewModel::class.java]

        val clicker = object : CryptocurrencyAdapter.OnClickListener {
            override fun onClickItem(currencyId: String) {
                currencyDetailsViewModel.listAllDetails(currencyId)
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_view, CryptocurrencyDetailsFragment())
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }

        var adapter:CryptocurrencyAdapter = CryptocurrencyAdapter(ArrayList<Cryptocurrency>(), clicker)
        binding.list.adapter = adapter

        currencyListViewModel.getCurrenciesLiveData().observe(viewLifecycleOwner) {
            adapter.updateCurrencies(it)
        }

        currencyListViewModel.listAll()
    }
}