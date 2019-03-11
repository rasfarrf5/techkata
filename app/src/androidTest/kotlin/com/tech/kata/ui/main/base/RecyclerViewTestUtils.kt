package com.tech.kata.ui.main.base

class RecyclerViewTestUtils {

    companion object {
        fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
            return RecyclerViewMatcher(recyclerViewId)
        }
    }
}
