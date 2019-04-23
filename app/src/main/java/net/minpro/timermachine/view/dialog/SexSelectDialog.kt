package net.minpro.timermachine.view.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import net.minpro.timermachine.R

class SexSelectDialog: DialogFragment() {

    var selectedItemId = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = AlertDialog.Builder(activity!!).apply {
            setTitle("Sex")
            setSingleChoiceItems(R.array.sex_list, selectedItemId) { dialog, which ->
                selectedItemId = which
                dialog.dismiss()
            }
        }.create()
        return dialog
    }
}