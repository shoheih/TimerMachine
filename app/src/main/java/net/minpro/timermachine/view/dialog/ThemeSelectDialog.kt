package net.minpro.timermachine.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import net.minpro.timermachine.MyApplication
import net.minpro.timermachine.viewmodel.MainViewModel

class ThemeSelectDialog: DialogFragment() {

    val appContext = MyApplication.appContext
    private val themeList = MyApplication.themeList
    private lateinit var viewModel: MainViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        val recyclerView = RecyclerView(appContext)
        with(recyclerView) {
            layoutManager = GridLayoutManager(appContext, 2)
            adapter = ThemeSelectAdapter(themeList, viewModel)
        }

        val dialog = AlertDialog.Builder(activity!!).apply {
            setTitle("女性を選択してください")
            setView(recyclerView)
        }.create()

        return dialog
    }

}