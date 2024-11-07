plugins {
    id("io.papermc.sculptor.root") version "1.0.8"
    id("io.papermc.sculptor.version") version "1.0.8" apply false
}

val remapperArgs = mutableListOf(
    "--temp-dir={tempDir}",
    "--remapper-file={remapperFile}",
    "--mappings-file={mappingsFile}",
    "--params-file={paramsFile}",
    // "--constants-file={constantsFile}",
    "--output={output}",
    "--input={input}",
    "--input-classpath={inputClasspath}",
)
if (providers.gradleProperty("generateReports").getOrElse("false").toBooleanStrict()) {
    remapperArgs.addAll(listOf(
        "--reports-dir={reportsDir}",
        "--all-reports",
    ))
}
subprojects {
    ext {
        set("remapperArgs", remapperArgs)
    }
}
