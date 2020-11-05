package space.property

interface PropertyGroup {
    fun addProperty(property: Property)
    fun addProperties(properties: List<Property>)
    val properties: List<Property>
}
