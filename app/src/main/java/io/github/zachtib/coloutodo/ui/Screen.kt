package io.github.zachtib.coloutodo.ui

import io.github.zachtib.coloutodo.ui.main.MainFragment

sealed class Screen(val getFragment: () -> FragmentView) {
    object TodoList : Screen({ MainFragment.newInstance() })
}