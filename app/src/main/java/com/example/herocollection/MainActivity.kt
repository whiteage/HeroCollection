package com.example.herocollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.herocollection.view.AppNavigation
import com.example.herocollection.viewmodel.MainVM
import com.example.herocollection.viewmodel.MainVMFactory



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current

            val viewModel: MainVM = viewModel(
                factory = MainVMFactory(context)
            )


            AppNavigation(viewModel = viewModel)



        }
    }
}
