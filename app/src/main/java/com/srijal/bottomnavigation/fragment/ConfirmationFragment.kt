package com.srijal.bottomnavigation.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.core.text.parseAsHtml
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.srijal.bottomnavigation.R
import java.text.NumberFormat

/**
 * Transfer confirmation fragment.
 */
class ConfirmationFragment : DialogFragment() {

    private val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Arguments received by this destination.
        val (amount, receiver, isExpress) = args

        val transferAmount = NumberFormat.getCurrencyInstance().format(amount)

        val mode = if (isExpress)
            "Express"
        else
            "Regular"

        val text =
            getString(R.string.confirm_transfer, transferAmount, receiver, mode).parseAsHtml()

        return MaterialAlertDialogBuilder(context)
            .setTitle("Confirmation")
            .setMessage(text)
            .setPositiveButton("Send", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create()
    }
}
