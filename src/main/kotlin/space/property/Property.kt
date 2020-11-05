package space.property

import board.Space
import space.Ownable

interface Property : Space, Ownable {
    var group : PropertyGroup
}
