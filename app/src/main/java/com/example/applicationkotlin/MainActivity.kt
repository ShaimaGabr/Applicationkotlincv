package com.example.applicationkotlin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertArabic()
        val startdate=findViewById<AutoCompleteTextView>(R.id.startdate)
        startdate.setOnClickListener {
         calender(startdate)
        }
        val enddate=findViewById<AutoCompleteTextView>(R.id.endate)
        enddate.setOnClickListener {
            calender(enddate)
        }

        val startTime=findViewById<AutoCompleteTextView>(R.id.startvisit)
        startTime.setOnClickListener {
            time(startTime)
        }


        val endTime=findViewById<AutoCompleteTextView>(R.id.endvisit)
        endTime.setOnClickListener {
            time(endTime)
        }


        val paymentway = findViewById<AutoCompleteTextView>(R.id.paymentway)
        choose(R.array.programming_languages,paymentway)


    }
    fun time(viewd: AutoCompleteTextView){
        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                viewd.setText(String.format("%d : %d", minute, hourOfDay))
            }
        }, hour, minute, false)
        mTimePicker.show()
    }
    fun calender(view: AutoCompleteTextView){
        val  calendar = Calendar.getInstance()
        val  year = calendar.get(Calendar.YEAR)
        val  month = calendar.get(Calendar.MONTH)
        val   dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val   datePickerDialog = DatePickerDialog(this@MainActivity,
            { datePicker, year, month, day -> view.setText(day.toString() + "/" + (month + 1) + "/" + year) },
            year,
            month,
            dayOfMonth
        )
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis())
        datePickerDialog.show()
    }
    fun choose(array: Int, view: AutoCompleteTextView){
        val languages = resources.getStringArray(array)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, languages)
        view.setAdapter(arrayAdapter)

    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun convertArabic(){
        val localeListToSet = LocaleList(Locale("ar"))
        LocaleList.setDefault(localeListToSet)

        resources.configuration.setLocales(localeListToSet)
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)
    }
}