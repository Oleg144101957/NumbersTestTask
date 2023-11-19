package ua.test.numberstesttask.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ua.test.numberstesttask.R
import ua.test.numberstesttask.databinding.ActivityMainBinding
import ua.test.numberstesttask.numbers.presentation.NumbersFragment

class MainActivity : AppCompatActivity(), ShowFragment {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            show(NumbersFragment(), false)
    }

    override fun show(fragment: Fragment) {
        show(fragment, true)
    }

    private fun show(fragment: Fragment, add: Boolean) {
        //todo make OOP
        val beginTransaction = supportFragmentManager.beginTransaction()
        val container = R.id.container

        if (add) {
            beginTransaction.add(container, fragment)
                .addToBackStack(fragment.javaClass.simpleName)

        } else {
            beginTransaction.replace(container, fragment)
        }

        beginTransaction.commit()
    }
}

interface ShowFragment {
    fun show(fragment: Fragment)
    class Empty : ShowFragment {
        override fun show(fragment: Fragment) = Unit
    }
}