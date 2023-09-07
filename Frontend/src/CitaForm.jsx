import React, { useState } from "react";
import {useForm, Controller} from "react-hook-form";
import "react-datepicker/dist/react-datepicker.css";
import DatePicker from "react-datepicker";


export const CitaForm = () =>{
    const{handleSubmit, control, errors} = useForm();
    const horarioDisponible = [
    '10:00 AM', 
    '10:30 AM',
    '11:00 AM', 
    '11:30 AM',
    '12:00 AM'];
    const [selectedHora, setSelectedHora]= useState('');
    const [horariosDisponiblesFiltrados, setHorariosDisponiblesFiltrados]=useState([]);
    const handleFechaChange = (date) =>{
    const horariosFiltrados = horarioDisponible.filter((hora)=>{
    const horaDate =new Date(`${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}${hora}`);
        return horaDate.getHours() >= 10 && horaDate.getMinutes() === 0;
    }); 
    sethorariosDisponiblesFiltrados(horariosFiltrados);   
    }    

    const onSubmit = (data) =>{
    const horarioSeleccionado = selectedHora;
    };
    return(
        <form onSubmit={handleSubmit(onSubmit)}>
         <div>
            <label>
                Fecha de cita
            </label>
            <Controller
            name="fecha"
            control={control}
            render={({field})=>(
                <DatePicker
                selected={field.value}
                onChange={(date)=>field.onChange(date)}/>
            )}
         />   
         {errors.fecha && <p>{errors.fecha.message}</p>}
         </div>

         <div>
            <label>Selecciona un horario</label>
            <select
            value={selectedHora}
            onChange={(e)=>setSelectedHora(e.target.value)}
            required
            >
                <option value="" disabled>Selecciona un Horario</option>
                {horarioDisponible.map((hora)=>(
                    <option key={hora} value={hora}>
                        {hora}
                    </option>
                ))}
            </select>
            </div>
            <div>
                <label>Email</label>
                <input
                type="email"
                name="email"
                ref={register({required:"El campo es obligatorio",
                pattern:{
                    value:/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
            message:"Formato Incorrecto",},})}/>
            {errors.email &&<p>{errors.email.message}</p>}
            </div>
            <button type="submit">Reservar Cita</button>
            </form>
    );

}