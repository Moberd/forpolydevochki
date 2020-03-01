package ru.polydevochka.andreynikolaeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pics = arrayOf(R.drawable.pic2)
        val imagesViewAdapter:RecyclerView.Adapter<*> = ImageAdapter(pics)
        val imagesManager:RecyclerView.LayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        img_recycle.apply {
            setHasFixedSize(true)
            layoutManager = imagesManager
            adapter = imagesViewAdapter
        }

        val infos = GetArray(0)
        val infoViewAdapter: RecyclerView.Adapter<*> = InformationAdapter(infos)
        val infoManager: RecyclerView.LayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        info_recycle.apply {
            setHasFixedSize(true)
            layoutManager = infoManager
            adapter = infoViewAdapter

        }

        SetRecycleDates()

        button.setOnClickListener { p0 ->
            counter +=3
            SetRecycleDates()

            if(counter >= resources.getStringArray(R.array.Dates).size){
                val t:ViewGroup = p0?.parent as ViewGroup
                t.removeView(p0)
            }
        }

    }


    fun GetArray(num: Int):Array<Array<String>>
    {
        var rawArr = when(num){
            0 -> resources.getStringArray(R.array.Information)
            1 -> resources.getStringArray(R.array.Dates)
            else -> resources.getStringArray(R.array.Information)
        }

        if(num == 1){
            if(counter < rawArr.size){
                rawArr = rawArr.sliceArray(0 until (counter - 1))
            }
        }

        return Array(rawArr.size){ i -> rawArr[i].split(",").toTypedArray()}
    }

    fun SetRecycleDates()
    {
        val dates = GetArray(1)
        val dateViewAdapter:RecyclerView.Adapter<*> = DatesAdapter(dates)
        val dateManager: RecyclerView.LayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        dates_recycle.apply {
            setHasFixedSize(true)
            layoutManager = dateManager
            adapter = dateViewAdapter

        }
    }


}
