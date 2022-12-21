package live.shuuyu.astral.addons

abstract class AstralAddon {
    val name = String
    val description = String

    abstract fun onInitialize()
}