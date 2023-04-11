package io.github.hrossi.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.hrossi.databinding.ListItemLocationBinding
import io.github.hrossi.domain.DropOffLocation

class LocationAdapter(
    private val locations: List<DropOffLocation>,
    private val onLocationClick: (DropOffLocation) -> Unit
) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ListItemLocationBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(locations[position])
    }

    inner class ViewHolder(
        private val binding: ListItemLocationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(location: DropOffLocation) {
            binding.locationNameTextView.text = location.name
            binding.locationAddressTextView.text = location.address
            binding.locationLatLongTextView.text = "${location.latitude}, ${location.longitude}"

            binding.root.setOnClickListener {
                onLocationClick(location)
            }
        }
    }
}