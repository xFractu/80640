function DatosEscolares(){
    return(
        <>
        <fieldset> 
                <legend>Datos Escolares</legend>
                <label htmlFor="carrera">Carrera:</label>
                <input type="text" id= "carrera"/>
                <label htmlFor="semestre">Semestre:</label>
                <input type="text" id= "semestre"/>
                <label htmlFor="mat">Matricula:</label>
                <input type="text" id= "mat"/>
            </fieldset>
        </>
    )
}