package ru.polydevochka.andreynikolaeproject

public interface MainContract {

    interface View {

    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        
    }

    interface Repository {
        fun attachPresenter(presenter: Presenter)
        fun getArrayInfo():Array<Array<String>>
        fun getArrayDates(counter: Int):Array<Array<String>>
        fun getImages():Array<Int>
    }

}