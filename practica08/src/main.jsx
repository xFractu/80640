import React from 'react'
import ReactDOM from 'react-dom/client'
//import App from './App.jsx'
import './index.css'
//import MiFieldSet from './MiFieldSet'
import Formulario from './Formulario'
import DatosPersonales from './DatosPersonales'
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/*<App />*/}
    {/*<MiFieldSet titulo = "Datos Personales" tx1 = "Nombre" txt2 = "Contraseña"/>
    <MiFieldSet titulo = "Datos Escolares" tx1 = "Carrera" txt2 = "Semestre"/>
<input type="submit" value="Enviar Datos"></input>*/}
<Formulario></Formulario>
  </React.StrictMode>,
)
