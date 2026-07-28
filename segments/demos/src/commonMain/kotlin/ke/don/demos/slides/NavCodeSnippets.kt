package ke.don.demos.slides

const val LIST_DETAIL_CODE = """
val listDetailStrategy = rememberListDetailSceneStrategy()
NavDisplay(
    backstack = backstack,
    sceneStrategies = listOf(listDetailStrategy)
) { entry ->
    when (entry.key) {
        is ListKey -> NavEntry(
            entry, 
            metadata = listDetailStrategy.listPane()
        ) { ListScreen() }
        
        is DetailKey -> NavEntry(
            entry, 
            metadata = listDetailStrategy.detailPane()
        ) { DetailScreen() }
    }
}
"""

const val SUPPORTING_PANE_CODE = """
val supportingPaneStrategy = rememberSupportingPaneSceneStrategy()
NavDisplay(
    backstack = backstack,
    sceneStrategies = listOf(supportingPaneStrategy)
) { entry ->
    when (entry.key) {
        is MainKey -> NavEntry(
            entry, 
            metadata = supportingPaneStrategy.mainPane()
        ) { MainScreen() }
        
        is SupportKey -> NavEntry(
            entry, 
            metadata = supportingPaneStrategy.supportingPane()
        ) { SupportScreen() }
    }
}
"""

const val NAV_SUITE_CODE = """
NavigationSuiteScaffold(
    navigationSuiteItems = {
        item(
            icon = { Icon(Icons.Home, null) },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        item(
            icon = { Icon(Icons.Settings, null) },
            label = { Text("Settings") },
            selected = false,
            onClick = {}
        )
    }
) {
    // Screen Content
}
"""
