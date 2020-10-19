package co.flaheathrenn.multiplecarousels.ui.card

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import co.flaheathrenn.multiplecarousels.R

class CardFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = inflater.inflate(R.layout.fragment_card, container, false)

        val cardIdTextView: TextView = result.findViewById(R.id.cardId_textView)
        cardIdTextView.text = "This is the card screen"
        return result
    }
}