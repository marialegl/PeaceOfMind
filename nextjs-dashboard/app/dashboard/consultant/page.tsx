"use client";

import { useEffect, useState } from 'react';

interface Therapist {
  id: string;
  name: string;
  lastName: string;
  vocationalTraining: string;
  yearsOfExperience: number;
}

interface Consultant {
  id: string;
  name: string;
  lastName: string;
  birthday: string;
  sex: string;
  therapistName: string;
  therapist: Therapist;
}

export default function ConsultantPage() {
  const [consultants, setConsultants] = useState<Consultant[]>([]);

  useEffect(() => {
    async function fetchConsultants() {
      try {
        const response = await fetch('http://localhost:8080/consultants');
        if (!response.ok) {
          throw new Error('Error al obtener los datos');
        }
        const data = await response.json();
        setConsultants(data);
      } catch (error) {
        console.error('Error:', error);
      }
    }

    fetchConsultants();
  }, []);

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Lista de Consultores</h1>
      {consultants.map((consultant) => (
        <div key={consultant.id} className="bg-white shadow-md rounded-lg p-4 mb-4">
          <h2 className="text-xl font-semibold">{consultant.name} {consultant.lastName}</h2>
          <p>Fecha de nacimiento: {consultant.birthday}</p>
          <p>Sexo: {consultant.sex === 'F' ? 'Femenino' : 'Masculino'}</p>
          <h3 className="text-lg font-semibold mt-2">Terapeuta</h3>
          <p>{consultant.therapist.name} {consultant.therapist.lastName}</p>
          <p>Formación: {consultant.therapist.vocationalTraining}</p>
          <p>Años de experiencia: {consultant.therapist.yearsOfExperience}</p>
        </div>
      ))}
    </div>
  );
}
