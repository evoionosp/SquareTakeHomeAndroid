package com.example.squaretakehome.ui.employee_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.squaretakehome.ui.NoItemsMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun EmployeeListScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    viewModel: EmployeeListViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = { Text("Employees") },
            actions = {
                IconButton(onClick = { viewModel.getEmployees() }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }
            }

        )

        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(100.dp)
                )
            }
        } else {
            if (!state.data.isNullOrEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.data.size) { employee ->
                        EmployeeItem(state.data[employee])
                    }
                }
            } else {
                NoItemsMessage()
            }

            if(!state.error.isNullOrEmpty()) {
                LaunchedEffect(state, snackbarHostState) {
                    snackbarHostState.showSnackbar(
                        message = "Error: ${state.error}",
                        duration = SnackbarDuration.Long,
                        withDismissAction = false,
                        actionLabel = null
                    )
                }
            }
        }


    }

}