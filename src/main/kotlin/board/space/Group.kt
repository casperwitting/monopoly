package board.space

class Group : PropertyGroup {
    override fun addProperty(property: Property) {
        property.group = this

        properties.add(property)
    }

    override fun addProperties(properties: List<Property>) {
        for (property : Property in properties) {
            addProperty(property)
        }
    }

    override val properties: MutableList<Property> = mutableListOf()
}