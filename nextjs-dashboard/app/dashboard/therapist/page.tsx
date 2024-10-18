"use client";

import { useEffect, useState } from 'react';

interface Therapist {
  id: string;
  name: string;
  lastName: string;
  vocationalTraining: string;
  yearsOfExperience: number;
  consultants: any[]; // Puedes definir una interfaz más específica si lo necesitas
}

export default function TherapistPage() {
  const [therapists, setTherapists] = useState<Therapist[]>([]);

  useEffect(() => {
    async function fetchTherapists() {
      try {
        const response = await fetch('http://localhost:8080/therapist');
        if (!response.ok) {
          throw new Error('Error al obtener los datos');
        }
        const data = await response.json();
        setTherapists(data);
      } catch (error) {
        console.error('Error:', error);
      }
    }

    fetchTherapists();
  }, []);

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Lista de Terapeutas</h1>
      {therapists.map((therapist) => (
        <div key={therapist.id} className="bg-white shadow-md rounded-lg p-4 mb-4">
          <h2 className="text-xl font-semibold">{therapist.name} {therapist.lastName}</h2>
          <p>Formación: {therapist.vocationalTraining}</p>
          <p>Años de experiencia: {therapist.yearsOfExperience}</p>
          <p>Número de consultores: {therapist.consultants.length}</p>
        </div>
      ))}
    </div>
  );
}
