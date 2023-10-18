import MiFieldSet from "./MiFieldSet"
import DatosPersonales from "./DatosPersonales"
import DatosEscolares from "./DatosEscolares"
function Formulario() {
    return(
        <>
        <form action="">
            {/*<MiFieldSet titulo = "Datos Personales" tx1 = "Nombre" txt2 = "Contraseña"/>*/}
            <DatosPersonales></DatosPersonales>
            <DatosEscolares></DatosEscolares>
            {/*<MiFieldSet titulo = "Datos Escolares" tx1 = "Carrera" txt2 = "Semestre"/>*/}
            <input type="submit" value="Enviar Datos"></input>
        </form>
        </>
    )
}

export default Formulario