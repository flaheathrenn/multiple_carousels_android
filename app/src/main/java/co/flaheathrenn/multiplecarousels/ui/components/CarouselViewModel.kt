package co.flaheathrenn.multiplecarousels.ui.components

import androidx.lifecycle.ViewModel

data class CarouselViewModel(val title: String,
                             val cards: List<CarouselCardViewModel>,
                             val cardClickListener: CarouselCardClickListener
                             ) : ViewModel() {
}