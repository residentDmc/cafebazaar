package com.dev.alarmapplication.ui.view.adapter.report

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.databinding.ItemReportBinding
import com.dev.alarmapplication.interfaces.OnClickListenerAnyAndPosition
import com.dev.alarmapplication.utils.extention.*

class ReportAdapter(
    private val context: Context,
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    private var list: ArrayList<Report> = ArrayList()
    private lateinit var onClickListenerAnyAndPosition: OnClickListenerAnyAndPosition

    fun setOnClickListener(onClickListenerAnyAndPosition: OnClickListenerAnyAndPosition) {
        this.onClickListenerAnyAndPosition = onClickListenerAnyAndPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val itemReportBinding =
            ItemReportBinding.inflate(LayoutInflater.from(context), parent, false)
        return ReportViewHolder(itemReportBinding)

    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = list.size

    fun updateList(listReport: List<Report>) {
        list.clear()
        list.addAll(listReport)
        notifyDataSetChanged()
    }

    fun updateList(item: Report) {
        list.add(0,item)
        notifyDataSetChanged()
    }

    fun daleteList(item: Report) {
        list.remove(item)
        notifyDataSetChanged()
    }

    fun updateItemList(item: Report) {
        list.forEach {
            if (it.ids==item.ids){
                val index=list.indexOf(it)
                list[index] = item
            }
        }
        notifyDataSetChanged()
    }

    fun getList(): ArrayList<Report> {
       return list
    }

    inner class ReportViewHolder(private val binding: ItemReportBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(report: Report) {
            val result=report.ids+1
            binding.txtNumber.text = result.toString()
            binding.txtTypeOfDuties.text = report.type
            checkStatusReport(context,binding.txtCondition,report.state)
            initCreatedAtDateAndTimeLong(binding.txtDateOfRegister,report.date)
            initCreatedAtDateAndTimeLong(binding.txtDateOfReport,report.dateReport)
            checkDescription(context,binding.txtDescription,report.desc)
            binding.switchState.isChecked = report.state != 0
            binding.switchState.setOnCheckedChangeListener { compoundButton, b ->
                report.state= (if (b) 1 else 0)
                onClickListenerAnyAndPosition.onClickListenerAnyAndPosition(report,compoundButton.id)
            }
            binding.imgBtnEdit.setOnClickListener { onClickListenerAnyAndPosition.onClickListenerAnyAndPosition(report,it.id) }
            binding.imgBtnRemove.setOnClickListener { onClickListenerAnyAndPosition.onClickListenerAnyAndPosition(report,it.id) }
            binding.clParent.setOnClickListener { onClickListenerAnyAndPosition.onClickListenerAnyAndPosition(report,it.id) }
        }
    }
}