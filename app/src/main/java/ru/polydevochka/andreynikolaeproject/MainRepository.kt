package ru.polydevochka.andreynikolaeproject

import androidx.appcompat.app.AppCompatActivity

public class MainRepository(): MainContract.Repository, AppCompatActivity(){

    private lateinit var mPresenter: MainContract.Presenter

    override fun attachPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }


    override fun getArrayInfo():Array<Array<String>>
    {
        var rawArr = resources.getStringArray(R.array.Information)
        return Array(rawArr.size){ i -> rawArr[i].split(",").toTypedArray()}
    }

    override fun getArrayDates(counter: Int):Array<Array<String>>
    {
        var rawArr = resources.getStringArray(R.array.Dates)
        if(counter < rawArr.size) rawArr = rawArr.sliceArray(0 until (counter - 1))
        return Array(rawArr.size){ i -> rawArr[i].split(",").toTypedArray()}
    }

    override fun getImages():Array<Int>{
        return  arrayOf(R.drawable.pic2)
    }



}