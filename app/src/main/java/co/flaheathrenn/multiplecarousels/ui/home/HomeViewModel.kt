package co.flaheathrenn.multiplecarousels.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.flaheathrenn.multiplecarousels.ui.components.CarouselCardViewModel

class HomeViewModel : ViewModel() {
    private val _navigateToCard = MutableLiveData<Long>()
    val navigateToCard: LiveData<Long>
        get() = _navigateToCard

    fun onCardClicked(cardId: Long) {
        _navigateToCard.value = cardId
    }

    fun onCardNavigated() {
        _navigateToCard.value = null
    }

    private val cardData1 = CarouselCardViewModel(1L,"Card 1")
    private val cardData2 = CarouselCardViewModel(2L,"Card 2")
    private val cardData3 = CarouselCardViewModel(3L,"Card 3")
    private val cardData4 = CarouselCardViewModel(4L,"Card 4")
    private val cardData5 = CarouselCardViewModel(5L,"Card 5")
    private val cardData6 = CarouselCardViewModel(6L,"Card 6")
    private val cardData7 = CarouselCardViewModel(7L,"Card 7")
    private val cardData8 = CarouselCardViewModel(8L,"Card 8")

    val cards1 = listOf(cardData1, cardData2, cardData3, cardData4)

    val cards2 = listOf(cardData5, cardData6, cardData7, cardData8)
}