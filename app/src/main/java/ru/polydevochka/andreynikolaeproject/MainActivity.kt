package ru.polydevochka.andreynikolaeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import ru.polydevochka.andreynikolaeproject.Adapters.DatesAdapter
import ru.polydevochka.andreynikolaeproject.Adapters.ImageAdapter
import ru.polydevochka.andreynikolaeproject.Adapters.InformationAdapter

class MainActivity : AppCompatActivity(), MainContract.View {

    var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpAll()
    }

    fun setUpAll(){
        setRecycleImages()
        setRecycleInfo()
        setRecycleDates()
        setUpListeners()
    }

    fun setRecycleDates()
    {
        val dates = getArray(1)
        val dateViewAdapter:RecyclerView.Adapter<*> =
            DatesAdapter(dates)
        val dateManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        dates_recycle.apply {
            setHasFixedSize(true)
            layoutManager = dateManager
            adapter = dateViewAdapter

        }
    }

    fun setRecycleImages(){
        val pics = arrayOf(R.drawable.pic2)
        val imagesViewAdapter:RecyclerView.Adapter<*> =
            ImageAdapter(pics)
        val imagesManager:RecyclerView.LayoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        img_recycle.apply {
            setHasFixedSize(true)
            layoutManager = imagesManager
            adapter = imagesViewAdapter
        }
    }

    fun setRecycleInfo(){
        val infos = getArray(0)
        val infoViewAdapter: RecyclerView.Adapter<*> =
            InformationAdapter(infos)
        val infoManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        info_recycle.apply {
            setHasFixedSize(true)
            layoutManager = infoManager
            adapter = infoViewAdapter

        }
    }

    fun setUpListeners(){
        button.setOnClickListener { p0 ->
            counter +=3
            setRecycleDates()

            if(counter >= resources.getStringArray(R.array.Dates).size) {
                val t:ViewGroup = p0?.parent as ViewGroup
                t.removeView(p0)
            }
        }
    }


    fun getArray(num: Int):Array<Array<String>>
    {
        var rawArr = when(num) {
            0 -> resources.getStringArray(R.array.Information)
            1 -> resources.getStringArray(R.array.Dates)
            else -> resources.getStringArray(R.array.Information)
        }

        if(num == 1) {
            if(counter < rawArr.size){
                rawArr = rawArr.sliceArray(0 until (counter - 1))
            }
        }

        return Array(rawArr.size){ i -> rawArr[i].split(",").toTypedArray()}
    }

}
