package com.example.timepickerdialog

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var timePickerDialog: TimePickerDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTimepicker.requestFocus()
        edtTimepicker.setOnClickListener(View.OnClickListener { v: View? -> openTimepickerDialog() })
    }

    private fun openTimepickerDialog() {
        val currentTime = Calendar.getInstance()
        val hour = currentTime[Calendar.HOUR_OF_DAY]
        val minute = currentTime[Calendar.MINUTE]
        timePickerDialog = TimePickerDialog(this@MainActivity,
            { view, hourOfDay, minuteOfHour ->
                var hour = "" + hourOfDay
                var minute = "" + minuteOfHour
                if (hourOfDay < 10) {
                    hour = "0$hour"
                }
                if (minuteOfHour < 10) {
                    minute = "0$minute"
                }
                val time = "$hour:$minute"
                edtTimepicker!!.setText(time)
            }, hour, minute, false
        )
        timePickerDialog!!.setTitle("Select Time")
        timePickerDialog!!.show()
    }
}