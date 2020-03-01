package ru.polydevochka.andreynikolaeproject

class MainPresenter() : MainContract.Presenter {

    var viewIsAttached = false
    var mView: MainContract.View? = null

    private val mRepository: MainContract.Repository by lazy {
        MainRepository()
    }

    override fun attachView(view: MainContract.View) {
        viewIsAttached = true
        mView = view

        mRepository.attachPresenter(this)

    }

    override fun detachView() {
        viewIsAttached = false
        mView = null
    }







}