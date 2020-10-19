package co.flaheathrenn.multiplecarousels.ui.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.flaheathrenn.multiplecarousels.R


class CarouselView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private val titleView: TextView
    private val cardCarousel: RecyclerView
    private lateinit var adapter: CarouselCardAdapter

    init {
        inflate(context, R.layout.carousel, this)
        titleView = rootView.findViewById(R.id.carousel_title)
        cardCarousel = rootView.findViewById(R.id.card_carousel)
        cardCarousel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val carouselCardMargin = MarginItemDecoration(64, cardCarousel.layoutDirection)
        cardCarousel.addItemDecoration(carouselCardMargin)
        cardCarousel.isNestedScrollingEnabled = false
    }

    fun setViewModel(viewModel: CarouselViewModel, lifecycleOwner: LifecycleOwner) {
        viewModel.apply {
            titleView.text = title
            adapter = CarouselCardAdapter(viewModel.cardClickListener)
            cards.let {
                adapter.submitList(it)
            }
            cardCarousel.adapter = adapter
        }
    }
}