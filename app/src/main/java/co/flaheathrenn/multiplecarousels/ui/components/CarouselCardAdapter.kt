package co.flaheathrenn.multiplecarousels.ui.components

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CarouselCardAdapter(private val cardClickListener: CarouselCardClickListener):
    ListAdapter<CarouselCardViewModel, CarouselCardViewHolder>(CarouselCardDiffCallback()) {

    override fun onBindViewHolder(holder: CarouselCardViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it, cardClickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselCardViewHolder {
        return CarouselCardViewHolder.from(parent)
    }

}

class CarouselCardDiffCallback: DiffUtil.ItemCallback<CarouselCardViewModel>() {

    override fun areItemsTheSame(oldItem: CarouselCardViewModel, newItem: CarouselCardViewModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarouselCardViewModel, newItem: CarouselCardViewModel): Boolean {
        return oldItem == newItem // CarouselCard is a data class so equality is taken care of
    }

}