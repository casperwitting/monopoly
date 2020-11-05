package space

interface PropertyGroup {
    fun addProperty(property: Property)
    fun addProperties(properties: List<Property>)
    val properties: List<Property>
}
