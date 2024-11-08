import io.papermc.sculptor.shared.util.MinecraftJarType

plugins {
    id("io.papermc.sculptor.version")
}

mache {
    minecraftVersion = projectDir.name
    minecraftJarType = MinecraftJarType.SERVER

    repositories.register("sonatype snapshots") {
        url = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
        includeGroups.add("org.vineflower")
    }

    @Suppress("UNCHECKED_CAST")
    remapperArgs.set(extra.get("remapperArgs") as List<String>)
}

dependencies {
    codebook("1.0.10")
    remapper(art("1.0.14"))
    decompiler(vineflower("1.11.0-20240911.205325-50"))
    parchment("1.17.1", "2021.12.12")
    compileOnly("org.jetbrains:annotations:24.0.1")
}
