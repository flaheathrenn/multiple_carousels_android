package co.flaheathrenn.multiplecarousels.ui.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.flaheathrenn.multiplecarousels.databinding.CardBinding

class CarouselCardViewHolder private constructor(private val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CarouselCardViewModel, cardClickListener: CarouselCardClickListener) {
        binding.cardContent = item
        binding.cardClickListener = cardClickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): CarouselCardViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CardBinding.inflate(layoutInflater, parent, false)
            return CarouselCardViewHolder(binding)
        }
    }
}

class CarouselCardClickListener(val clickListener: (cardId: Long) -> Unit) {
    fun onClick(cardId: Long) {
        clickListener(cardId)
    }

}