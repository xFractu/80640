import React, {useEffect, useState} from "react";
import { TextField, Button, Box } from "@mui/material"
import axios from "axios";

function Formulario(props){
    const  [Cargando, setCargando] = useState(false)
    const [datosFormulario, setDatosFormulario] = useState(
        {nombre: '',
        apellido: ''
    })

    /*const insertar = async () => {
        // Lógica para la acción de insertar
        console.log('Insertar');
        try{
            const response = await axios.get('http://localhost:4567/insertar',{params: datosFormulario})
            console.log('Insertar');
            console.log(response.data)
            return response.data
        } catch(error){
            throw error
        }
      }*/




    
    const hacerPeticionInsertar = async () => {
        try{
            const response = await axios.get('http://localhost:4567/insertar',{params: datosFormulario})
            console.log(response.data)
            return response.data
        } catch(error){
            throw error
        }
    }

    const hacerPeticionModificar = async () => {
        try{
            const response = await axios.get('http://localhost:4567/modificar',{params: datosFormulario})
            console.log(response.data)
            return response.data
        } catch(error){
            throw error
        }
    }

    const hacerPeticionEliminar = async () => {
        try{
            const response = await axios.get('http://localhost:4567/eliminar',{params: datosFormulario})
            console.log(response.data)
            return response.data
        } catch(error){
            throw error
        }
    }

    const hacerPeticionMostrar = async () => {
        try{
            const response = await axios.get('http://localhost:4567/consultar',{params: datosFormulario})
            console.log(response.data)
            return response.data
        } catch(error){
            throw error
        }
    }

    const cambiosFormulario = (evento) => {
        //console.log(evento.target)
        const {name,value} = evento.target
        setDatosFormulario ({...datosFormulario, [name]: value})
    }

    return (
        <>
        <h1>FrontEnd y BackEnd</h1>
        <form /*onSubmit={procesarFormulario}*/>
            <Box m={5}>
                <TextField label="Nombre:" variant ="outlined" fullWidth onChange={cambiosFormulario} name="nombre" value={datosFormulario.nombre}></TextField>
            </Box>
            <Box m={5}>
                <TextField label="Apellido:" variant="outlined" /*type="password"*/ fullWidth onChange={cambiosFormulario} name="apellido" value={datosFormulario.password}></TextField>
            </Box>
            <Box m={5}>
                <Button variant="contained" type="button" color="primary" onClick={hacerPeticionInsertar}>Insertar</Button>
            </Box>
            <Box m={5}>
                <Button variant="contained" type="button" color="primary" onClick={hacerPeticionModificar}>Modificar</Button>
            </Box>
            <Box m={5}>
                <Button variant="contained" type="button" color="primary" onClick={hacerPeticionMostrar}>Consultar</Button>
            </Box>
            <Box m={5}>
                <Button variant="contained" type="button" color="primary" onClick={hacerPeticionEliminar}>Eliminar</Button>
            </Box>
        </form>
        </>
    )
}

export default Formulario