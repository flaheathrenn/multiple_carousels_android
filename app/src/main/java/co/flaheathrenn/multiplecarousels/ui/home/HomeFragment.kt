package co.flaheathrenn.multiplecarousels.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import co.flaheathrenn.multiplecarousels.R
import co.flaheathrenn.multiplecarousels.ui.components.CarouselCardClickListener
import co.flaheathrenn.multiplecarousels.ui.components.CarouselView
import co.flaheathrenn.multiplecarousels.ui.components.CarouselViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val carouselCardClickListener = CarouselCardClickListener { cardId ->
            homeViewModel.onCardClicked(cardId)
        }

        val carouselCardClickListener2 = CarouselCardClickListener { cardId ->
            homeViewModel.onCardClicked(cardId)
        }

        val carouselView = root.findViewById<CarouselView>(R.id.carousel_1)
        val carouselViewModel = CarouselViewModel(
            "Carousel 1",
            homeViewModel.cards1,
            carouselCardClickListener
        )
        carouselView.setViewModel(carouselViewModel, this.viewLifecycleOwner)

        val carouselView2 = root.findViewById<CarouselView>(R.id.carousel_2)
        val carouselViewModel2 = CarouselViewModel(
            "Carousel 2",
            homeViewModel.cards2,
            carouselCardClickListener2
        )
        carouselView2.setViewModel(carouselViewModel2, this.viewLifecycleOwner)

        homeViewModel.navigateToCard.observe(this.viewLifecycleOwner, { cardId ->
            cardId?.let {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionNavigationHomeToCardFragment()
                )
                homeViewModel.onCardNavigated()
            }
        })

        return root
    }
}