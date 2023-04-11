package io.github.hrossi.presentation.dropofflocation.list

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.hrossi.R
import io.github.hrossi.databinding.FragmentDropOffLocationListBinding
import io.github.hrossi.domain.DropOffLocation
import io.github.hrossi.presentation.LocationAdapter
import io.github.hrossi.utils.extensions.gone
import io.github.hrossi.utils.extensions.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class DropOffLocationListFragment : Fragment() {

    private var binding: FragmentDropOffLocationListBinding? = null

    private val vm: DropOffLocationListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDropOffLocationListBinding.inflate(layoutInflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setupListeners()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun observeData() {
        vm.state.observe(viewLifecycleOwner) {
            when (it) {
                is ScreenState.Loading -> {
                    binding?.loading?.visible()
                    binding?.error?.gone()
                }
                is ScreenState.Data -> {
                    binding?.locationsRecycler?.adapter =
                        LocationAdapter(it.locations, ::onLocationClick)
                    binding?.loading?.gone()
                    binding?.error?.gone()
                }
                is ScreenState.Error -> {
                    binding?.error?.visible()
                    binding?.loading?.gone()
                }
            }
        }
    }

    private fun setupListeners() {
        binding?.errorTryAgainButton?.setOnClickListener {
            vm.onClickTryAgain()
        }
    }

    private fun onLocationClick(location: DropOffLocation) {
        AlertDialog.Builder(requireContext())
            .setTitle(location.name)
            .setMessage(location.address)
            .setPositiveButton(R.string.ok, null)
            .setNegativeButton(R.string.directions) { _, _ ->
                Intent(ACTION_VIEW).apply {
                    data = "geo:${location.latitude},${location.longitude}?q=${location.address}".toUri()
                }.run {
                    startActivity(this)
                }
            }
            .show()
    }
}