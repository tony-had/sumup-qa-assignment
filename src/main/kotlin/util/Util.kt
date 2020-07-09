package util

import java.io.FileInputStream
import java.util.*

object Util {
    private var properties: Properties? = null

    private fun loadProperties(): Unit {
        properties = Properties()
        properties?.load(FileInputStream("config.properties"))
    }

    fun getProperties(property: String): String {
        loadProperties()
        return Util.properties?.getProperty(property).toString()
    }
}