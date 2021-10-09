package com.nemo.androiduitraining.view.util

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment

@Navigator.Name("custom_fragment")
class CustomNavigator(
    private val context: Context,
    private val manager: FragmentManager,
    private val containerId: Int
) : FragmentNavigator(context, manager, containerId) {

    @Suppress("DEPRECATION")
    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        if (manager.isStateSaved) {
            return null
        }

        val className = if (destination.className[0] == '.') {
            context.packageName + destination.className
        } else {
            destination.className
        }

        val tag = destination.id.toString()
        val transaction = manager.beginTransaction()

        val currentFragment = manager.primaryNavigationFragment
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }

        val fragment = when (val destinationFragment = manager.findFragmentByTag(tag)) {
            null -> {
                val newFragment = instantiateFragment(context, manager, className, args)
                transaction.add(containerId, newFragment, tag)
                newFragment
            }
            else -> destinationFragment
        }
        fragment.arguments = args

        transaction.show(fragment)
        transaction.setPrimaryNavigationFragment(fragment)
        transaction.commit()

        return destination
    }
}

class CustomNavHostFragment : NavHostFragment() {
    override fun createFragmentNavigator(): Navigator<out FragmentNavigator.Destination> {
        return CustomNavigator(requireContext(), childFragmentManager, id)
    }
}
