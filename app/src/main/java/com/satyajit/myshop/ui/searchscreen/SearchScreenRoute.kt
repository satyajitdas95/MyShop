package com.satyajit.myshop.ui.searchscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.satyajit.myshop.R
import com.satyajit.myshop.di.component.ApplicationComponent
import com.satyajit.myshop.ui.base.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow


@Composable
fun SearchScreenRoute(applicationComponent: ApplicationComponent,onClickOfProduct:(String)->Unit) {
    val viewModel: SearchViewModel =
        viewModel(factory = applicationComponent.getSearchViewModelFactory())

    val searchQuery = MutableStateFlow("")
    viewModel.search(searchQuery)

    val onSearchTextChanged:(String)-> Unit = {
        if(it.isNotEmpty()){
            searchQuery.value = it
        }else{
            viewModel.updateText("")
        }
    }

    val uiStateProducts = viewModel.uiState.collectAsState().value

    SearchScreen(uiStateProducts,
        placeholderText = stringResource(id = R.string.label_search_placeholder)
        , onSearchTextChanged = onSearchTextChanged, onClickOfProduct = onClickOfProduct)
}