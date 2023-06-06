package com.example.applicationkotlin.network

import com.example.applicationkotlin.data.ConfimBooked
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface InformationClient {

    @POST("")
    suspend fun getConfirmBooked(
        @Field("nurse_id") nurse_id:String,
        @Field("patient_name") patient_name:String,
        @Field("repeat_type") repeat_type:String,
        @Field("number_of_hours") number_of_hours:String,
        @Field("nurse_work_style") nurse_work_style:String,      // 1- home , 2- clinic
        @Field("favourite_place_id") favourite_place_id:String,
        @Field("payment_type_id") payment_type_id:String,
        @Field("start_date") start_date:String,
        @Field("end_date") end_date:String,
        @Field("start_time") start_time:String,
        @Field("end_time") end_time:String,
        @Field("booking_date") booking_date:String,
        @Field("note") note:String
    ): Response<ConfimBooked>
}