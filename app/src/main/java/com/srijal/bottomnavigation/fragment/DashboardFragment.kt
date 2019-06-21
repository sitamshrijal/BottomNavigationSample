package com.srijal.bottomnavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.srijal.bottomnavigation.R
import kotlinx.android.synthetic.main.fragment_dashboard.express_transfer
import kotlinx.android.synthetic.main.fragment_dashboard.view.input_amount
import kotlinx.android.synthetic.main.fragment_dashboard.view.send
import java.text.NumberFormat

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.input_amount.doOnTextChanged { text, _, _, _ ->
            view.send.text = if (!text.isNullOrEmpty()) {

                val amount = text.toString().toIntOrNull() ?: 0

                "Send ${NumberFormat.getCurrencyInstance().format(amount)}"
            } else
                getString(R.string.send)
        }

        view.send.setOnClickListener {
            val content = view.input_amount.text.toString()

            val amount = content.toIntOrNull() ?: 0

            val action = DashboardFragmentDirections.confirmationAction(
                amount,
                "Jodie",
                express_transfer.isChecked
            )
            it.findNavController().navigate(action)
        }
    }
}
