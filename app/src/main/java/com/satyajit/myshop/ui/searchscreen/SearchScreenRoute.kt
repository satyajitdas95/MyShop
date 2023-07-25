@file:OptIn(ExperimentalCoroutinesApi::class)

package com.satyajit.myshop.ui.searchscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.satyajit.myshop.R
import com.satyajit.myshop.di.component.ApplicationComponent
import com.satyajit.myshop.ui.homescreen.HomeScreen
import com.satyajit.myshop.ui.homescreen.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn


@Composable
fun SearchScreenRoute(applicationComponent: ApplicationComponent) {
    val viewModel: SearchViewModel =
        viewModel(factory = applicationComponent.getSearchViewModelFactory())

//    val onSearchTextChanged:(String)-> Unit = {viewModel.updateSearchTextState(newValue = it)}

    val searchQuery = MutableStateFlow("")

    val onSearchTextChanged:(String)-> Unit = {
        searchQuery.value = it
    }

    viewModel.search(searchQuery)
//
//    SearchScreen(placeholderText = stringResource(id = R.string.label_search_placeholder), text = viewModel.searchTextState.value,onSearchTextChanged,{})
}