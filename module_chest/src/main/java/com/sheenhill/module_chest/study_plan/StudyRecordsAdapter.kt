package com.sheenhill.module_chest.study_plan

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sheenhill.common.base.SingleTypeBaseRVAdapter
import com.sheenhill.module_chest.R
import com.sheenhill.module_chest.databinding.ItemStudyRecordBinding
import com.sheenhill.module_chest.study_plan.db.PlanRecord

class StudyRecordsAdapter : SingleTypeBaseRVAdapter<PlanRecord, ItemStudyRecordBinding>() {

    override fun getLayoutResId(viewType: Int): Int {
        return R.layout.item_study_record
    }

    override fun onBindItem(binding: ItemStudyRecordBinding, item: PlanRecord, holder: RecyclerView.ViewHolder?) {
        binding.data = item
        binding.ivNote.setOnClickListener { v->
            val bundle= bundleOf("text" to item.plan.note)
            binding.root.findNavController().navigate(R.id.action_global_showTextDialog,bundle)
        }
    }
}
