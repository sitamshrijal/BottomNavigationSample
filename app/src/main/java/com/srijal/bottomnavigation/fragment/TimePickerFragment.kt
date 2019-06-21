package com.srijal.bottomnavigation.fragment

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs

/**
 * A time picker.
 */
class TimePickerFragment : DialogFragment() {

    private val args: TimePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val (hour, minute) = args

        return TimePickerDialog(
            activity,
            null,
            hour,
            minute,
            DateFormat.is24HourFormat(activity)
        )
    }
}
