import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.panel.controlManager
import org.openrndr.panel.elements.div
import org.openrndr.panel.elements.slider
import org.openrndr.panel.style.*

fun main() = application {
    program {
        val cm = controlManager {

            styleSheet(has class_ "container") {
                this.display = Display.FLEX
                this.flexDirection = FlexDirection.Row
                this.width = 100.percent
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
                this.background = Color.RGBa(ColorRGBa.GRAY) // this is somewhat inconvenient
            }

            layout {
                div("container") {

                    div("sidebar") {
                        for (i in 0 until 4) {
                            slider {
                                label = "slider"
                            }
                        }
                    }
                    div("sidebar") {
                        for (i in 0 until 4) {
                            slider {
                                label = "slider"
                            }
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