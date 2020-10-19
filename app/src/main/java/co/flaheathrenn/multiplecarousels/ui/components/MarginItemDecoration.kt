package co.flaheathrenn.multiplecarousels.ui.components

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Based on code from https://medium.com/mobile-app-development-publication/right-way-of-setting-margin-on-recycler-views-cell-319da259b641

class MarginItemDecoration(private val spaceBetweenItems: Int, private val orientation: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) != 0) {
                when (orientation) {
                    RecyclerView.HORIZONTAL -> left = spaceBetweenItems
                    else -> top = spaceBetweenItems
                }
            }
        }
    }
}