import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty


class App(name: String, packages: List<String>, checked: Boolean = false) {

    private val appname = SimpleStringProperty()
    private val packagename = SimpleStringProperty()
    private val selected = SimpleBooleanProperty()

    init {
        appname.set(name)
        packagename.set(packages.joinToString("\n").trim())
        selected.set(checked)
    }

    fun appnameProperty(): StringProperty = appname

    fun packagenameProperty(): StringProperty = packagename

    fun selectedProperty(): BooleanProperty = selected
}
