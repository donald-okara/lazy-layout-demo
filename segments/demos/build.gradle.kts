
plugins {
    alias(libs.plugins.segmentConvention)
}

android{
    dependencies{
        debugImplementation(libs.bundles.preview)
    }
}