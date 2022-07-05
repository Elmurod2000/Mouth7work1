package com.example.Mouth7Work1.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.Mouth7Work1.R
import com.example.Mouth7Work1.databinding.ActivityMainBinding
import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.presentation.shopItemAdapter.ShopItemAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.task_container)
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopItemAdapter
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLauncher()
        initViewModel()
        initRecyclerView()
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun initListeners() {
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, TaskActivity::class.java)
            launcher.launch(intent)
        }
    }

    private fun initRecyclerView() {
        adapter = ShopItemAdapter()
        binding.taskRecycler.adapter = adapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val userText = it.data?.getStringExtra(USER_KEY)
                val userCount = it.data?.getIntExtra(USER_KEY_COUNT, 1)
                if (userText != null && userCount != null) {
                    viewModel.addShopItem(ShopItem(userText, userCount, enabled = false))
                }
            }
        }
    }

    companion object {
        const val USER_KEY = "product"
        const val USER_KEY_COUNT = "product count"
    }
}