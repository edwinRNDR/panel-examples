import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.panel.controlManager
import org.openrndr.panel.elements.*
import org.openrndr.panel.style.*

fun main() = application {
    program {
        val state = object {
            var x: Double = 0.0
            var y: Double = 0.0
            var radius: Double = 0.0
        }

        val cm = controlManager {
            styleSheet(has class_ "container") {
                this.display = Display.FLEX
                this.flexDirection = FlexDirection.Row
                this.width = 100.percent
                this.height = 100.percent
            }

            styleSheet(has class_ "maximize") {
                this.flexGrow = FlexGrow.Ratio(1.0)
                this.height = 100.percent
            }

            styleSheet(has class_ "sidebar") {
                this.width = 200.px
                this.paddingBottom = 20.px
                this.paddingTop = 20.px
                this.paddingLeft = 20.px
                this.paddingRight = 20.px
                this.marginRight = 2.px
                this.height = 100.percent
                this.flexGrow = FlexGrow.Ratio(0.0)
                this.background = Color.RGBa(ColorRGBa.GRAY) // this is somewhat inconvenient
            }

            layout {
                div("container") {
                    div("sidebar") {
                        slider {
                            label = "x"
                            bind(state::x)
                        }
                        slider {
                            label = "y"
                            bind(state::y)
                        }

                        slider {
                            label = "radius"
                            bind(state::radius)
                            range = Range(0.0, 200.0)
                        }
                    }
                    canvas("maximize") {
                        draw { drawer ->
                            drawer.background(ColorRGBa.BLACK)
                            drawer.fill = ColorRGBa.PINK
                            drawer.circle(state.x * 30.0, state.y * 30.0,  state.radius)
                        }
                    }
                }
            }
        }
        extend(cm)
        extend {
            drawer.background(ColorRGBa.PINK)
        }
    }
}