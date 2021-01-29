package com.sheenhill.rusuo.v2.index

import androidx.navigation.NavController
import com.sheenhill.common.fragment.K_BaseJetpackFragment
import com.sheenhill.common.fragment.K_DataBindingConfig
import com.sheenhill.rusuo.BR
import com.sheenhill.rusuo.R

class V2_IndexFragment : K_BaseJetpackFragment() {
    private lateinit var viewModel: IndexFragmentViewModel
    override fun initViewModel() {
        viewModel = IndexFragmentViewModel()
    }

    override fun getDataBindingConfig(): K_DataBindingConfig {
        return K_DataBindingConfig(R.layout.fragment_index_v2, BR.viewModel, viewModel)
                .addBindingParam(BR.listener, Listener())
                .addBindingParam(BR.navController, nav())
                .addBindingParam(BR.adapter, V2_BingPicAdapter(this))
    }

    override fun onStart() {
        super.onStart()
        viewModel.message.observe(this, {
            if (it == "jump") {
                viewModel.message.value=""  // 数据倒灌
                Listener().toChestFragment(nav())
            }
        })
    }

    class Listener {
        fun toChestFragment(navController: NavController) {
            navController.navigate(R.id.action_v2_MainFragment_to_ChestFragment)
        }
    }
}
