package space

import board.Space

interface Property : Space, Ownable {
    var group : PropertyGroup
}
