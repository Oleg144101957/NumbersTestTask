package ua.test.numberstesttask.numbers.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import ua.test.numberstesttask.R
import ua.test.numberstesttask.details.presentation.DetailsFragment
import ua.test.numberstesttask.main.presentation.ShowFragment

class NumbersFragment : Fragment() {

    private var showFragment: ShowFragment = ShowFragment.Empty()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        showFragment = context as ShowFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_numbers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //todo remove hardcode

        view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        view.findViewById<Button>(R.id.getFactButton).setOnClickListener {

            showFragment.show(DetailsFragment.newInstance("Some info about random number"))
        }
    }

    override fun onDetach() {
        super.onDetach()
        showFragment = ShowFragment.Empty()
    }
}