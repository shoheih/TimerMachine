package net.minpro.timermachine.view.dialog

import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import net.minpro.timermachine.R
import net.minpro.timermachine.viewmodel.MainViewModel

class SexSelectDialog: DialogFragment() {

    var selectedItemId = 0

    lateinit var viewModel: MainViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        val dialog = AlertDialog.Builder(activity!!).apply {
            setTitle(R.string.select_theme)
            setSingleChoiceItems(R.array.femail_list, selectedItemId) { dialog, which ->
                selectedItemId = which
                viewModel.setTheme(selectedItemId)
                dialog.dismiss()
            }
        }.create()

        return dialog
    }
}