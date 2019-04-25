package net.minpro.timermachine.view.dialog

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.theme_detail_card.*
import net.minpro.timermachine.MyApplication
import net.minpro.timermachine.R
import net.minpro.timermachine.data.ThemeData
import net.minpro.timermachine.viewmodel.MainViewModel

class ThemeSelectAdapter(val themeList: ArrayList<ThemeData>,
                         val viewModel: MainViewModel) : RecyclerView.Adapter<ThemeSelectAdapter.ViewHolder>() {

    private val appContext = MyApplication.appContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.theme_detail_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(VH: ViewHolder, position: Int) {
        VH.apply {
            val themeData = themeList[position]
            txtTheme.text = appContext.resources.getString(themeData.femaleName)
        }
    }

    override fun getItemCount(): Int {
        return themeList.size
    }

    inner class ViewHolder(override val containerView: View?): RecyclerView.ViewHolder(containerView!!), LayoutContainer {

    }
}
