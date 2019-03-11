package com.tech.kata.ui.main.base

import android.content.res.Resources
import android.content.res.Resources.NotFoundException
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class RecyclerViewMatcher(private val recyclerViewId: Int) {

    fun atPosition(position: Int): Matcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, targetViewId: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            internal var resources: Resources? = null

            override fun describeTo(description: Description) {
                var idDescription = Integer.toString(recyclerViewId)
                if (this.resources != null) {
                    try {
                        idDescription = this.resources!!.getResourceName(recyclerViewId)
                    } catch (var4: NotFoundException) {
                        idDescription = String.format("%s (resource name not found)", recyclerViewId)
                    }

                }

                description.appendText("with id: $idDescription")
            }

            public override fun matchesSafely(view: View): Boolean {

                this.resources = view.resources

                val recyclerView: RecyclerView = view.rootView.findViewById<View>(recyclerViewId) as RecyclerView
                if (recyclerView == null
                        || recyclerView.id !== recyclerViewId
                        || null == recyclerView.findViewHolderForAdapterPosition(position)) {
                    return false
                }

                val childView = (if (recyclerView != null) recyclerView else throw NullPointerException("Expression 'recyclerView' must not be null")).findViewHolderForAdapterPosition(position)!!.itemView

                if (targetViewId == -1) {
                    return view === childView
                } else {
                    val targetView = childView.findViewById<View>(targetViewId)
                    return view === targetView
                }
            }
        }
    }
}
