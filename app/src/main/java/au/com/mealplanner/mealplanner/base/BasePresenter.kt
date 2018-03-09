package au.com.mealplanner.mealplanner.base

import java.lang.ref.WeakReference

open class BasePresenter<V> {

    private var view: WeakReference<V>? = null

    fun setView(view: V) {
        this.view = WeakReference(view)
    }

    fun getView(): V? {
        return view!!.get()
    }
}
