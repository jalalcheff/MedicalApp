package com.example.medicalapp.domain

class ConvertTextIntoRtlUsecase {
    fun convertTextIntoRtlUsecase(sentence: String): String{
        val listOfWords = sentence.split(" ")
        val day = listOfWords[0]
        val year = listOfWords[1]
        var month = ""
        for (i in listOfWords)
        {
            if (i != day && i != year){
                month += i
            }

        }
        month = month.removeSurrounding(prefix = " ", suffix = " ")
        return "$day $year $month"
    }
}